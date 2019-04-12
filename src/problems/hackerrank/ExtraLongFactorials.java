/**
 * Created on Apr 11, 2019 by Keichee
 */
package problems.hackerrank;

import java.math.BigInteger;

public class ExtraLongFactorials {

	public static void main(String[] args) {
		extraLongFactorials(25);	
	}
	static void extraLongFactorials(int n) {
		System.out.println(factorial(n));
    }
	static BigInteger factorial(int n) {
		if(n == 0) return BigInteger.ONE;
		return BigInteger.valueOf(n).multiply(factorial(n-1));
	}
}
