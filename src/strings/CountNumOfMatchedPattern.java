/**
 * 작성된 날짜: 2014. 7. 10.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package strings;

import java.util.regex.Pattern;

/**
 * @file strings.CountNumOfMatchedPattern.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 7. 10. 	product 개발 	   신 규 작 성
 *
 */
public class CountNumOfMatchedPattern {
	public static void main(String[] args) {
	
		String srcString = "java.lang.String[][]";
		String patternString = "[]";
		
		int count = 0;
		while(true){
			int idx = srcString.indexOf(patternString);
			if( idx < 0) break;
			count++;
			srcString = srcString.subSequence( idx + patternString.length(), srcString.length()).toString();
			idx = 0;
		}
	}
}

