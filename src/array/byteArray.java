/**
 * 작성된 날짜: 2014. 9. 22.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package array;

import java.lang.reflect.Array;

/**
 * @file array.byteArray.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 22. 	product 개발 	   신 규 작 성
 *
 */
public class byteArray {
	public static void main(String[] args) {
		byte[] data1 = "00000015".getBytes();
		byte[] data2 = "00000000By KH".getBytes();
		
		System.out.println(new String(data2));
		for(int i = 0 ; i < 8 ; i++)
			Array.setByte((Object)data2, i, data1[i]);
		
		System.out.println(new String(data2));
		System.out.println(String.valueOf(data2));
		
		System.out.println("0".getBytes().length);
		
		data1 = new String("1234567890").getBytes();
		System.out.println(new String(data1));
		
	}
}

