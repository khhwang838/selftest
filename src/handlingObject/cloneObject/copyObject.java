/**
 * 작성된 날짜: 2014. 6. 11.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package handlingObject.cloneObject;

/**
 * @file hadlingObject.copyObject.java
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
public class copyObject {
	public static void main(String[] args) {
		SomeObject so1 = new SomeObject();
		CopyObject co1 = new CopyObject();
		co1.setS("haha");
		so1.setCo(co1);
		SomeObject so2 = new SomeObject();
		so2.setCo(so1.getCo());
		SomeObject so3 = new SomeObject();
		CopyObject co2 = new CopyObject();
		co2 = so2.getCo();
		so3.setCo(co2);
		
		so2.getCo().setS("changed");
		System.out.println(co1.getS());
		System.out.println(so1.getCo().getS());
		
		System.out.println(so3.getCo().getS());
	}
	
	private static class SomeObject{
		private int i;
		private CopyObject co;
		
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public CopyObject getCo() {
			return co;
		}
		public void setCo(CopyObject co) {
			this.co = co;
		}
		
		
	}
	
	private static class CopyObject{
		private String s;

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}
		
		
	}
}

