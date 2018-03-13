/**
 * 작성된 날짜: 2014. 8. 6.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package nullTest;

/**
 * @file nullTest.NullStringArray.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 8. 6. 	product 개발 	   신 규 작 성
 *
 */
public class NullStringArray {
	public static void main(String[] args) {

		String[] str = new String[3];

		if (str.equals(null))
			System.out.println("str is null");
		else
			System.out.println("str is not null");
	}
	
	
}

