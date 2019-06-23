package problems.hackerrank;

import java.util.Arrays;

public class SockMerchant {

	public static void main(String[] args) {
		int[] socks = { 10, 20, 20, 10, 10, 30, 50, 10, 20 };
		sockMerchant(socks.length, socks);
	}

	// Complete the sockMerchant function below.
	static int sockMerchant(int numOfSocks, int[] socks) {

		Arrays.sort(socks);

		int currentSockColor = 0;
		int count = 0;
		
		for (int sockColor : socks) {
			if(currentSockColor == sockColor) {
				count++;
				currentSockColor = 0;
			} else {
				currentSockColor = sockColor;
			}
		}
		return count;
	}

}
