package problems.hackerrank;

import java.util.Scanner;

/**
 * 매 턴마다 행렬의 가장자리 겹 부터 가장 안쪽 겹까지 시계/반시계 방향으로 회전시키기
 * 
 *  1  2  3  4 
 *  5  6  7  8 
 *  9 10 11 12 
 * 13 14 15 16
 * 
 * to
 * 
 *  5  1  2  3 
 *  9 10  6  4 
 * 13 11  7  8 
 * 14 15 16 12
 * 
 * 
 * @author Kihyun
 * @created 2018-02-13
 */
public class MatrixTransformation1 {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		
		int tmp;
		for ( int posSrc = 0; posSrc < n; posSrc++ ) {
			int posDest = posSrc - k;
			if ( posDest < 0 )
				posDest = n + posDest;
			tmp = a[posDest];
			a[posDest] = a[posSrc];
			
		}
		return a;
	}

	public static void main(String[] args) {
		int[] a = new  int[] {1,2,3,4,5};
		int[] b;
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int k = in.nextInt();
//		int a[] = new int[n];
//		for (int a_i = 0; a_i < n; a_i++) {
//			a[a_i] = in.nextInt();
//		}
//
//		int[] output = new int[n];
//		output = arrayLeftRotation(a, n, k);
//		for (int i = 0; i < n; i++)
//			System.out.print(output[i] + " ");
//
//		System.out.println();

	}
	// 행렬 정의

	// 왼쪽 오른쪽 회전은 파라미터로 처리

	// 왼쪽으로 회전

	// 오른쪽으로 회전
}
