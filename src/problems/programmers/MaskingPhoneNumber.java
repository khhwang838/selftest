/**
 * Created on Feb 16, 2019 by Keichee
 */
package problems.programmers;

public class MaskingPhoneNumber {

	public static void main(String[] args) {
		System.out.println(solution("6667"));
		System.out.println(solution("010234236667"));
	}

	public static String solution(String phone_number) {
		int length = phone_number.length();
		// 1. substrig + replace
//		 String subStr = phone_number.substring(0, length-4);
//		 subStr = subStr.replaceAll(".", "*");	// 정규표현식
//		 String answer = subStr + phone_number.substring(length-4, length);
//		 return answer;

		// 2. char array + loop
		char[] charArray = phone_number.toCharArray();
//		String result = "";
//		for (int i = 0; i < length; i++) {
//			if ( i < length-4) {
//				result += "*";	// --> StringBuilder 사용 권장
//			} else {
//				result += charArray[i]; 
//			}
//		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < length; i++) {
			if ( i < length-4) {
				result.append("*");	// --> StringBuilder 사용 권장
			} else {
				result.append(charArray[i]); 
			}
		}
		return result.toString();
	}
}
