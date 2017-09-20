/**
 * 작성된 날짜: 2014. 9. 3.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package problems.lavidaonlinejudge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @file problems.lavidaonlinejudge.P_1001.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 3. 	product 개발 	   신 규 작 성
 *
 */
public class P_1001 {
	
	private static int testCase = 0;
	private static int dots = 0;
	private static int min = Integer.MAX_VALUE;
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ArrayList<int[]>> allDotList = new ArrayList<ArrayList<int[]>>();
		ArrayList<int[]> dotListPerCase = null;
		
		while(testCase < 1 || testCase > 20){
			testCase = sc.nextInt();
		}
		for(int i = 0; i < testCase ; i++){
			dotListPerCase = new ArrayList<int[]>();
			while(dots < 4 || dots > 50){
				dots = sc.nextInt();
			}
			for(int j = 0; j < dots ; j++){
				int[] dot = new int[2];
				dot[0] = sc.nextInt();
				dot[1] = sc.nextInt();
				dotListPerCase.add(dot);
			}
			dots = 0;
			allDotList.add(dotListPerCase);
		}
		
		for(ArrayList<int[]> dotList : allDotList){
			findSquare(dotList);
			System.out.println(min + " " + max);
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
		}
		
	}

	private static void findSquare(ArrayList<int[]> dotList) {
		int[] dot1;
		int[] dot2;
		int[] dot3;
		int[] dot4;
		for(int i = 0; i < dotList.size() - 3 ; i++){
			dot1 = dotList.get(i);
			for (int j = 1; j < dotList.size() - 2; j++) {
				dot2 = dotList.get(j);
				for (int k = 2; k < dotList.size() - 1; k++) {
					dot3 = dotList.get(k);
					for (int h = 3; h < dotList.size(); h++) {
						dot4 = dotList.get(h);

						int length = checkSquare(dot1, dot2, dot3, dot4);
						if (length > 0) {
							if (length > max)
								max = length;
							if (length < min)
								min = length;
						}
					}
				}
			}
		}
	}
	
	private static int checkSquare(int[] dot1, int[] dot2, int[] dot3, int[] dot4) {

		if(dot1[0] == dot2[0]){
			if(dot3[0] == dot4[0]){
				if(dot1[1] == dot3[1] && dot2[1] == dot4[1])
					return Math.abs(dot1[0] - dot3[0]);
			}
		}
		if(dot1[0] == dot3[0]){
			if(dot2[0] == dot4[0]){
				if(dot1[1] == dot2[1] && dot3[1] == dot4[1]){
					return Math.abs(dot1[0] - dot2[0]);
				}
			}
		}
		if(dot1[0] == dot4[0]){
			if(dot3[0] == dot2[0]){
				if(dot1[1] == dot3[1] && dot2[1] == dot4[1]){
					return Math.abs(dot1[0] - dot3[0]);
				}
			}
		}
		return 0;
	}

}

