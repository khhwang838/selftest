package problems.hackerrank;

public class SuperReducedString {

	public static void main(String[] args) {
		System.out.println(superReducedString("aaabccddd"));
		System.out.println(superReducedString("baab"));
		String[] arr = "abcde".split("");
		System.out.println(String.join("", arr));
		
	}

//	static String superReducedString(String s) {
//
//		if (isSuperReduced(s)) {
//			if (s.isEmpty()) {
//				return "Empty String";
//			}
//			return s;
//		}
//
//		char prev = 0;
//		char[] chars = s.toCharArray();
//		for (int i = 0; i < chars.length; i++) {
//			char c = chars[i];
//			if (prev == c) {
//				chars[i] = 0;
//				chars[i - 1] = 0;
//				prev = 0;
//			} else {
//				prev = chars[i];
//			}
//		}
//		
//		StringBuilder sb = new StringBuilder();
//		for (char c : chars) {
//			if (c > 0) {
//				sb.append(c);
//			}
//		}
//		return superReducedString(sb.toString());
//	}

	static String superReducedString(String s) {

		if (isSuperReduced(s)) {
			if (s.isEmpty()) {
				return "Empty String";
			}
			return s;
		}

		s = s.replaceAll("(.)\\1", "");

		return superReducedString(s);
	}

	private static boolean isSuperReduced(String s) {
		if (s.isEmpty() || s.length() == 1) {
			return true;
		}
		// baab
		char[] chars = s.toCharArray();
		char tmp = 0;
		for (char c : chars) {
			if (c == tmp) {
				return false;
			}
			tmp = c;
		}
		return true;
	}
}
