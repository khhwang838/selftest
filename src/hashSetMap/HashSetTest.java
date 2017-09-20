/**
 * 작성된 날짜: 2014. 9. 22.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package hashSetMap;

import java.util.HashSet;

/**
 * @file hashSetMap.HashSetTest.java
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
public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("a");

		System.out.println(set.size());
		
		set.clear();
		
		System.out.println(set.size());

	}
}

