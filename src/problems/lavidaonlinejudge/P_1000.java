/**
 * 작성된 날짜: 2014. 9. 4.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package problems.lavidaonlinejudge;

import java.util.Scanner;

/**
 * @file problems.lavidaonlinejudge.P_1000.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 4. 	product 개발 	   신 규 작 성
 *
 */
public class P_1000 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = -1, b = -1;
        while(a > 10 || a < 0)
        	a = sc.nextInt();
        while(b > 10 || b < 0)
        	b = sc.nextInt();	
        System.out.println(a + b);
        sc.close();
	}
}

