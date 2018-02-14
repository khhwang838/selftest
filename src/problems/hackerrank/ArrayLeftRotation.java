package problems.hackerrank;

import java.util.Scanner;

/**
 * Hackerrank.com
 * Arrays: Left Rotation
 * 
 * 배열의 개수 및 로테이션 횟수를 입력받고
 * 배열의 내용을 입력하면
 * 로테이션 횟수만큼 로테이션된 결과를 출력
 * 
 * Sample Input
 * 5 4
 * 1 2 3 4 5
 * 
 * Sample Output
 * 5 1 2 3 4
 * 
 * @author Kihyun
 * @created   2018-02-13
 */
public class ArrayLeftRotation {

	public static int[] arrayLeftRotation(int[] a, int n, int k) {
		// 배열의 사이즈만큼 복사하게되므로 메모리 낭비가 발생할 수 있음
		// TODO : System.arraycopy를 이용하여 메모리낭비를 절반으로 줄일 수 있을 듯
		// ex) k만큼의 배열값만 가지고 있으면 중복을 피할 수 있음
        int[] result = new int[n];
        for ( int idx = 0; idx < n; idx++ ){
            int pos = idx - k;
            if ( pos < 0)
                pos = n + pos;
            result[pos] = a[idx];
        }
		return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
      
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}
