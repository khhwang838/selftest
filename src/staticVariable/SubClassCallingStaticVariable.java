/**
 * 작성된 날짜: 2014. 5. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package staticVariable;

/**
 * @file staticVariable.SubClassCallingStaticVariable.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 21. 	product 개발 	   신 규 작 성
 *
 */
public class SubClassCallingStaticVariable {
	public void changeStaticVariable(String staticNumber){
		staticNumber = "0";
	}
	public static void main(String[] args) {
		RootClassHasStaticVariable r2 = new RootClassHasStaticVariable();
		RootClassHasStaticVariable r3 = new RootClassHasStaticVariable();
		RootClassHasStaticVariable.staticNumber = 5;
		
		System.out.println(r2.getStaticNumber());
	}
}

