/**
 * 작성된 날짜: 2014. 7. 1.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package handlingObject.objectValue;

import java.util.ArrayList;
import java.util.List;

/**
 * @file objectValue.objectValue.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 7. 1. 	product 개발 	   신 규 작 성
 *
 */
public class objectValueTest {
	public static void main(String[] args) {
		TestObject to;
		List<TestObject> toList = new ArrayList<TestObject>();
		
		for(int i = 0; i < 10 ; i++){
			to = new TestObject();
			to.setS(String.format("%d", i));
			toList.add(to);
		}
		
		for(TestObject o : toList){
			System.out.println(o.getS());
		}
		
		
		
		// String[] 타입의 변수를 파라미터로 받은 뒤 값을 변경하면 원본 값이 바뀐다.
		String[] str = {"1", "2", "3"};
		testValue1(str);
		System.out.println(str[0]);
		
		testValue2(str);
		System.out.println(str[0]);
		
		testValue3(str);
		System.out.println(str[0]);
		
		// Integer 타입의 변수
		Integer i = 5;
		integerTest(i);
		System.out.println("Integer i = " + i);
		
	}
	
	public static void testValue1(String[] str){
		str[0] = "test1";
	}
	public static void testValue2(String[] str){
		String[] temp = str;
		temp[0] = "test2";
	}
	public static void testValue3(String[] str){
		String[] temp = str.clone();
		temp[0] = "test3";
	}
	public static void integerTest(Integer i) {
		i = 10;
	}
	
}

