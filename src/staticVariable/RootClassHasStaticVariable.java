/**
 * 작성된 날짜: 2014. 5. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package staticVariable;

/**
 * @file staticVariable.RootClassHasStaticVariable.java
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
public class RootClassHasStaticVariable {
	public static int staticNumber = 0;
	
	/**
	 * 
	 */
	public RootClassHasStaticVariable() {
		staticNumber = 10;
	}

	public static int getStaticNumber() {
		return staticNumber;
	}

	public static void setStaticNumber(int staticNumber) {
		RootClassHasStaticVariable.staticNumber = staticNumber;
	}
	
}

