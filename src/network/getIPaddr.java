/**
 * 작성된 날짜: 2014. 9. 22.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package network;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @file network.getIPaddr.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 22. 	product 개발 	   신 규 작 성
 *
 */
public class getIPaddr {
	public static void main(String[] args) throws UnknownHostException {
		System.out.println(Inet4Address.getLocalHost().getHostAddress());
	}
}

