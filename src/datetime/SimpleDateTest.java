/**
 * 작성된 날짜: 2014. 4. 2.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package datetime;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @file date.SimpleDateTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 4. 2. 		product 개발 	   신 규 작 성
 *
 */
public class SimpleDateTest {
	public static void main(String[] args) {
		
		String currentDate = new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new java.util.Date());
		System.out.println(currentDate);
		
		currentDate = new SimpleDateFormat("yyMMddhhmmssSSS").format(new java.sql.Date(System.currentTimeMillis()));
		System.out.println(currentDate);
		
		Date date = new java.util.Date();
		System.out.println(date);
		
		Date sqlDate = new java.sql.Date(System.currentTimeMillis());
		System.out.println(sqlDate);
	}
}

