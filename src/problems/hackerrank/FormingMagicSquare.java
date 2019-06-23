/**
 * Created on Apr 12, 2019 by Keichee
 */
package problems.hackerrank;

public class FormingMagicSquare {
	public static void main(String[] args) {
		// TODO : wrong answer
	}

	static int formingMagicSquare(int[][] s) {
		int magicNum = 15;
		int diagonalSum = 0;
		int[] rowSums = new int[s.length];
		int[] colSums = new int[s.length];

		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s[i].length; j++) {
				if(i==j) {
					diagonalSum += s[i][j];
				}
				rowSums[i] += s[i][j];
				colSums[j] += s[i][j];
			}
		}

		int rowDiff = 0;
		int colDiff = 0;
		int diagonalDiff = Math.abs(diagonalSum - magicNum);
		int answer = 0;
		
		for(int i = 0 ; i < rowSums.length; i++) {
			rowDiff = rowSums[i] - magicNum;
			colDiff = colSums[i] - magicNum;
			answer += Math.abs(rowDiff - colDiff);
		}
		answer += diagonalDiff;
		return answer;
	}
}
