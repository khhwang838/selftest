package sorting;
/**
 * �ۼ��� ��¥: 2014. 2. 18.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .quicksort.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� �� �� �� �� �� �� �� �� �� �� ��
 * ------------ ------------- ------------ ------------ 
 * Ȳ �� �� 2014. 2. 18. product ���� �� �� �� ��
 *
 */

import java.util.Arrays;

public class quicksort {
	public static int partition(int list[], int left, int right) {
		int pivot, temp;
		int low, high;
		low = left;
		high = right;
		pivot = list[left]; // �Ǻ��� �������� �ϴ� �Ŀ� ��� ���� �ӵ��� �޶��� �� ���� ������?
		while (low < high) {
			// �տ������� �Ǻ����� ū �͵��� �ִ� �� �˻��Ѵ�.
			do {
				low++;
			} while (low <= right && list[low] < pivot);
			// �ڿ������� �Ǻ����� ���� �͵��� �ִ� �� �˻��Ѵ�.
			while (high >= left && list[high] > pivot) {
				high--;
			}

			// �տ��� �Ǻ����� ū �Ͱ� �ڿ��� �Ǻ����� ���� ���� ��ȯ�Ѵ�.
			if (low < high) {
				temp = list[low];
				list[low] = list[high];
				list[high] = temp;
			}
		}
		// �տ������� �˻��� �Ͱ� �ڿ������� �˻��ϴ� �ε����� �����ϴ� �κп� �־��ش�.
		temp = list[left];
		list[left] = list[high];
		list[high] = temp;
		return high;
	}

	public static void quickSort(int list[], int left, int right) {
		if (left < right) {
			int q = partition(list, left, right);
			quickSort(list, left, q - 1);
			quickSort(list, q + 1, right);
		}
	}

	public static void main(String[] args) {
		int[] list = { 10, 5, 3, 8, 4, 9, 1, 6, 2, 7 };
		
		System.out.println("before quick : " + Arrays.toString(list));
		quickSort(list, 0, list.length - 1);
		System.out.println("after quick : " + Arrays.toString(list));
	}
}
