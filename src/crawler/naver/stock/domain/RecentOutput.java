package crawler.naver.stock.domain;

public class RecentOutput {
	
	private String settlementType;	// 연간 or 분기
	private String settlementYyyyMm;
	protected int sales;	// 매출액(억원)
	protected int businessProfits;	// 영업이익(억원)
	protected int netIncome;	// 당기순이익(억원)
	protected float businessProfitsRate;	// 영업이익률(%)
	protected float netIncomeRate;	// 순이익률(%)
	protected float roe;	// ROE(%)
	protected float debtRate;	// 부채비율(%)
	protected float quickRate;	// 당좌비율(%)
	protected float reserveRate;	// 유보율(%)
	protected int eps;	// EPS(원)
	protected int bps;	// BPS(원)
	protected int dividendsPerShare;	// 주당배당금(원)
	protected float marketValueDividendRate;	// 시가배당률(%)
	protected float payoutRatio;	// 배당성향(%)
	
	public String getSettlementType() {
		return settlementType;
	}
	public void setSettlementType(String settlementType) {
		this.settlementType = settlementType;
	}
	public String getSettlementYyyyMm() {
		return settlementYyyyMm;
	}
	public void setSettlementYyyyMm(String settlementYyyyMm) {
		this.settlementYyyyMm = settlementYyyyMm;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getBusinessProfits() {
		return businessProfits;
	}
	public void setBusinessProfits(int businessProfits) {
		this.businessProfits = businessProfits;
	}
	public int getNetIncome() {
		return netIncome;
	}
	public void setNetIncome(int netIncome) {
		this.netIncome = netIncome;
	}
	public float getBusinessProfitsRate() {
		return businessProfitsRate;
	}
	public void setBusinessProfitsRate(float businessProfitsRate) {
		this.businessProfitsRate = businessProfitsRate;
	}
	public float getNetIncomeRate() {
		return netIncomeRate;
	}
	public void setNetIncomeRate(float netIncomeRate) {
		this.netIncomeRate = netIncomeRate;
	}
	public float getDebtRate() {
		return debtRate;
	}
	public void setDebtRate(float debtRate) {
		this.debtRate = debtRate;
	}
	public float getQuickRate() {
		return quickRate;
	}
	public void setQuickRate(float quickRate) {
		this.quickRate = quickRate;
	}
	public float getReserveRate() {
		return reserveRate;
	}
	public void setReserveRate(float reserveRate) {
		this.reserveRate = reserveRate;
	}
	public int getEps() {
		return eps;
	}
	public void setEps(int eps) {
		this.eps = eps;
	}
	public int getBps() {
		return bps;
	}
	public void setBps(int bps) {
		this.bps = bps;
	}
	public int getDividendsPerShare() {
		return dividendsPerShare;
	}
	public void setDividendsPerShare(int dividendsPerShare) {
		this.dividendsPerShare = dividendsPerShare;
	}
	public float getMarketValueDividendRate() {
		return marketValueDividendRate;
	}
	public void setMarketValueDividendRate(float marketValueDividendRate) {
		this.marketValueDividendRate = marketValueDividendRate;
	}
	public float getPayoutRatio() {
		return payoutRatio;
	}
	public void setPayoutRatio(float payoutRatio) {
		this.payoutRatio = payoutRatio;
	}
	public float getRoe() {
		return roe;
	}
	public void setRoe(float roe) {
		this.roe = roe;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nRecentOutput [settlementType=");
		builder.append(settlementType);
		builder.append(", settlementYyyyMm=");
		builder.append(settlementYyyyMm);
		builder.append(", sales=");
		builder.append(sales);
		builder.append(", businessProfits=");
		builder.append(businessProfits);
		builder.append(", netIncome=");
		builder.append(netIncome);
		builder.append(", businessProfitsRate=");
		builder.append(businessProfitsRate);
		builder.append(", netIncomeRate=");
		builder.append(netIncomeRate);
		builder.append(", roe=");
		builder.append(roe);
		builder.append(", debtRate=");
		builder.append(debtRate);
		builder.append(", quickRate=");
		builder.append(quickRate);
		builder.append(", reserveRate=");
		builder.append(reserveRate);
		builder.append(", eps=");
		builder.append(eps);
		builder.append(", bps=");
		builder.append(bps);
		builder.append(", dividendsPerShare=");
		builder.append(dividendsPerShare);
		builder.append(", marketValueDividendRate=");
		builder.append(marketValueDividendRate);
		builder.append(", payoutRatio=");
		builder.append(payoutRatio);
		builder.append("]");
		return builder.toString();
	}
	
}
