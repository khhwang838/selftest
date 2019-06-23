package problems.hackerrank;

public class UtopianTree {

	public static void main(String[] args) {
		System.out.println(utopianTree(0));// 1
		System.out.println(utopianTree(1));// 2
		System.out.println(utopianTree(4));// 7
	}

	static int utopianTree(int n) {

		if (n == 0)
			return 1;
		if (n == 1)
			return 2;

		int height = 1;
		int quotient = n / 2;

		while (quotient-- > 0) {
			height = (height * 2 + 1);
		}
		if (n % 2 == 1) {
			height *= 2;
		}
		return height;
	}

}
