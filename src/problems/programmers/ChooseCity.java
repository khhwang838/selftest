package problems.programmers;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 인구수가 다른 여러 도시들 중 어느곳에 공항을 건설해야 모든 사람들의 이동시간을 최소화할 수 있는가? 
 * @author Kihyun
 * @created   2018-04-25
 */
public class ChooseCity {

	// TODO : 로직 수정 필요.
	public int chooseCity(int n, int[][] city) {
		
		sortArray(city);
		
		int answer = 0;
		
		int pplTotal = 0;
		for ( int i = 0 ; i < n ; i++ ) {
			pplTotal += city[i][1];
		}
		int pplHalf = pplTotal/2;
		for ( int i = 0, sum = 0 ; i < n ; i++ ) {
			sum += city[i][1];
			if ( sum > pplHalf ) {
				answer = city[i][0];
				break;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		ChooseCity test = new ChooseCity();
		int tn = 3;
		int[][] tcity = { { 1, 5 }, { 2, 2 }, { 3, 3 } };
		System.out.println(test.chooseCity(tn, tcity));
	}
	
	public void sortArray(int[][] arr) {
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] arr1, int[] arr2) {
				return Integer.compare(arr1[0], arr2[0]);
			}
		});
	}
}
