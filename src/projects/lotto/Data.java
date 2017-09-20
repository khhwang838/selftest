/**
 * 작성된 날짜: 2014. 9. 1.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package projects.lotto;

import java.util.ArrayList;

/**
 * @file lotto.DataTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 9. 1. 	product 개발 	   신 규 작 성
 *
 */
public class Data {
	
	private int[] data1;
	private ArrayList<Integer> data2;
	private int[] bonusData1;
	private ArrayList<Integer> bonusData2;
	
	public int[] getBonusData1() {
		return bonusData1;
	}
	public void setBonusData1(int[] bonusData1) {
		this.bonusData1 = bonusData1;
	}
	public ArrayList<Integer> getBonusData2() {
		return bonusData2;
	}
	public void setBonusData2(ArrayList<Integer> bonusData2) {
		this.bonusData2 = bonusData2;
	}
	public int[] getData1() {
		return data1;
	}
	public void setData1(int[] data1) {
		this.data1 = data1;
	}
	public ArrayList<Integer> getData2() {
		return data2;
	}
	public void setData2(ArrayList<Integer> data2) {
		this.data2 = data2;
	}
	
}

