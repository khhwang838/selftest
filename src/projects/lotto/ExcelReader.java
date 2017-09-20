package projects.lotto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelReader {
	
	final private int INITIAL_ROW_INDEX = 3;
	final private int INITIAL_COL_INDEX = 13;
	final private int LAST_COL_INDEX = 18;	// EXCLUDING BONUS NUMBER
//	final private int LAST_COL_INDEX = 19;	// INCLUDING BONUS NUMBER
	
	public static int[][] data;
	public static int[][] bonusData;
	
	public Data collectStatisticalDataFromExcel(String xlsFilePath) {
		return collectDataFromExcel(getDataSheet(xlsFilePath), null);
	}
	public Data collectStatisticalDataFromExcel(String xlsFilePath, Integer recent) {
		return collectDataFromExcel(getDataSheet(xlsFilePath), recent);
	}
	
	private Data collectDataFromExcel(HSSFSheet sheet, Integer recent) {
		Data out = new Data();
		
		int[] data = new int[45];
		int[] bonusData1 = new int[45];
		ArrayList<Integer> data2 = new ArrayList<Integer>();
		ArrayList<Integer> bonusData2 = new ArrayList<Integer>();
		
		for(int i = 0; i < 45; i++){
			data2.add(0);
			bonusData2.add(0);
		}
		HSSFRow row = null;

		int lastRowNum;
		if(recent == null)
			lastRowNum = sheet.getLastRowNum();
		else
			lastRowNum = recent.intValue() + INITIAL_ROW_INDEX;
		
		ExcelReader.data = new int[lastRowNum - 2][6];
		ExcelReader.bonusData = new int[lastRowNum -2][1];
		
		int lastRowNumIndex = lastRowNum;
		int colIndex = 0;
		
		for( int i = INITIAL_ROW_INDEX; i <= lastRowNum ; i++){
			row = sheet.getRow(i);
			for(int j = INITIAL_COL_INDEX; j <= LAST_COL_INDEX; j++){
				int num = (int)row.getCell(j).getNumericCellValue(); 
				data[num-1] = data[num-1] + 1;
				data2.set(num-1, data2.get(num-1) + 1);
				ExcelReader.data[lastRowNumIndex-3][colIndex++] = num;
			}
			int num = (int)row.getCell(LAST_COL_INDEX + 1).getNumericCellValue();
			ExcelReader.bonusData[lastRowNumIndex-3][0] = num;
			bonusData1[num-1] = bonusData1[num-1] + 1;
			bonusData2.set(num-1, bonusData2.get(num-1) + 1);
			lastRowNumIndex--;
			colIndex = 0;
		}
		out.setData1(data);
		out.setData2(data2);
		out.setBonusData1(bonusData1);
		out.setBonusData2(bonusData2);
		
		return out;
	}
	
	private HSSFSheet getDataSheet(String filePath) {
		HSSFWorkbook book = null;
		HSSFSheet sheet = null;

		try {
			book = new HSSFWorkbook(new FileInputStream(new File(filePath)));
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일이 없습니다.");
		} catch (IOException e) {
			System.out.println(e);
		}
		
		sheet = book.getSheet("excel");
		
		return sheet;
		
	}
}
