/**
 * 작성된 날짜: 2014. 3. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package strings;

import exception.KHException;

/**
 * @file strings.generateID.java
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
public class generateID {
	final static int MIN_LENGTH = 5;
	public static String genRndId(int digitNum, int digitEng) throws KHException{
		if((digitEng + digitNum) > MIN_LENGTH && digitEng > 0 && digitNum > 0)
		{
			String id=null;
			
			
			return id;	
		}
		else
			throw new KHException("ID생성을 위한 자리수 제한에 위배됩니다.");
		
	}
}

