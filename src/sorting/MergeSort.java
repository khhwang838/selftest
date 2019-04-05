/**
 * Created on 2018. 5. 16. by Kihyun Hwang
 */
package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * (주)푸른밤 코딩테스트 문제 2
 */
public class MergeSort {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int numOfIntegers = scan.nextInt();
		if (numOfIntegers <= 0)
			return;

		int[] integers = new int[numOfIntegers];
		for (int index = 0; index < numOfIntegers; index++) {
			integers[index] = scan.nextInt();
		}
		// System.out.println(Arrays.toString(integers));
		sort(integers);

		for (int index = 0; index < integers.length; index++) {
			System.out.print(integers[index] + " ");
		}

	}

	public static void sort(int[] needSort) {
		if (needSort.length == 1)
			return;

		
		
	}

}
