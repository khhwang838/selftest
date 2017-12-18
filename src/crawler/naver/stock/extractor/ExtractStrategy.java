package crawler.naver.stock.extractor;

import java.util.List;
import crawler.naver.stock.domain.Stock;

public interface ExtractStrategy {
	
	public List<Stock> extract(List<Stock> stocks);
}
