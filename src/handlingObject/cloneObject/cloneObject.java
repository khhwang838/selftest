/**
 * 작성된 날짜: 2014. 6. 11.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package handlingObject.cloneObject;

/**
 * @file hadlingObject.cloneObject.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 6. 11. 	product 개발 	   신 규 작 성
 *
 */
public class cloneObject {
	public static void main(String[] args) {
		Obj o = new Obj();
		Obj clone = o.clone();
		
		o.setS("haha");
		System.out.println(clone.getS());
	}
	
	private static class Obj {
		private int i;
		private String s;
		
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public String getS() {
			return s;
		}
		public void setS(String s) {
			this.s = s;
		}
		public Obj clone(){
			Obj out = new Obj();
			out.setI(i);
			out.setS(s);
			return out;
		}
		
	}
}

