/**
 * 작성된 날짜: 2014. 10. 10.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package encoding;

import java.io.UnsupportedEncodingException;

/**
 * @file encoding.encodingTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 10. 10. 	product 개발 	   신 규 작 성
 *
 */
public class EncodingTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String msg = "old 메시지 Data";
		byte[] msgByte = msg.getBytes("euc-kr");
		
		String unmarshal = new String(msgByte, "utf-8");
		System.out.println(unmarshal);
		
		unmarshal = new String(msgByte, "euc-kr");
		System.out.println(unmarshal);
		
	}
}

