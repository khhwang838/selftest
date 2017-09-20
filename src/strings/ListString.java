/**
 * 작성된 날짜: 2014. 5. 26.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * @file strings.ListString.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 26. 	product 개발 	   신 규 작 성
 *
 */
public class ListString {
	public static void main(String[] args) {
		List<String> sList = new ArrayList<String>();
		
		sList.add("a");
		sList.add("b");
		sList.add("c");
		
		for(String s : sList){
			if(s.equals("b"))
				sList.remove("b");
		}
//		for(String s : sList){
//			System.out.println(s);
//		}
		
		String[] aList = new String[sList.size()];
		
		sList.toArray(aList);
		System.out.println("  [  ]  ");
		for(String s : aList){
			System.out.println(s);
		}
	}
}

