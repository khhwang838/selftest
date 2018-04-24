package array;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray {

	/*
	 * 2 차원 배열 정렬
	 */
	public static void sortArray(Object[][] arr) {
		Arrays.sort(arr, new Comparator<Object[]>() {
			public int compare(Object[] arr1, Object[] arr2) {
				if (((Comparable) arr1[0]).compareTo(arr2[0]) < 0)
					return 1;
				else
					return -1;
			}
		});
	}

}
