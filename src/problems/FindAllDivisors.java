/**
 * Created on 2018. 5. 16. by Kihyun Hwang
 */
package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * (주)푸른밤 코딩 테스트 문제 1
 */
public class FindAllDivisors {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();

		List<Integer> bigDivisors = new ArrayList<>();
		for (int divisor = 1; divisor <= Math.sqrt(num); divisor++) {
			if (num % divisor == 0) {
				System.out.print(divisor + " ");
				if (divisor != num / divisor) {
					bigDivisors.add(num / divisor);
				}
			}
		}

		for (int index = bigDivisors.size() - 1; index >= 0; index--) {
			System.out.print(bigDivisors.get(index) + " ");
		}
		System.out.println();
	}

}
