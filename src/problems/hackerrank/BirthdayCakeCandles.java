/**
 * Created on Apr 12, 2019 by Keichee
 */
package problems.hackerrank;

import org.junit.*;

public class BirthdayCakeCandles {

	public static void main(String[] args) {
		int[] candles = { 1, 4, 3, 2 };
		Assert.assertEquals(1, birthdayCakeCandles(candles));
		candles = new int[]{4,3,1,1};
		Assert.assertEquals(1, birthdayCakeCandles(candles));
		candles = new int[]{4,3,4,1,1};
		Assert.assertEquals(2, birthdayCakeCandles(candles));
	}

	static int birthdayCakeCandles(int[] candles) {
		int answer = 0;
		int max = Integer.MIN_VALUE;
		for(int candle : candles) {
			if(candle > max) {
				answer = 1;
				max = candle;
			} else if (candle == max) {
				answer += 1;
			} else {
				// do nothing
			}
		}
		return answer;
	}
}
