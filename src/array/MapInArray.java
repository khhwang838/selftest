/**
 * 작성된 날짜: 2014. 7. 16.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @file array.MapInArray.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 7. 16. 	product 개발 	   신 규 작 성
 *
 */
public class MapInArray {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		Map[] mapArr = new Map[3];
		
		
		String value = "[[1,2,3],[2,4,6],[3,6,9]]";
		int out = 0;
		Stack<Character> st = new Stack<Character>();
		for(int i = 0 ; i < value.length() ; i++){
			if(value.charAt(i) == '[')
				st.push(value.charAt(i));
			else if(value.charAt(i) == ']'){
				st.pop();
				if(st.size() == 0) out++;
			}
		}
		
		System.out.println(out);
	}
}

