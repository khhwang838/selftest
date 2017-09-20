/**
 * 작성된 날짜: 2014. 5. 8.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package numbers;

/**
 * @file numbers.QuickSort.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 8. 	product 개발 	   신 규 작 성
 *
 */
public class QuickSort {
	public static void main(String[] args) {
		Integer[] unsortedIntegers = new Integer[]{ 7, 5, 4, 2, 1, 10, 9, 6, 8};
		unsortedIntegers = quickSort(unsortedIntegers);
		for(Integer i : unsortedIntegers){
			System.out.println(i);
		}
	}
	
	
	public static Integer[] quickSort(Integer[] key) {
		Integer lenD = key.length;
		Integer pivot = 0;
		Integer ind = lenD / 2;
		Integer i, j = 0, k = 0;
		if (lenD < 2) {
			return key;
		} else {
			Integer[] L = new Integer[lenD];
			Integer[] R = new Integer[lenD];
			Integer[] sorted = new Integer[lenD];
			pivot = key[ind];
			for (i = 0; i < lenD; i++) {
				if (i != ind) {
					if (key[i] < pivot) {
						L[j] = key[i];
						j++;
					} else {
						R[k] = key[i];
						k++;
					}
				}
			}
			Integer[] sortedL = new Integer[j];
			Integer[] sortedR = new Integer[k];
			System.arraycopy(L, 0, sortedL, 0, j);
			System.arraycopy(R, 0, sortedR, 0, k);
			sortedL = quickSort(sortedL);
			sortedR = quickSort(sortedR);
			System.arraycopy(sortedL, 0, sorted, 0, j);
			sorted[j] = pivot;
			System.arraycopy(sortedR, 0, sorted, j + 1, k);
			return sorted;
		}
	}
}

