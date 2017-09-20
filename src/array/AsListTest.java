package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsListTest {
	
	static Logger logger = LoggerFactory.getLogger(AsListTest.class);
	
	public static void main(String[] args) {
		List<String> arr = new ArrayList<String>();
		
		arr.add("a");
		arr.add("b");
		arr.add("c");
	
		logger.info("arr : {}", arr);
		
		String[] list = new String[arr.size()];
		
		List<String> arr2 = Arrays.asList(arr.toArray(list));
		
		logger.info("arr2 : {}", arr2);
		
				
	}
}
