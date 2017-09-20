package modifiers.volatileTest;


/**
 * 작성된 날짜: 2014. 8. 1.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .volatileModifier.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 8. 1. 	product 개발 	   신 규 작 성
 *
 */
public class VolatileModifier {
	
	public static volatile String volatileString;
//	public static synchronized String volatileStringSync; synchronized는 
	
	
	public static void main(String[] args) {
		(new stringChangerThread("기현")).start();
		(new stringChangerThread("상욱")).start();
		
	}
	
	static class stringChangerThread extends Thread{
		
		String name;
		
		stringChangerThread(String name){
			this.name = name;
		}
		public void run(){
			while(true){
				synchronized(stringChangerThread.class){
					volatileString = name;
					System.out.println(name + " Thread : " + volatileString );
				}
				try {
//					Thread.sleep(GenerateNumber.genRndNumLong(0, 1000));
					Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Exception.......");
				}
			}
		}
	}
}

