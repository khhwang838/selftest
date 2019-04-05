/**
 * Created on Mar 23, 2019 by Keichee
 */
package problems.programmers.level2;

public class StockPrice {

	public static void main(String[] args) {
		
	}
	public int[] solution(int[] prices) {
		
		int[] answer = new int[prices.length];
		for(int i = 0; i < prices.length; i++) {
			if(i == prices.length - 1) {
				answer[i] = 0;
			} else {
				int seconds = 0;
				for(int j = i+1; j <  prices.length; j++) {
					seconds++;
					if(prices[i] > prices[j]) {
						break;
					}
				}
				answer[i] = seconds;
			}
		}
        return answer;
    }
}
