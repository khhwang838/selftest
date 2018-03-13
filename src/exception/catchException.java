/**
 * 작성된 날짜: 2014. 6. 10.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package exception;

/**
 * @file exception.catchException.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 6. 10. 	product 개발 	   신 규 작 성
 *
 */
public class catchException {
	public static void main(String[] args) throws Exception {
		
		
		try{
			int i = 0;
			System.out.println("예외 발생 전");
			if(i == 0 )
				throw new Exception();
			System.out.println("예외 발생 직후");
			
			System.out.println("예외 발생 이후");
		}catch(Exception e){
			System.out.println("예외 처리");
		}
	}
}

