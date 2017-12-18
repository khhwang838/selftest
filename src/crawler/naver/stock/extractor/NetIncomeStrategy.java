package crawler.naver.stock.extractor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import crawler.naver.stock.IConstants;
import crawler.naver.stock.domain.RecentOutput;
import crawler.naver.stock.domain.Stock;

/**
 * 연도별 또는 분기별 순수익이 증가추세인 것 추출
 * @author Kihyun
 * @created   2017-12-19
 */
public class NetIncomeStrategy implements IExtractStrategy {

	@Override
	public List<Stock> extract(Collection<Stock> stocks) {
		List<Stock> extracted = new ArrayList<>();
		for (Stock stock : stocks) {
			List<RecentOutput> roList = stock.getRo();
			
			if ( isNetIncomeIncreasing(roList, IConstants.TYPE.YEAR) || isNetIncomeIncreasing(roList, IConstants.TYPE.QUARTER) ) {
				extracted.add(stock);
			}
		}
		return extracted;
	}

	private boolean isNetIncomeIncreasing(List<RecentOutput> roList, String type) {
		
		boolean isIncreasing = true;
		int prevNetIncome = Integer.MIN_VALUE;
		for ( RecentOutput ro : roList ) {
			if ( type.equals( ro.getSettlementType() ) ) {
				if ( prevNetIncome == Integer.MIN_VALUE ) {
					prevNetIncome = ro.getNetIncome();
				} else {
					if ( prevNetIncome > ro.getNetIncome() ) {
						return false;
					}
				}
			}
		}
		return isIncreasing;
	}

}
