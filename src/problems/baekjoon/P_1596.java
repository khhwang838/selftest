/**
 * Created on Dec 22, 2018 by Keichee
 */
package problems.baekjoon;

import java.util.Scanner;

public class P_1596 {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		int count = 0;
		for ( int i = a; i <= b; i++){
			if(getFingerPrint(i) == 7){
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	
	
	public static int getFingerPrint(int num) {
		if ( num / 10 == 0) {
			return num;
		} else {
			String numStr = String.valueOf(num);
			StringBuilder sb = new StringBuilder();
			
			for ( int i = 0; i < numStr.length() - 1; i++) {
				// 인접한 숫자의 차이 구하기
				int diff = Math.abs(numStr.charAt(i) - numStr.charAt(i+1));
				// 저장하기
				sb.append(diff);
			}
			int temp = Integer.valueOf(sb.toString());
			return getFingerPrint(temp);
		}
	}
	public static void printMemory(){
		long memory = Runtime.getRuntime().totalMemory();
		System.out.println(memory + " bytes, " + memory/1024 + " kb" );
	}
}
