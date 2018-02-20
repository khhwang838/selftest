package problems.hackerrank;

import java.util.Arrays;
import java.util.List;

public class Q1_VerifyItems {

    /*
     * Complete the function below.
     */
    static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
        int result = 0;
    	List<String> alex = Arrays.asList(items);
    	for ( int idx=0; idx < origItems.length ; idx++ ) {
    		if ( alex.contains(origItems[idx]) ) {
    			if ( origPrices[idx] != prices[alex.indexOf(origItems[idx])]) {
    				result++;
    			}
    		}
    	}
    	return result;
    }
}
