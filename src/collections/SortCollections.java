/**
 * 작성된 날짜: 2014. 6. 3.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @file collections.SortCollections.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 6. 3. 	product 개발 	   신 규 작 성
 *
 */
public class SortCollections {
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "value A");
		map.put("B", "value B");
		map.put("C", "value C");
		map.put("D", "value D");
		map.put("E", "value E");
		map.put("F", "value F");
		
		// map.values() 로 출력하면 put한 순서대로 나온다는 보장이 없다.
		System.out.println(map.values().toString());
		
		System.out.println("  [  ]  ");
		
		// map.values()를  List에 넣고 그 리스트를 역순으로 sorting한다.
		List<String> keyInfoList = new ArrayList<String>(map.values());
		Collections.sort(keyInfoList, new Comparator<String>(){
			@Override
			public int compare(String pk1 , String pk2){
				return pk2.compareTo(pk1);
			}
		});
		for(String s : keyInfoList){
			System.out.println(s);
		}
		
		System.out.println("  [  ]  ");
		
		// map.values()를  List에 넣고 그 리스트를 sorting한다.
		keyInfoList = new ArrayList<String>(map.values());
		Collections.sort(keyInfoList, new Comparator<String>(){
			@Override
			public int compare(String pk1 , String pk2){
				return pk1.compareTo(pk2);
			}
		});
		for(String s : keyInfoList){
			System.out.println(s);
		}
				
		
		
	}
}


