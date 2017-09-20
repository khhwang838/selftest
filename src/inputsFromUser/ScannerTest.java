/**
 * 작성된 날짜: 2014. 4. 30.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package inputsFromUser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @file inputsFromUser.ScannerTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 4. 30. 	product 개발 	   신 규 작 성
 *
 */
public class ScannerTest {
	public static void main(String[] args) {
		Scanner sc;
		
		sc = new Scanner(System.in);
		Integer n = sc.nextInt();
//		sc.close();
//		
//		sc = new Scanner(System.in);
		List<Integer> N = new ArrayList<Integer>();
		for(int i = 0 ; i < n ; i++){
			N.add(sc.nextInt());
		}
//		sc.close();
//		
//		sc = new Scanner(System.in);
		Integer m = sc.nextInt();
//		sc.close();
//		
//		sc = new Scanner(System.in);
		List<Integer> M = new ArrayList<Integer>();
		for(int i = 0 ; i < m ; i++){
			M.add(sc.nextInt());
		}
		sc.close();
		
		for(int index = 0; index < N.size(); index++){
			for(int idx = 0; idx < M.size(); idx++){
				if(N.get(index) == M.get(idx)) {
					N.get(index).valueOf(1);
				}
				else{
					N.get(index).valueOf(0);
				}
			}
		}
		for(Integer i : N){
			System.out.println(i);
		}
	}
}

