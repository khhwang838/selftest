package crawler.naver.stock.extractor;

import java.util.Collection;
import java.util.List;

import crawler.naver.stock.domain.Stock;

public interface IExtractStrategy {
	
	public List<Stock> extract(Collection<Stock> stocks);
}
