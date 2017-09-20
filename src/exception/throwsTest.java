/**
 * 작성된 날짜: 2014. 6. 10.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package exception;

/**
 * @file exception.throwsTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 6. 10. 	product 개발 	   신 규 작 성
 *
 */
public class throwsTest {
	public static void main(String[] args) {
		
		caller();
	}
	
	private static void caller(){
		Integer i ;
		try{
			i = callee_I();
			System.out.println("callee_I : " + i);
			
		}catch(Exception e){
			System.out.println("caller에서 calle_I 예외 catch 처리 했음");
			
		}
		try {
			i = callee_II();
			System.out.println("callee_II : " + i);
		} catch (Exception e) {
			System.out.println("caller에서 calle_II 예외 catch 처리 했음");
		}
	}
	private static Integer callee_I() throws Exception{
		Integer out = 4;
		if(out != null){
			try {	// throws 선언이 없기 때문에 try-catch절 안에 throw절이 들어가야 한다.
				throw new Exception("callee_I 에서 예외 발생");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("callee_I 에서 발생한 exception catch.");
				e.printStackTrace();
			}
		}
		return out;
	}
	
	private static Integer callee_II() throws Exception {
		Integer out = 4;
		if(out != null)	// throws가 선언되어있으면 throw절을 try-catch절안에 넣을 필요가 없다.
			throw new Exception("returnInteger에서 예외 발생");
		return out;
	}
}

