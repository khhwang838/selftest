package problems.hackerrank;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Hackerrank.com
 * Strings: Making Anagrams
 * ----------------------------
 * Sample Input
 * 
 * cde
 * abc
 * 
 * Sample Output
 * 
 * 4
 * 
 * Explanation
 * 
 * We delete the following characters from our two strings to turn them into anagrams of each other:
 * 
 * Remove d and e from cde to get c.
 * Remove a and b from abc to get c.
 * We must delete  characters to make both strings anagrams, so we print  on a new line.
 * ----------------------------
 * 두 개의 스트링을 입력받아 anagram으로 만들려면 몇개의 문자를 지워야 하는지 출력
 * anagram이란 두 단어의 문자 순서를 바꾸면 정확히 동일한 단어로 매칭되는 단어를 의미
 * 
 * @author Kihyun
 * @created   2018-02-15
 */
public class MakingAnagrams {

	private static int check(String s, String tmp) {
		int cnt = 0;
		for ( char c : s.toCharArray() ) {
			if ( tmp.indexOf(c) < 0 ) {
				cnt++;
			}
			else {
				tmp = tmp.replaceFirst(Pattern.quote(String.valueOf(c)), "");
			}
		}
		return cnt;
	}
	public static int numberNeeded(String first, String second) {
		if (first.equals(second)) return 0;
		
		int total = 0;
		total += check(first, second);
		total += check(second, first);
		return total;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
    
}
