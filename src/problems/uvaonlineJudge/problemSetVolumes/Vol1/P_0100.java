/**
 * 작성된 날짜: 2014. 9. 4.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package problems.uvaonlineJudge.problemSetVolumes.Vol1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @file problems.uvaonlineJudge.problemSetVolumes.Vol1.P_0100.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 4. 	product 개발 	   신 규 작 성
 *
 */
public class P_0100 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<String> pairList = new ArrayList<String>();
		String s = "initial";
		while(s.length() > 0){
			s = sc.nextLine();
			pairList.add(s);
		}
		sc.close();
		
		
		for(String pair : pairList){
			if(pair.length() < 1) continue;
			int start = Integer.parseInt(pair.split(sc.delimiter().toString())[0]);
			int end = Integer.parseInt(pair.split(sc.delimiter().toString())[1]);
			if(start > end){
				int tmp = start;
				start = end;
				end = tmp;
			}
				
			System.out.println(String.format("%d %d %d", start, end, maxCycleLength(start, end)));
		}
		System.exit(0);
	}

	private static int maxCycleLength(int start, int end) {
		int maxCycleLength = Integer.MIN_VALUE;
		for(int i = start; i <= end ; i++){
			int num = cycleLength(i, 1);
			if(maxCycleLength < num)
				maxCycleLength = num;
		}
		return maxCycleLength;
	}

	private static int cycleLength(int i, int cnt) {
		int count = cnt;
		
		if(i == 1)
			return count;
		
		if(i % 2 == 1){
			i = 3*i + 1;
		}else{
			i = i / 2;
		}
		
		return cycleLength(i, ++count);
	}
}

