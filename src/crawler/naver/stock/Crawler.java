package crawler.naver.stock;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.postgresql.util.PSQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crawler.naver.stock.domain.RecentOutput;
import crawler.naver.stock.domain.Stock;

public class Crawler {

	private final static Logger logger = LoggerFactory.getLogger(Crawler.class);

	private final static String INSERT_DATA = "INSERT INTO NAVER_STOCK "
			+ "(code, name, settlement_type, settlement_yyyymm, sales, business_profits, net_income, business_profits_rate, net_income_rate"
			+ ", roe, debt_rate, quick_rate, reserve_rate, eps, bps, dividends_per_share"
			+ ", market_value_dividend_rate, payout_rate) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static void main(String[] args) throws IOException, InterruptedException {
		String dataFilePath = "D:\\kihyun\\z99. temp\\상장법인목록2.xls";
		String destBaseUrl = "http://finance.naver.com/item/main.nhn?code=";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:postgresql://localhost/stock";
		String user = "stock";
		String password = "stock";
		int startStockItemRowNum = 2;
		Map<String, String> params = makeParamMap(dataFilePath, startStockItemRowNum);
		
		int processRowNum = startStockItemRowNum;
		for (String stockCode : params.keySet()) {
			++processRowNum;	// processRowNum은 엑셀파일에서의 열번호와 동일
			Document doc = Jsoup.connect(destBaseUrl + stockCode).get();
			Elements table = doc.select(".cop_analysis table tbody");

			Elements rowsData = table.select("tr"); // Get every data rows
			Element headerRow = null;
			try {
				headerRow = doc.select(".cop_analysis thead tr").get(1);
			} catch (Exception e) {
				continue;
			}

			Stock stock = new Stock(stockCode, params.get(stockCode));
			List<RecentOutput> roList = stock.getRo();

			// 최근 실적
			for (int colIndex = 0; colIndex < 10; colIndex++) {

				RecentOutput recentOutput = new RecentOutput();

				// 결산년월 구하기
				String yyyyMM = headerRow.select("th").get(colIndex).html();
				if ( yyyyMM.length() < 7 ) {
					continue;
				}
				yyyyMM = yyyyMM.substring(0, 7); // 2017.12<em>(E)</em> 처리
				recentOutput.setSettlementType(getSettlementType(colIndex));
				recentOutput.setSettlementYyyyMm(yyyyMM);
				
				boolean validNumbers = false;
				for (int rowIndex = 0; rowIndex < rowsData.size(); rowIndex++) {
					
					Element el = rowsData.get(rowIndex);
					Element tdData = el.select("td").get(colIndex);
					switch (rowIndex) {
					case 0:
						int sales = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setSales(sales);
						validNumbers = sales > 0 || sales < 0 ? true : validNumbers;
						break;
					case 1:
						int businessProfits = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setBusinessProfits(businessProfits);
						validNumbers = businessProfits > 0 || businessProfits < 0 ? true : validNumbers;
						break;
					case 2:
						int netIncome = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setNetIncome(netIncome);
						validNumbers = netIncome > 0 || netIncome < 0 ? true : validNumbers;
						break;
					case 3:
						float businessProfitsRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setBusinessProfitsRate(businessProfitsRate);
						validNumbers = businessProfitsRate > 0 || businessProfitsRate < 0 ? true : validNumbers;
						break;
					case 4:
						float netIncomeRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setNetIncomeRate(netIncomeRate);
						validNumbers = netIncomeRate > 0 || netIncomeRate < 0 ? true : validNumbers;
						break;
					case 5:
						float roe = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setRoe(roe);
						validNumbers = roe > 0 || roe < 0 ? true : validNumbers;
						break;
					case 6:
						float debtRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setDebtRate(debtRate);
						validNumbers = debtRate > 0 || debtRate < 0 ? true : validNumbers;
						break;
					case 7:
						float quickRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setQuickRate(quickRate);
						validNumbers = quickRate > 0 || quickRate < 0 ? true : validNumbers;
						break;
					case 8:
						float reserveRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setReserveRate(reserveRate);
						validNumbers = reserveRate > 0 || reserveRate < 0 ? true : validNumbers;
						break;
					case 9:
						int eps = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setEps(eps);
						validNumbers = eps > 0 || eps < 0 ? true : validNumbers;
						break;
					case 10:
						int bps = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setBps(bps);
						validNumbers = bps > 0 || bps < 0 ? true : validNumbers;
						break;
					case 11:
						int dividendsPerShare = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setDividendsPerShare(dividendsPerShare);
						validNumbers = dividendsPerShare > 0 || dividendsPerShare < 0 ? true : validNumbers;
						break;
					case 12:
						float marketValueDividendRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setMarketValueDividendRate(marketValueDividendRate);
						validNumbers = marketValueDividendRate > 0 || marketValueDividendRate < 0 ? true : validNumbers;
						break;
					case 13:
						float payoutRatio = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setPayoutRatio(payoutRatio);
						validNumbers = payoutRatio > 0 || payoutRatio < 0 ? true : validNumbers;
						break;
					default:
						break;
					}
				}
				if ( validNumbers ) {
					roList.add(recentOutput);
				}
			}
			
			// 종목 단위로 데이터베이스에 저장
			int index = 0;
			try {
				con = DriverManager.getConnection(url, user, password);
				stmt = con.prepareStatement(INSERT_DATA);
				
				List<RecentOutput> recentOutputs = stock.getRo();
				for ( int j=0; j < recentOutputs.size(); j++ ) {
					stmt.setString(1, stock.getCode());
					stmt.setString(2, stock.getName());
					
					stmt.setString(3, recentOutputs.get(j).getSettlementType());
					stmt.setString(4, recentOutputs.get(j).getSettlementYyyyMm());
					stmt.setString(5, String.valueOf(recentOutputs.get(j).getSales()));
					stmt.setString(6, String.valueOf(recentOutputs.get(j).getBusinessProfits()));
					stmt.setString(7, String.valueOf(recentOutputs.get(j).getNetIncome()));
					stmt.setString(8, String.valueOf(recentOutputs.get(j).getBusinessProfitsRate()));
					stmt.setString(9, String.valueOf(recentOutputs.get(j).getNetIncomeRate()));
					stmt.setString(10, String.valueOf(recentOutputs.get(j).getRoe()));
					stmt.setString(11, String.valueOf(recentOutputs.get(j).getDebtRate()));
					stmt.setString(12, String.valueOf(recentOutputs.get(j).getQuickRate()));
					stmt.setString(13, String.valueOf(recentOutputs.get(j).getReserveRate()));
					stmt.setString(14, String.valueOf(recentOutputs.get(j).getEps()));
					stmt.setString(15, String.valueOf(recentOutputs.get(j).getBps()));
					stmt.setString(16, String.valueOf(recentOutputs.get(j).getDividendsPerShare()));
					stmt.setString(17, String.valueOf(recentOutputs.get(j).getMarketValueDividendRate()));
					stmt.setString(18, String.valueOf(recentOutputs.get(j).getPayoutRatio()));
					
					stmt.addBatch();
				}
				
//					if ( index % 200 == 0 ) {
//						stmt.executeBatch();
//						stmt.clearBatch();
//						con.commit();
//					}
				stmt.executeBatch();
				stmt.clearBatch();
//				con.commit();	// auto-commit is true by default
			
			} catch (SQLException e) {
				logger.error("Inserting exception: ERR_CODE: {}, ERR_MSG: {}, {}", e.getErrorCode(), e.getMessage(), stock, e);
				while( e.getNextException() != null ) {
					e = e.getNextException();
					logger.error("ERR_CODE: {}, ERR_MSG: {}", e.getErrorCode(), e.getMessage(), e);
				}
			} finally {
				try {
					if ( rs != null ) rs.close();
					if ( stmt != null ) stmt.close();
					if ( con != null ) con.close();
				} catch (Exception e) {
					logger.error("Closeable objects closing error: {}", e);
				}
			}
			logger.info("Processed({}) : {} {}", processRowNum, stock.getName(), stock.getCode());
			
			Thread.sleep(randomTime());
		}
	}

	private static String getSettlementType(int colIndex) {
		if ( colIndex < 4 ) return "year";
		return "quarter";
	}

	private static String getValueStringFromTd(Element td) {
		String tdStr = "";
		tdStr = td.html();
		if (td.html().contains("em")) {
			tdStr = td.select("em").html();
		}
		tdStr = tdStr.replaceAll(",", "");
		tdStr = ("-".equals(tdStr) || "".equals(tdStr) || "&nbsp;".equals(tdStr) ? "0" : tdStr);
		return tdStr;
	}

	private static int randomTime() {
		int min = 5, max = 15;

		return (int) (Math.random() * max + min) * 1000;
	}

	private static Map<String, String> makeParamMap(String filePath, int startStockItemRowNum) throws IOException {

		// 종목 코드 읽어와서 Map에 저장하기
		FileInputStream fis = new FileInputStream(filePath);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		int rowindex = 0;
		int companyNameIdx = 0;
		int companyCodeIdx = 1;

		HSSFSheet sheet = workbook.getSheet("상장법인목록");

		Map<String, String> result = new LinkedHashMap<>();
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = startStockItemRowNum + 1; rowindex < rows; rowindex++) {
			// 행을 읽는다
			HSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀값을 읽는다
				HSSFCell cell = row.getCell(companyNameIdx);
				// 셀이 빈값일경우를 위한 널체크
				if (cell == null) {
					continue;
				} else {
					String name = cell.getStringCellValue();
					String code = row.getCell(companyCodeIdx).getStringCellValue();
					result.put(code, name);
				}
			}
		}
		return result;
	}
}
