/**
 * 작성된 날짜: 2014. 9. 23.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package problems.judgeon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @file problems.judgeon.P_1502.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 23. 	product 개발 	   신 규 작 성
 *
 */
public class P_1502 {
	
	final static List<Long> primeList = new ArrayList<Long>();
	
	/**
	 * 1초 내에 소수의 개수 계산하기
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		while(n < 2 || n > Math.pow(2, 24)){
			n = sc.nextLong();
		}
		printNumOfPrimes(n);
		
		for(long l : primeList)
			System.out.print(l + " ");
	}
	
	private static void printNumOfPrimes(long n){
		
		int out = 1;
		for(int i = 1 ; i <= n / 4 ; i++){
			// 홀수만 검사
			out += checkPrimeNum(4*i - 1);
			out += checkPrimeNum(4*i + 1);
		}
		System.out.println(out);
	}

	private static int checkPrimeNum(long n) {
		
		for(long prime : primeList){
			if(n % prime == 0) return 0;
		}
		primeList.add(n);
		return 1;
	}
}

