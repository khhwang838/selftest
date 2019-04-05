package crawler.naver.stock.extractor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crawler.naver.stock.IConstants;
import crawler.naver.stock.domain.RecentOutput;
import crawler.naver.stock.domain.Stock;

public class Extractor {

	private final static Logger logger = LoggerFactory.getLogger(Extractor.class);

	public static void main(String[] args) {
		// 1. DB에서 Stock정보 조회해서 List<Stock> 만들기
		// settlement_type별, settlement_yyyymm 순서대로 조회
		Collection<Stock> stocks = getStockList();

		// 2. 원하는 전략을 이용하여 종목 추출하기
		IExtractStrategy nis = new NetIncomeStrategy();
		List<Stock> extracted = nis.extract(stocks);
		for (Stock stock : extracted) {
			logger.info("{} {}", stock.getCode(), stock.getName());
		}
		logger.info("Extracted finished.");
	}

	private static Collection<Stock> getStockList() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String url = "jdbc:postgresql://localhost/stock";
		String user = "stock";
		String password = "stock";

		Map<String, Stock> stocks = new LinkedHashMap<String, Stock>();
		try {
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from naver_stock order by code, settlement_type, settlement_yyyymm");

			while (rs.next()) {
				String code = rs.getString(IConstants.ITEM.CODE);
				String name = rs.getString(IConstants.ITEM.NAME);

				Stock stock = null;
				if (!stocks.containsKey(code)) {
					stock = new Stock(code, name);
					stocks.put(code, stock);
				} else {
					stock = stocks.get(code);
				}

				String type = rs.getString(IConstants.ITEM.SETTLEMENT_TYPE);
				RecentOutput recentOutput = new RecentOutput();
				if (IConstants.TYPE.YEAR.equals(type)) {
					recentOutput.setSettlementType(IConstants.TYPE.YEAR);
				} else {
					recentOutput.setSettlementType(IConstants.TYPE.QUARTER);
				}
				String date = rs.getString(IConstants.ITEM.SETTLEMENT_YYYYMM);
				recentOutput.setSettlementYyyyMm(date);
				String bps = rs.getString(IConstants.ITEM.BPS);
				recentOutput.setBps(Integer.valueOf(bps));
				String eps = rs.getString(IConstants.ITEM.EPS);
				recentOutput.setEps(Integer.valueOf(eps));
				String bp = rs.getString(IConstants.ITEM.BUSINESS_PROFITS);
				recentOutput.setBusinessProfits(Integer.valueOf(bp));
				String bpr = rs.getString(IConstants.ITEM.BUSINESS_PROFITS_RATE);
				recentOutput.setBusinessProfitsRate(Float.valueOf(bpr));
				String dr = rs.getString(IConstants.ITEM.DEBT_RATE);
				recentOutput.setDebtRate(Float.valueOf(dr));
				String dps = rs.getString(IConstants.ITEM.DIVIDENDS_PER_SHARE);
				recentOutput.setDividendsPerShare(Integer.valueOf(dps));
				String ni = rs.getString(IConstants.ITEM.NET_INCOME);
				recentOutput.setNetIncome(Integer.valueOf(ni));
				String nir = rs.getString(IConstants.ITEM.NET_INCOME_RATE);
				recentOutput.setNetIncomeRate(Float.valueOf(nir));
				String pr = rs.getString(IConstants.ITEM.PAYOUT_RATE);
				recentOutput.setPayoutRate(Float.valueOf(pr));
				String qr = rs.getString(IConstants.ITEM.QUICK_RATE);
				recentOutput.setQuickRate(Float.valueOf(qr));
				String rr = rs.getString(IConstants.ITEM.RESERVE_RATE);
				recentOutput.setReserveRate(Float.valueOf(rr));
				String roe = rs.getString(IConstants.ITEM.ROE);
				recentOutput.setRoe(Float.valueOf(roe));
				String sales = rs.getString(IConstants.ITEM.SALES);
				recentOutput.setSales(Integer.valueOf(sales));
				String mvdr = rs.getString(IConstants.ITEM.MARKET_VALUE_DIVIDEND_RATE);
				recentOutput.setMarketValueDividendRate(Float.valueOf(mvdr));

				stock.getRecentOutputs().add(recentOutput);
			}
		} catch (Exception e) {
			logger.error("{}", e);
		}

		return stocks.values();
	}
}
