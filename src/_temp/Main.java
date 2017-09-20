package _temp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numOfTestCases = sc.nextInt();

		int[][] nums = new int[numOfTestCases][6];

		for (int j = 0; j < numOfTestCases; j++) {
			
			for (int i = 0; i < 6; i++) {
				nums[j][i] = sc.nextInt();
			}
		}
		
		for ( int x = 0; x < numOfTestCases ; x++ ){
			
			if (nums[x][0] == nums[x][3] && nums[x][1] == nums[x][4] ){
				if ( nums[x][2] == nums[x][5] ){
					System.out.println(-1);
				}else{
					System.out.println(0);
				}
				continue;
			}
			
			double distanceBetweenTurrets = Math.sqrt(Math.pow(nums[x][0] - nums[x][3], 2) + Math.pow(nums[x][1] - nums[x][4], 2));
			
			if ( distanceBetweenTurrets == nums[x][2] + nums[x][5] 
					|| distanceBetweenTurrets + nums[x][2] == nums[x][5]
							|| distanceBetweenTurrets + nums[x][5] == nums[x][2]){
				System.out.println(1);
			}else if ( distanceBetweenTurrets < nums[x][2] + nums[x][5] ){
				if( distanceBetweenTurrets + nums[x][2] < nums[x][5]
						|| distanceBetweenTurrets + nums[x][5] < nums[x][2] ){
					System.out.println(0);
				}else{
					System.out.println(2);
				}
			}else{
				System.out.println(0);
			}
		}
	}
}
