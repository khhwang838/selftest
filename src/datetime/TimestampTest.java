/**
 * 작성된 날짜: 2014. 5. 15.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package datetime;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

/**
 * @file datetime.TimestampTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 15. 	product 개발 	   신 규 작 성
 *
 */
public class TimestampTest {
	public static void main(String[] args) {
		
		System.out.println(System.currentTimeMillis());
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		System.out.println(ts);
		System.out.println(ts.toString().substring(0, 19));
		System.out.println("===============");
		System.out.println(new Timestamp(Long.parseLong("1401171143242")));
		
		Date d = Date.valueOf("2014-08-26");
		Time t = Time.valueOf("10:59:45");
		System.out.println(d.getTime());
		System.out.println(t.getTime());
		
		System.out.println(new Timestamp(5555550l));
		
	}
}

