package strings;

import java.util.regex.Pattern;
/**
 * 작성된 날짜: 2014. 3. 18.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .SubString.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 3. 18. 		product 개발 	   신 규 작 성
 *
 */
public class SubString {
	
	public static void main(String[] args) {
		
		String s = "java.lang.Integer[][]";
		
		System.out.println(s.substring(s.indexOf(".")));
		System.out.println(s.substring(0, s.lastIndexOf(".")));

		
		System.out.println(subFromXToY(0, 1, "C1"));
		System.out.println(subFromXToY(1, 2, "C1"));
		
		System.out.println(dateTimeFormatChanger("20140318103025"));
		
		
		System.out.println(transformPeriod("PERIOD:20140506:20141010"));

		s = " (" + transformPeriod("PERIOD:20140506:20141010") + ") ";
		System.out.println(s.substring(s.length() - 25, s.length() - 2));
		
		
		System.out.println(reverseAliasToPeriod(" (2014.10.10 ~ 2014.12.12) "));
		
		s = "KHtest_repeat_repeat_ref_repeat2_repeat2_ref_repeat3_repeat3_ref_";
		String[] strArr = s.split(Pattern.quote("_ref_"));
		
		String name = "";
		for( int i = 0 ; i < strArr.length - 1 ; i++ ){
			name += strArr[i] + "_ref_";
		}
		System.out.println(name);
		
		s = "sc.body__repeat_ref__repeat2_ref__repeat3_ref_";
		
		System.out.println(getParentId(s));
		
		s = "ab";
		strArr = s.split(Pattern.quote("a"));
		System.out.println(strArr.length);
		strArr = s.split(Pattern.quote("b"));
		System.out.println(strArr.length);
		
		s = "sc.body_repeat_ref__repeat2_ref_";
		strArr = s.split(Pattern.quote("_ref_"));
		System.out.println(strArr.length);
		System.out.println(strArr[1]);
	}
	
	private static String subFromXToY(int x, int y, String s){
		return s.substring(x, y);
	}
	private static String dateTimeFormatChanger(String dttm){
		String out = null;
		out = dttm.substring(0, 4) + "-";
		out += dttm.substring(4, 6) + "-";
		out += dttm.substring(6, 8) + " ";
		out += dttm.substring(8, 10) + ":";
		out += dttm.substring(10, 12) + ":";
		out += dttm.substring(12,14);
		return out;
	}
	
	private static String getParentId(String name){
		String[] strArr = name.split(Pattern.quote("_ref_"));
		StringBuilder sb = new StringBuilder();
		for( int i = 0 ; i < strArr.length - 1 ; i++ ){
			sb.append( strArr[i] );
			sb.append( "_ref_" );
		}
		return sb.toString();
	}
	
	private static String transformPeriod(String procKey){
		if(!procKey.startsWith("PERIOD:")) 
			return null;
		StringBuilder transformedPeriod = new StringBuilder();
		procKey = procKey.replace("PERIOD:", "");
		procKey = procKey.replace(":", "");
		transformedPeriod.append(procKey.substring(0, 4));
		transformedPeriod.append(".");
		transformedPeriod.append(procKey.substring(4, 6));
		transformedPeriod.append(".");
		transformedPeriod.append(procKey.substring(6, 8));
		transformedPeriod.append(" ~ ");
		transformedPeriod.append(procKey.substring(8, 12));
		transformedPeriod.append(".");
		transformedPeriod.append(procKey.substring(12, 14));
		transformedPeriod.append(".");
		transformedPeriod.append(procKey.substring(14, 16));
		return transformedPeriod.toString();
	}
	
	private static String reverseAliasToPeriod(String alias){
		StringBuilder period = new StringBuilder();
		// alias = " (2014.11.11 ~ 2014.11.11) "
		period.append("PERIOD:");
		period.append(alias.substring(2, 6));
		period.append(alias.substring(7, 9));
		period.append(alias.substring(10, 12));
		period.append(":");
		period.append(alias.substring(15, 19));
		period.append(alias.substring(20, 22));
		period.append(alias.substring(23, 25));
		
		return period.toString();
	}
	
}

