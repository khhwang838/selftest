package _temp;

import java.util.Date;
import java.util.Scanner;
import java.util.UUID;

public class SomeTests {

	public static void main(String[] args) {
		boolean answer = true;
		String s = "1234";
      if(s.length() != 4 && s.length() != 6){
//    	    return false;
          System.out.println(false);
          return;
      }
      try {
          Integer.parseInt(s);
      } catch (NumberFormatException e) {
//          return false;
          System.out.println(false);
      }
//      return answer;
      System.out.println(answer);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 2b2a60f6-58ad-4069-aa6d-b1649c590231
		// 2b2a60f658ad4069aa6db1649c590231
//		System.out.println(UUID.randomUUID().toString().replaceAll("-", ""));

		// 1. ID 조회 (가장 큰 ID값 조회, select)
		// select max(id) from [테이블명]
		// 2. 조회한 ID를 LottoData number.setId(id);
		// 3. DB에 저장 (insert)
		// insert into [테이블명] values ({id}, {num1}, {num2});
//		insert into [테이블명] (id, num6, num5, num4...) values ({id}, {num6});
		
		
		
//		Date f = new Date(1513231414000L);
//		System.out.println(f);
//		System.out.println(f);
	}
	private static void test2() {
		String a = "";
		String b = new String("");
		String c = String.valueOf("");
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		System.out.println(a==c);
		System.out.println(a.equals(c));
	}
	private static void test1() {
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
