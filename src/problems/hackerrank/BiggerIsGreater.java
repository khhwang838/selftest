/**
 * Created on Apr 11, 2019 by Keichee
 */
package problems.hackerrank;

import java.util.Arrays;

import org.junit.Assert;

public class BiggerIsGreater {
	public static void main(String[] args) {
		Assert.assertEquals("ba", biggerIsGreater("ab")); // ba
		Assert.assertEquals("no answer", biggerIsGreater("bb")); // no answer
		Assert.assertEquals("hegf", biggerIsGreater("hefg")); // hegf
		Assert.assertEquals("dhkc", biggerIsGreater("dhck")); // dhkc
		Assert.assertEquals("hcdk", biggerIsGreater("dkhc")); // hcdk
	}

	static String biggerIsGreater(String w) {
		if (w.length() == 1)
			return "no answer";

		char[] chars = w.toCharArray();
		boolean isSwapped = false;
		for (int index = chars.length - 1; index > 0; index--) {
			if (chars[index - 1] < chars[index]) {
				// swap
				String wSub = w.substring(index);
				
				// sub-array만 추출하여 정렬
				char[] wSubArr = wSub.toCharArray();
				Arrays.sort(wSubArr);
				
				// 정렬된 sub-array를 이용하여 chars도 정렬
				int idx = index - 1;
				for (int subArrIndex = 0; subArrIndex < wSub.length(); subArrIndex++) {
					if(!isSwapped && chars[idx] < wSubArr[subArrIndex]) {
						char temp = chars[idx]; 
						chars[idx] = wSubArr[subArrIndex];
						wSubArr[subArrIndex] = temp; 
						isSwapped = true;
					}
					chars[index++] = wSubArr[subArrIndex];
				}
				break;
			}
		}
		if (isSwapped) {
			return String.valueOf(chars);
		} else {
			return "no answer";
		}
	}

	static void swapSubarr(char[] chars, int index) {
		
	}
}
