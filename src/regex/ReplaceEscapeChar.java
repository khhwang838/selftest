package regex;

import java.util.regex.Pattern;

public class ReplaceEscapeChar {

	public static void main(String[] args) {
		String str = "\\(^.^)/";
		str = str.replaceAll(Pattern.quote("\\"),"\\\\\\\\");
		System.out.println(str);
	}
}
