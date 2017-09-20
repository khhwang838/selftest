package projects.lotto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DataFileHandler {
	
	private final String dataFilePath;
	
	public DataFileHandler(String txtFilePath) {
		this.dataFilePath = txtFilePath;
		
	}
	public void makeDataFile(){
		if(checkDataFile()){
			try {
				appendData();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				createDataFile();
//				printDataFile();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private boolean checkDataFile(){
		try{
			File file = new File( dataFilePath);
			return file.exists();
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	private void appendData() throws Exception{
		
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(dataFilePath, true));
		// 전체 data 읽어와서 파일에 추가하기
		// 회차:번호:
		int thNum = CalcUtil.getRecentThNum();
		int loopCount = getNumOfData2Get(thNum);
		if(loopCount == 0){
			writeFile.close();
			return;
		}
		System.out.println("appending data...");
		while(loopCount-- > 0){
			writeFile = new BufferedWriter(new FileWriter(dataFilePath, true));
			String lineData = (thNum - loopCount) + ":" + Arrays.toString(CalcUtil.getWinNumber(thNum - loopCount)) + System.getProperty("line.separator");
//			System.out.println(lineData);
			writeFile.append(lineData);
			writeFile.close();
		}
	}
	private int getNumOfData2Get(int thNum) throws Exception{
		int result = 0;
		BufferedReader reader = new BufferedReader(new FileReader(dataFilePath));
		String lineData = reader.readLine();
		String tmp = null;
		while(lineData != null){
			lineData = reader.readLine();
			if(lineData != null)
				tmp = lineData;
		}
		reader.close();
		lineData = tmp;
		if(lineData != null && lineData.length() > 0){
			int lastThNum = Integer.parseInt(lineData.split(Pattern.quote(":"))[0]);
			result = thNum - lastThNum;
		}else{
			createDataFile();
		}
		return result;
	}
	private void createDataFile() throws Exception {
		System.out.println("creating data file ....");
		File file = new File(dataFilePath);
		file.createNewFile();
		
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(dataFilePath, true));
		// 전체 data 읽어와서 파일에 추가하기
		// 회차:번호:
		int recentThNum = CalcUtil.getRecentThNum();
		int thNum = 1;
		while(recentThNum >= thNum){
			writeFile = new BufferedWriter(new FileWriter(dataFilePath, true));
//			System.out.println(thNum + ":" + Arrays.toString(CalcUtil.getWinNumber(thNum--)) + System.getProperty("line.separator"));
			writeFile.append(thNum + ":" + Arrays.toString(CalcUtil.getWinNumber(thNum)) + System.getProperty("line.separator"));
			writeFile.close();
			++thNum;
		}
	}
	public void printDataFile() throws IOException{
		System.out.println("printing data file ....");
		// 읽어와서 출력하기
		BufferedReader fileReader = new BufferedReader(new FileReader(dataFilePath));
		
		String s;
		while((s = fileReader.readLine()) != null){
			System.out.println(s);
		}
		fileReader.close();
	}
	
}
