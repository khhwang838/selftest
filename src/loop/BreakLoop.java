/**
 * 작성된 날짜: 2014. 5. 22.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package loop;

/**
 * @file loop.BreakLoop.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 22. 	product 개발 	   신 규 작 성
 *
 */
public class BreakLoop {
	public static void main(String[] args) {
		int i = 2;
		while(true){
//			return false;
			if(i > 1){
				while(true){
					
					
					break;
				}
			}
			System.out.println(i++);
		}
	}
}

