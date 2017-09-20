/**
 * 작성된 날짜: 2014. 7. 16.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package uniqueValue;

import java.util.ArrayList;

/**
 * @file uniqueValue.HashCode.java
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
public class HashCode {
	public static void main(String[] args) throws Exception {

//		String s = "a ";
//		String b = "a ";
//		
//		System.out.println(s.hashCode());
//		System.out.println(b.hashCode());
		
		System.out.println("nanoTime() : " + System.nanoTime());
		ArrayList<Integer> valueList = new ArrayList<Integer>();
		
		for(int i = 0; i < 1000000 ; i++){
			int value = String.valueOf(System.nanoTime()).hashCode();
			
			if ( valueList.contains(value) )
				throw new Exception();
			valueList.add(value);
//			System.out.println(Math.abs(String.valueOf(System.nanoTime()).hashCode()));
		}
		
		for(int i = 0; i < 1000000 ; i++){
			int value = Math.abs(String.valueOf(System.nanoTime()).hashCode());
			if ( valueList.contains(value) )
				throw new Exception();
			valueList.add(value);
//			System.out.println(Math.abs(String.valueOf(System.nanoTime()).hashCode()));
		}
		System.out.println("done");
		
//		System.out.println("nanoTime() : " + System.nanoTime());
//		System.out.println(String.valueOf(System.nanoTime()).hashCode());
//		
//		System.out.println("nanoTime() : " + System.nanoTime());
//		System.out.println(String.valueOf(System.nanoTime()).hashCode());
	}
}

