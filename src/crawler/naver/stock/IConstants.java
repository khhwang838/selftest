package crawler.naver.stock;

public interface IConstants {
	
	interface TYPE {
		String YEAR = "year";
		String QUARTER = "quarter";
	}
	interface ITEM {
		String CODE = "CODE";
		String NAME = "NAME";
		String SETTLEMENT_TYPE = "SETTLEMENT_TYPE";
		String SETTLEMENT_YYYYMM = "SETTLEMENT_YYYYMM";
		String SALES = "SALES";
		String BUSINESS_PROFITS = "BUSINESS_PROFITS";
		String NET_INCOME = "NET_INCOME";
		String BUSINESS_PROFITS_RATE = "BUSINESS_PROFITS_RATE";
		String NET_INCOME_RATE = "NET_INCOME_RATE";
		String ROE = "ROE";
		String DEBT_RATE = "DEBT_RATE";
		String QUICK_RATE = "QUICK_RATE";
		String RESERVE_RATE = "RESERVE_RATE";
		String EPS = "EPS";
		String BPS = "BPS";
		String DIVIDENDS_PER_SHARE = "DIVIDENDS_PER_SHARE";
		String MARKET_VALUE_DIVIDEND_RATE = "MARKET_VALUE_DIVIDEND_RATE";
		String PAYOUT_RATE = "PAYOUT_RATE";
	}
}
