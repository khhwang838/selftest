package crawler.naver.stock;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.piccolo.util.DuplicateKeyException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crawler.naver.stock.domain.RecentOutput;
import crawler.naver.stock.domain.Stock;

public class Crawler {

	private final static Logger logger = LoggerFactory.getLogger(Crawler.class);

	private final static String INSERT_DATA = "INSERT INTO NAVER_STOCK "
			+ "(code, name, settlement_type, settlement_yyyymm, sales, business_profits, net_income, business_profits_rate, net_income_rate"
			+ ", roe, debt_rate, quick_rate, reserve_rate, eps, bps, dividends_per_share" + ", market_value_dividend_rate, payout_rate) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static void main(String[] args) throws IOException, InterruptedException {
		String dataFilePath = "/Users/KH/git/selftest/src/crawler/naver/stock/상장법인목록_180617.xlsx";
		String destBaseUrl = "http://finance.naver.com/item/main.nhn?code=";
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:postgresql://localhost/stock";
		String user = "stock";
		String password = "stock";
		final int startStockItemRowNum = 2;
		Map<String, String> params = makeParamMap(dataFilePath, startStockItemRowNum);

		logger.debug("Read data from file. cnt:{}, {}", params.keySet().size(), params);

		int processRowNum = startStockItemRowNum;
		for (String stockCode : params.keySet()) {
			++processRowNum; // processRowNum은 엑셀파일에서의 열번호와 동일
			logger.debug("Processing stock. name:{}, code:{}", params.get(stockCode), stockCode);
			Document doc = Jsoup.connect(destBaseUrl + stockCode).get();
			// logger.debug("--------------------------------------------------");
			// logger.debug("{}", doc.toString());

			Elements table = doc.select(".cop_analysis table tbody");

			Elements rowsData = table.select("tr"); // Get every data rows
			Element headerRow = null;
			try {
				headerRow = doc.select(".cop_analysis thead tr").get(1);
			} catch (Exception e) {
				// 읽어올 정보가 없는 경우
				Thread.sleep(randomTimeForSleep() / 2);
				continue;
			}

			Stock stock = new Stock(stockCode, params.get(stockCode));
			List<RecentOutput> recentOutputs = stock.getRecentOutputs();

			// 최근 실적
			for (int colIndex = 0; colIndex < 10; colIndex++) {

				// 결산년월 구하기
				String yyyyMM = headerRow.select("th").get(colIndex).html();
				if (yyyyMM.length() < 7) {
					continue;
				}
				// System.out.println(yyyyMM);
				yyyyMM = yyyyMM.substring(0, 7); // 2017.12<em>(E)</em> 처리

				RecentOutput recentOutput = new RecentOutput();
				recentOutput.setSettlementType(getSettlementType(colIndex));
				recentOutput.setSettlementYyyyMm(yyyyMM);

				boolean hasAtLeastOneValidNumber = false;
				for (int rowIndex = 0; rowIndex < rowsData.size(); rowIndex++) {

					Element el = rowsData.get(rowIndex);
					Element tdData = el.select("td").get(colIndex);

					// System.out.println("tdData: " + tdData.toString());

					switch (rowIndex) {
					// 네이버 증권에서 종목 상세 정보 조회 테이블(기업실적분석)의 내용 기준
					// 네이버증권_기업실적분석.png 파일 참조
					case 0:
						int sales = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setSales(sales);
						hasAtLeastOneValidNumber = sales != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 1:
						int businessProfits = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setBusinessProfits(businessProfits);
						hasAtLeastOneValidNumber = businessProfits != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 2:
						int netIncome = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setNetIncome(netIncome);
						hasAtLeastOneValidNumber = netIncome != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 3:
						float businessProfitsRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setBusinessProfitsRate(businessProfitsRate);
						hasAtLeastOneValidNumber = businessProfitsRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 4:
						float netIncomeRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setNetIncomeRate(netIncomeRate);
						hasAtLeastOneValidNumber = netIncomeRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 5:
						float roe = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setRoe(roe);
						hasAtLeastOneValidNumber = roe != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 6:
						float debtRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setDebtRate(debtRate);
						hasAtLeastOneValidNumber = debtRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 7:
						float quickRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setQuickRate(quickRate);
						hasAtLeastOneValidNumber = quickRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 8:
						float reserveRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setReserveRate(reserveRate);
						hasAtLeastOneValidNumber = reserveRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 9:
						int eps = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setEps(eps);
						hasAtLeastOneValidNumber = eps != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 10:
						int bps = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setBps(bps);
						hasAtLeastOneValidNumber = bps != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 11:
						int dividendsPerShare = Integer.valueOf(getValueStringFromTd(tdData));
						recentOutput.setDividendsPerShare(dividendsPerShare);
						hasAtLeastOneValidNumber = dividendsPerShare != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 12:
						float marketValueDividendRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setMarketValueDividendRate(marketValueDividendRate);
						hasAtLeastOneValidNumber = marketValueDividendRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					case 13:
						float payoutRate = Float.valueOf(getValueStringFromTd(tdData));
						recentOutput.setPayoutRate(payoutRate);
						hasAtLeastOneValidNumber = payoutRate != 0 ? true : hasAtLeastOneValidNumber;
						break;
					default:
						break;
					}
				}
				if (hasAtLeastOneValidNumber) {
					logger.debug("[{}] Adding recent output. {}", stock.getName(), recentOutput);
					recentOutputs.add(recentOutput);
				}
			}

			// 종목 단위로 데이터베이스에 저장
			try {
				con = DriverManager.getConnection(url, user, password);
				stmt = con.prepareStatement(INSERT_DATA);

				// List<RecentOutput> recentOutputs = stock.getRecentOutputs();
				for (int j = 0; j < recentOutputs.size(); j++) {
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
					stmt.setString(18, String.valueOf(recentOutputs.get(j).getPayoutRate()));

					stmt.addBatch();
				}

				// if ( index % 200 == 0 ) {
				// stmt.executeBatch();
				// stmt.clearBatch();
				// con.commit();
				// }
				stmt.executeBatch();
				stmt.clearBatch();
				// con.commit(); // Commented out because of "Cannot commit when auto-commit is enabled." error message.

			} catch (SQLException e) {
				logger.error("SQLstate:{}, errorMsg:{}", e.getSQLState(), e.getMessage());
				e.printStackTrace();
				// logger.error("Inserting exception: ERR_CODE: {}, ERR_MSG: {}, {}", e.getErrorCode(), e.getMessage(), stock, e);
				// while( e.getNextException() != null ) {
				// e = e.getNextException();
				// logger.error("ERR_CODE: {}, ERR_MSG: {}", e.getErrorCode(), e.getMessage(), e);
				// }
			} finally {
				try {
					if (rs != null)
						rs.close();
					if (stmt != null)
						stmt.close();
					if (con != null)
						con.close();
				} catch (Exception e) {
					logger.error("Closeable objects closing error: {}", e);
				}
			}
			logger.info("Processed({}) : {}", processRowNum, stock);

			Thread.sleep(randomTimeForSleep());
		}
	}

	private static String getSettlementType(int colIndex) {
		if (colIndex < 4)
			return "year";
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

	private static int randomTimeForSleep() {
		int min = 5, max = 15;
		int sleepMillis = (int) (Math.random() * max + min) * 1000;
		logger.debug("Sleeping {} seconds.", sleepMillis);
		return sleepMillis;
	}

	private static Map<String, String> makeParamMap(String filePath, int startStockItemRowNum) throws IOException {

		// 종목 코드 읽어와서 Map에 저장하기
		logger.info("Reading stock code data file : {}", filePath);
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int rowindex = 0;

		/*
		 * 한국거래소 기업공시채널 http://kind.krx.co.kr/corpgeneral/corpList.do?method=loadInitPage 에서 다운로드 받은 엑셀 파일 기준(첫 번째 컬럼:회사명, 두 번째 컬럼:종목코드)
		 */
		int companyNameIdx = 0;
		int companyCodeIdx = 1;

		XSSFSheet sheet = workbook.getSheetAt(1);

		Map<String, String> result = new LinkedHashMap<>();
		// 행의 수
		int rows = sheet.getPhysicalNumberOfRows();
		for (rowindex = startStockItemRowNum + 1; rowindex < rows; rowindex++) {
			// 행을 읽는다
			XSSFRow row = sheet.getRow(rowindex);
			if (row != null) {
				// 셀값을 읽는다
				XSSFCell cell = row.getCell(companyNameIdx);
				// 셀이 빈값일경우를 위한 널체크
				if (cell == null) {
					continue;
				} else {
					String name = cell.getStringCellValue();
					String code = String.valueOf((int) row.getCell(companyCodeIdx).getNumericCellValue());
					code = paddingZerosIfNeeded(code);
					result.put(code, name);
				}
			}
		}
		return result;
	}

	private static String paddingZerosIfNeeded(String code) {
		// 종목코드의 자리수를 6자리로 만들기 위한 메서드
		while(code.length() < 6){
			code = "0" + code;
		}
		return code;
	}
}
