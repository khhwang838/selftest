/**
 * 작성된 날짜: 2014. 5. 20.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package threads;

/**
 * @file threads.ThreadTest_1.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 5. 20. 	product 개발 	   신 규 작 성
 *
 */
public class ThreadTest_1{
	
	public static void main(String[] args) throws InterruptedException {
		ThreadTest t1 = new ThreadTest();
		ThreadTest t2 = new ThreadTest();
		ThreadTest t3 = new ThreadTest();
		
		t1.start();
		Thread.sleep(1000);
		t2.start();
		Thread.sleep(1000);
		t3.start();
		
	}

	private static class ThreadTest extends Thread{
		private static Integer sync = 0; 
		public synchronized void run(){
			synchronized(sync){
				while(true){
					System.out.println(this.getName() + " : " + sync++);
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}


