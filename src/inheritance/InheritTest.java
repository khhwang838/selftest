/**
 * 작성된 날짜: 2014. 4. 10.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package inheritance;

/**
 * @file inheritance.InheritTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 4. 10. 		product 개발 	   신 규 작 성
 *
 */
public class InheritTest {

	public static void main(String[] args) {
		Dog d = new Dog();
		d.setBark("bark");
		Animal a = d;
		System.out.println(((Dog)a).getBark());
	}
}

