/**
 * 작성된 날짜: 2014. 5. 13.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package genericType;


/**
 * @file genericType.ReturnType.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 13. 	product 개발 	   신 규 작 성
 *
 */
public class ReturnType {
	public static void main(String[] args) {
		String type1 = "R";
		String type2 = "C";
		String type3 = "G";
		String type4 = "H";
		
		System.out.println((genericReturnType(type1)).getClass());
		System.out.println((genericReturnType(type2)).getClass());
		System.out.println((genericReturnType(type3)).getClass());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println((genericReturnType(type4)).getClass());
	}
	public static <T extends RecordType> T genericReturnType(String type){
		if(type.equals("R")){
			Record r = new Record();
			return (T) r;
		}else if(type.equals("C")){
			Case c = new Case();
			return (T) c;
		}else if(type.equals("G")){
			Group g = new Group();
			return (T) g;
		}else throw new RuntimeException("\n[KH:Error]");
	}
	
	public static class RecordType{
		protected String type;
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
	}
	public static class Record extends RecordType{
		private String tmp;
		Record(){
			this.type = "r";
		}
		public String getTmp() {
			return tmp;
		}
		public void setTmp(String tmp) {
			this.tmp = tmp;
		}
	}
	public static class Case extends RecordType{
		
	}
	public static class Group extends RecordType{
		Group(){
			this.type="g";
		}
	}
	
}

