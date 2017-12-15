package crawler.naver.stock.domain;

import java.util.ArrayList;
import java.util.List;

public class Stock {

	private String code;
	private String name;
	private final List<RecentOutput> ro = new ArrayList<RecentOutput>();

	public Stock(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RecentOutput> getRo() {
		return ro;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Stock [code=");
		builder.append(code);
		builder.append(", name=");
		builder.append(name);
		builder.append(", ro=");
		builder.append(ro);
		builder.append("]");
		return builder.toString();
	}

}
