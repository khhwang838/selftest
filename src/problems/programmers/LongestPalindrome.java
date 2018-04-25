package problems.programmers;

public class LongestPalindrome {

	public int solution(String s)
    {
        int answer = 0;
        answer = palindrome(s);
        return answer;
    }

	// TODO : 로직(속도) 개선 필요 !!!
	private int palindrome(String s) {
		if ( s.equals(reverse(s))) {
			return s.length();
		}
		else {
			int a = palindrome(s.substring(0, s.length()-1));
			int b = palindrome(s.substring(1, s.length()));
			return Math.max(a,b);
		}
		
	}
	private String reverse(String s) {
		return new StringBuffer(s).reverse().toString();
	}
	public static void main(String[] args) {
		LongestPalindrome lp = new LongestPalindrome();
		String s = "abacdedca";
		System.out.println( lp.solution(s));
	}
}
