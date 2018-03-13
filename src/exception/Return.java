/**
 * 작성된 날짜: 2014. 4. 16.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package exception;

import java.sql.SQLException;

/**
 * @file exception.Return.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 4. 16. 		product 개발 	   신 규 작 성
 *
 */
public class Return {
	public static void main(String[] args) {
		testMethod();
	}
	public static int testMethod(){
		try{
			throw new SQLException();
			
		}
		catch(Exception e){
			throw new RuntimeException("SQLException has been caught.", e);
		}
//		return 0;
	}
}

