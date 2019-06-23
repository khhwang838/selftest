package problems.hackerrank;

import junit.framework.Assert;

public class DrawingBook {

	public static void main(String[] args) {

		Assert.assertEquals(0, pageCount(5, 4)); // 뒤에서 찾는 케이스
		Assert.assertEquals(2, pageCount(15, 4)); // 앞에서 찾는 케이스

		Assert.assertEquals(1, pageCount(7, 4)); // 뒤에서 찾는 케이스
		Assert.assertEquals(1, pageCount(7, 5)); // 뒤에서 찾는 케이스
		Assert.assertEquals(1, pageCount(6, 4)); // 뒤에서 찾는 케이스
		Assert.assertEquals(1, pageCount(6, 5)); // 뒤에서 찾는 케이스

	}

	static int pageCount(int n, int p) {

		// 앞에서 부터 페이지를 넘길 때 (always start from 1, right page)
		int fromFront = p / 2;

		// 뒤에서 부터 페이지를 넘길 때 (odd right/ even left)
		int fromBack;
		if (n % 2 > 0) {
			// total page odd case
			if (n - p < 2) {
				fromBack = 0;
			} else {
				fromBack = (n - p) / 2;
			}
		} else {
			// total page even case
			fromBack = (n - p) / 2;
			if (n - p == 1) {
				fromBack += 1;
			}
		}
		return Math.min(fromFront, fromBack);
	}
}
