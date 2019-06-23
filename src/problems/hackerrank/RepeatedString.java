package problems.hackerrank;

public class RepeatedString {

	public static void main(String[] args) {
		String s;
		s = "aba";
		System.out.println(repeatedString(s, 10));
		System.out.println(repeatedString2(s, 10));
		s = "a";
		System.out.println(repeatedString(s, 1000000000000l));
		System.out.println(repeatedString2(s, 1000000000000l));
	}
	static long repeatedString(String s, long n) {

		long countOfAs = 0;
		if(s.length() > n) {
			char[] arr = s.toCharArray();
			for(int i = 0; i < n ; i++) {
				if(arr[i] == 'a') countOfAs++;
			}
			return countOfAs;
		}
		
		// 스트링 s에 들어있는 a 개수
		countOfAs = s.length() - s.replaceAll("a", "").length();
		
		long division = n / (long)s.length();
		countOfAs *= division;
		
		
		
		int remainder = (int)(n % s.length());
		
		// s = abcdabcd (길이가 8)
		// n = 20
		// abcdabcd/abcdabcd/abcd (길이가 20인 string)
		
		// 1. 20 / 8 = 2
		
		String tmp = s.substring(0, remainder);
		char[] arr = tmp.toCharArray();
		for(char c : arr) {
			if(c == 'a') countOfAs = countOfAs + 1;
		}
		return countOfAs;
    }
	
	static long repeatedString2(String s, long n) {
		long count = 0;
		int remainder;
		for(int i = 0; i < n; i++) {
			remainder = (int) (i % s.length());
			if(s.charAt(remainder) == 'a') {
				count++;
			}
		}
		return count;
	}
}
