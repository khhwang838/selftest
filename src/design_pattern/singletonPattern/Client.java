/**
 * 작성된 날짜: 2014. 7. 30.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package design_pattern.singletonPattern;

/**
 * @file design_pattern.singletonPattern.Client.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 7. 30. 	product 개발 	   신 규 작 성
 *
 */
public class Client {
	public static void main(String[] args) {
		
//		Memory memory1  = new Memory();
		Memory memory2  = Memory.getInstance();
		
		
	}
}

