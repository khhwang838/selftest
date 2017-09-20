/**
 * 작성된 날짜: 2014. 4. 30.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package inputsFromUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @file inputsFromUser.BufferedReaderTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 4. 30. 	product 개발 	   신 규 작 성
 *
 */
public class BufferedReaderTest {
	public static void main(String[] args) throws IOException {
		InputStreamReader sr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(sr);
		System.out.println("문장을 입력해주세요.");
		String input = br.readLine();
		System.out.println("당신이 입력한 문장은 \"" + input + "\"입니다.");
	}
}

