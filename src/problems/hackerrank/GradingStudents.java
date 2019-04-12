/**
 * Created on Apr 12, 2019 by Keichee
 */
package problems.hackerrank;

public class GradingStudents {

	public static void main(String[] args) {

	}

	static int[] gradingStudents(int[] grades) {
		int[] answer = new int[grades.length];
		for (int index = 0; index < grades.length; index++) {
			if (grades[index] < 38) {
				answer[index] = grades[index];
			} else if ((grades[index] + 1) % 5 == 0) {
				answer[index] = grades[index] + 1;
			} else if ((grades[index] + 2) % 5 == 0) {
				answer[index] = grades[index] + 2;
			} else {
				answer[index] = grades[index];
			}
		}
		return answer;
	}
}
