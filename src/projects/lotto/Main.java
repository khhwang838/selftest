package projects.lotto;




public class Main {
	
	public static void main(String[] args) {
		
//		String filePath = "C:\\Users\\User\\Dropbox\\Public\\Selfstudy\\Data\\excel.xls";
//		String txtFilePath = "C:\\Users\\User\\Dropbox\\Public\\Selfstudy\\Data\\lotto.txt";
//		String filePath = "E:\\Dropbox\\Public\\Selfstudy\\Data\\excel.xls";
//		String txtFilePath = "E:\\Dropbox\\Public\\Selfstudy\\Data\\lotto.txt";
		String filePath = "/Users/KH/Dropbox/Public/Selfstudy/Data/excel.xls";
		String txtFilePath = "/Users/KH/Dropbox/Public/Selfstudy/Data/lotto.txt";
		
		DataFileHandler dfh = new DataFileHandler(txtFilePath);
		dfh.makeDataFile();
		
		ExcelReader excelReader = new ExcelReader();
		final Data collectedData = excelReader.collectStatisticalDataFromExcel(filePath);
		CalcUtil.calcNextLottoNum(collectedData);
		
	}

	
}
