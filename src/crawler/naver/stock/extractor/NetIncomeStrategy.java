package crawler.naver.stock.extractor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import crawler.naver.stock.IConstants;
import crawler.naver.stock.domain.RecentOutput;
import crawler.naver.stock.domain.Stock;

/**
 * 연도별 또는 분기별 순수익이 증가추세인 것 추출
 * @author Kihyun
 * @created   2017-12-19
 */
public class NetIncomeStrategy implements IExtractStrategy {

	private final static Logger logger = LoggerFactory.getLogger(NetIncomeStrategy.class);
	private final float MIN_INCREASE_RATIO = 0.1f;
	
	@Override
	public List<Stock> extract(Collection<Stock> stocks) {
		List<Stock> extracted = new ArrayList<>();
		for (Stock stock : stocks) {
			List<RecentOutput> roList = stock.getRecentOutputs();
			
			if ( isNetIncomeIncreasing(roList, IConstants.TYPE.YEAR, stock.getCode()) && isNetIncomeIncreasing(roList, IConstants.TYPE.QUARTER, stock.getCode()) ) {
				extracted.add(stock);
			}
		}
		return extracted;
	}

	private boolean isNetIncomeIncreasing(List<RecentOutput> roList, String type, String code) {
		
		int prevNetIncome = Integer.MAX_VALUE;
		List<Boolean> bool = new ArrayList<>();
		for ( RecentOutput ro : roList ) {
			if ( type.equals( ro.getSettlementType() ) && ro.getNetIncome() != 0 ) {
				if ( prevNetIncome == Integer.MAX_VALUE ) {
					prevNetIncome = ro.getNetIncome();
					continue;
				} else if ( prevNetIncome >= ro.getNetIncome() ) {
					return false;
				} else if ( prevNetIncome < ro.getNetIncome() ) {
					bool.add(true);
				}
				prevNetIncome = ro.getNetIncome();
			}
		}
		if ( bool.size() == 0 ) {
			return false;	// 연간/분기 실적 정보가 없거나 한 건만 있는 종목 제외
		}
		return true;
//		boolean result = true; 
//		for (Boolean b : bool ) { 
//			result = result && b; 
//		} 
//		return result;
	}

}
