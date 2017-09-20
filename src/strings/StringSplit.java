package strings;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * �ۼ��� ��¥: 2014. 2. 27.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .StringSplit.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� ��			�� ��				�� �� �� �� 	  �� �� �� ��
 * ------------ ------------- 	------------ ------------ 
 * Ȳ �� �� 		2014. 2. 27. 		product ���� 	   �� �� �� ��
 *
 */
public class StringSplit {
	public static void main(String[] args) {
//		String methodSg1 = "setAccoNo(java.lang.String;)";
//		String methodSg2 = "setAccoNo()";
//		System.out.println(methodSg1.split(Pattern.quote("("))[1]);
//		System.out.println(methodSg2.split("(")[1]);
		
		
		for( String s : splitArrayValues("[1,2,3],[2,4,6],[3,6,9]")){
			System.out.println(s);
		}
		
		
		
		
//		Character[] ch = new Character[]{'a','a','b','c','c'};
//		List<Character> st = new ArrayList<Character>();
//		st.add('a');
//		st.add('b');
//		st.add('c');
//		
//		System.out.println(ch.toString());
//		System.out.println(st.toString());
		
		// 3. delimeter : ^^ 
		String data = "^^^^a^^^^";
		String[] splittedData = data.split(Pattern.quote("^^"));
		System.out.println(splittedData.length);
		
		
		// 4. split
		test4();
	}
	
	
	private static void test4(){
		String str = "menu1";
		System.out.println(" [ test4 0 ] " + str.split(Pattern.quote("menu"))[0]);
		System.out.println(" [ test4 1 ] " + str.split(Pattern.quote("menu"))[1]);
	}
	private static String[] splitArrayValues(String value) {
		// [ , ],[ , ]	:	[[ , ],[ , ]],[[ , ]]

		String[] out;
		List<String> valueList = new ArrayList<String>();
		
		int count = 0;
		Stack<Character> st = new Stack<Character>();
		for(int i = 0; i < value.length(); i++){
			if(value.charAt(i) == '['){
				++count;
			}
			else if(value.charAt(i) == ']'){
				if(--count == 0){
					// 스택에 쌓인 데이타가 하나의 값이므로 리스트에 추가
					valueList.add(st.toString().replace(" ", ""));
					st.clear();
				}
			}
			else if(value.charAt(i) != ','){
				st.push(value.charAt(i));
			}
		}
		out = new String[valueList.size()];
		valueList.toArray(out);
		return out;
	}
}

