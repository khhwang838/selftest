/**
 * 작성된 날짜: 2014. 7. 1.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package handlingObject.objectValue;

/**
 * @file objectValue.TestObject.java
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
public class TestObject {
	
	private String s;
	private int i;
	
	public TestObject(String string, int j) {
		this.s = string;
		this.i = j;
	}
	public TestObject() {
	}
	public String getS() {
		return s;
	}
	public void setS(String s) {
		this.s = s;
	}
	public int getI() {
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}
	
	
}

