/**
 * Created on Feb 16, 2019 by Keichee
 */
package problems.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStrings {

	public static void main(String[] args) {
		String[] words = {"abc", "bcd", "aaa", "bge", "zia"};
		solution(words, 2);
	}
	public static String[] solution(String[] allWords, int n) {
		
		Map<String, List<String>> map = new HashMap<>();
										
		List<String> sublist;

		for (String word : allWords) {
			String charAtIndexN = String.valueOf(word.charAt(n));
			
			if(!map.containsKey(charAtIndexN)) {
				// 신규 list 등록 (신규 key 등록)
				sublist = new ArrayList<>();
				map.put(charAtIndexN, sublist);
			} else {
				// 기존 list 조회
				sublist = map.get(charAtIndexN);
			}
			// 이 시점부터는 sublist가 항상 존재
			sublist.add(word);
		}

		List<String> answer = new ArrayList<>();
		
		for(char c = 'a'; c <= 'z'; c++) {
			sublist = map.get(String.valueOf(c));
			if(sublist != null) { 
				if (sublist.size() > 1) {
					Collections.sort(sublist);
				}
				answer.addAll(sublist);
			}
		}
		String[] result = new String[answer.size()];
		return answer.toArray(result);
	}

}
