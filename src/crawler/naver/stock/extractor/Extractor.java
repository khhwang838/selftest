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
		// 1. DB에서 Stock정보 조회해서  List<Stock> 만들기
		//	settlement_type별, settlement_yyyymm 순서대로 조회
		Collection<Stock> stocks = getStockList();
		
		// 2. 원하는 전략을 이용하여 종목 추출하기
		NetIncomeStrategy nis = new NetIncomeStrategy();
		List<Stock> extracted = nis.extract(stocks);
		for (Stock stock : extracted) {
			logger.info("{} {}", stock.getCode(), stock.getName() );
		}
		
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
            
            while ( rs.next() ) {
            	String code = rs.getString(IConstants.ITEM.CODE);
            	String name = rs.getString(IConstants.ITEM.NAME);
            	
            	Stock stock = null;
            	if ( !stocks.containsKey(code)) {
            		stock = new Stock(code, name);
            		stocks.put(code, stock);
            	} else {
            		stock = stocks.get(code);
            	}
            	            	
            	String type = rs.getString(IConstants.ITEM.SETTLEMENT_TYPE);
            	RecentOutput ro = new RecentOutput();
            	if ( IConstants.TYPE.YEAR.equals(type) ) {
            		ro.setSettlementType(IConstants.TYPE.YEAR);
            	} else {
            		ro.setSettlementType(IConstants.TYPE.QUARTER);
            	}
            	String date = rs.getString(IConstants.ITEM.SETTLEMENT_YYYYMM);
            	ro.setSettlementYyyyMm(date);
            	String bps = rs.getString(IConstants.ITEM.BPS);
            	ro.setBps(Integer.valueOf(bps));
            	String eps = rs.getString(IConstants.ITEM.EPS);
            	ro.setEps(Integer.valueOf(eps));
            	String bp = rs.getString(IConstants.ITEM.BUSINESS_PROFITS);
            	ro.setBusinessProfits(Integer.valueOf(bp));
            	String bpr = rs.getString(IConstants.ITEM.BUSINESS_PROFITS_RATE);
            	ro.setBusinessProfitsRate(Float.valueOf(bpr));
            	String dr = rs.getString(IConstants.ITEM.DEBT_RATE);
            	ro.setDebtRate(Float.valueOf(dr));
            	String dps = rs.getString(IConstants.ITEM.DIVIDENDS_PER_SHARE);
            	ro.setDividendsPerShare(Integer.valueOf(dps));
            	String ni = rs.getString(IConstants.ITEM.NET_INCOME);
            	ro.setNetIncome(Integer.valueOf(ni));
            	String nir = rs.getString(IConstants.ITEM.NET_INCOME_RATE);
            	ro.setNetIncomeRate(Float.valueOf(nir));
            	String pr = rs.getString(IConstants.ITEM.PAYOUT_RATE);
            	ro.setPayoutRate(Float.valueOf(pr));
            	String qr = rs.getString(IConstants.ITEM.QUICK_RATE);
            	ro.setQuickRate(Float.valueOf(qr));
            	String rr = rs.getString(IConstants.ITEM.RESERVE_RATE);
            	ro.setReserveRate(Float.valueOf(rr));
            	String roe = rs.getString(IConstants.ITEM.ROE);
            	ro.setRoe(Float.valueOf(roe));
            	String sales = rs.getString(IConstants.ITEM.SALES);
            	ro.setSales(Integer.valueOf(sales));
            	String mvdr = rs.getString(IConstants.ITEM.MARKET_VALUE_DIVIDEND_RATE);
            	ro.setMarketValueDividendRate(Float.valueOf(mvdr));
            	
            	stock.getRo().add(ro);
            }
		} catch (Exception e) {
			logger.error("{}",e);
		}
		
		return stocks.values();
	}
}
