/**
 * 작성된 날짜: 2014. 3. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package numbers;

import exception.KHException;

/**
 * @file numbers.generateRandomNumber.java
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
public class GenerateNumber {
	
	public static int genRndNum(int min, int max) throws KHException{
		if(Integer.MIN_VALUE <= min && max < Integer.MAX_VALUE)
		return min + (int)(Math.random()*max);
		else
			throw new KHException("최소 또는 최대 값이 Integer형으로 표현할 수 있는 범위를 벗어났습니다.");
	}
	public static double genRndNumDouble(double min, double max) throws KHException{
		if(Double.MIN_VALUE <= min && max <= Double.MAX_VALUE)
			return min + Math.random()*max;
		else
			throw new KHException("최소 또는 최대 값이 Double형으로 표현할 수 있는 범위를 벗어났습니다."); 
	}
	public static long genRndNumLong(long min, long max) throws KHException{
		if(Long.MIN_VALUE <= min && max <= Long.MAX_VALUE)
			return (long) (min + Math.random()*max);
		else
			throw new KHException("최소 또는 최대 값이 Double형으로 표현할 수 있는 범위를 벗어났습니다."); 
	}
}

