/**
 * 작성된 날짜: 2014. 3. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package exception;

/**
 * @file exception.KHException.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 3. 21. 		product 개발 	   신 규 작 성
 *
 */
public class KHException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7300202333146864949L;

	/**
	 * @param message
	 */
	public KHException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	public KHException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public KHException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public KHException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

	
}

