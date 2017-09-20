/**
 * 작성된 날짜: 2014. 7. 16.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package array;

import java.util.regex.Pattern;

/**
 * @file array.NullinArray.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 7. 16. 	product 개발 	   신 규 작 성
 *
 */
public class NullinArray {
	public static void main(String[] args) {
		String s = "[,,a]";
		
		s = s.replace("[", "");
		s = s.replace("]", "");
		
		System.out.println(s);
		System.out.println(s.split(Pattern.quote(",")).length);
		
		String[] values = s.split(Pattern.quote(","));
		System.out.println(values.length);
		for(String value : values){
			System.out.println(value);
		}
		
	}
}

