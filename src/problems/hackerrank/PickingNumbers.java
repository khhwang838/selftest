package problems.hackerrank;

import java.util.List;

public class PickingNumbers {

	public static void main(String[] args) {

	}

	public static int pickingNumbers(List<Integer> numbers) {

		int[] countOfEachNumber = new int[99];
		
		// index [0][1][2][3][4]..[19]..[97][98]
		// value  0  0  0  0  0     0     0   0
		//                          3     5   0
		for(Integer number : numbers) {
			countOfEachNumber[number - 1]++;
		}

		int max = 0;
		
		for(int i = 0; i < countOfEachNumber.length -1; i++) {
			int subArrayLength = countOfEachNumber[i] + countOfEachNumber[i+1];
			if(max < subArrayLength) {
				max = subArrayLength;
			}
		}
		return max;
	}
}
