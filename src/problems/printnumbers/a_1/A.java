/**
 * 작성된 날짜: 2014. 9. 3.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package problems.printnumbers.a_1;

/**
 * @file problems.printnumbers.a_1.A.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 3. 	product 개발 	   신 규 작 성
 *
 */
public class A {

	final static int maxNum = 999;
	final static int rowCount = 7;
	
	/**
	 * 특정 개수만큼 가로로 증가하면서 숫자를 찍다가 밑으로 내려와서 왼쪽으로 가면서 다시 증분 숫자 찍는다. ( ㄹ 형태로 숫자가 증가한다. ) 
	 * @param args
	 */
	public static void main(String[] args) {
		int currentNum = 1;
		while(currentNum < maxNum){
			currentNum = printIncrease(currentNum);
			currentNum = printDecrease(currentNum);
		}
		
	}
	private static int printIncrease(int num){
		for(int i = 0; i < rowCount; i++){
			if(num > maxNum) break;
			System.out.print(String.format("%3d\t", num++));
		}
		System.out.println();
		return num;
	}
	private static int printDecrease(int num){
		int tmpNum = num + rowCount - 1;
		int pos = 0;
		int tmpNum2 = tmpNum;
		if(tmpNum > maxNum){
			pos = tmpNum - maxNum; 
			tmpNum = maxNum;
			tmpNum2 = tmpNum;
			for(int i = 0; i < pos; i++){
				System.out.print("   \t");
			}
		}
		
		for(int i = pos; i < rowCount; i++){
			System.out.print(String.format("%3d\t", tmpNum--));
		}
		System.out.println();
		return tmpNum2 + 1;
	}
}

