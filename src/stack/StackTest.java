/**
 * 작성된 날짜: 2014. 10. 13.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package stack;

import java.util.Stack;

/**
 * @file stack.StackTets.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 10. 13. 	product 개발 	   신 규 작 성
 *
 */
public class StackTest {
	public static void main(String[] args) {
		Stack<Object> stack = new Stack<Object>();
		
		for ( int i = 0 ; i < 10 ; i++ ){
			String item = new String(String.valueOf(i));
			stack.push(item);
		}
		
		for ( int i = 0 ; i < 13 ; i ++ ){
			Object item = stack.pop();
			if ( item == null )
				System.out.println("null");
		}
		
	}
}

