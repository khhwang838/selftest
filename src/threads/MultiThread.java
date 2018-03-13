package threads;
/**
 * �ۼ��� ��¥: 2014. 2. 18.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .MultiThreadRunnable.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� �� 			�� �� 			�� �� �� �� 		�� �� �� ��
 * ------------ ------------- 	------------ 	------------ 
 * Ȳ �� �� 		2014. 2. 18. 	product ���� 		�� �� �� ��
 *
 */


class MThread1 implements Runnable{
	Object obj = new Object();
	int i=0;
	@Override
	public void run() {
		while(true){
			System.out.println("Thread 1 : " + i++);
			synchronized(obj){
				try {
					obj.wait(3000 + (long)Math.random()*(5000-3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
class MThread2 extends Thread{
	Object obj = new Object();
	int i=0;
	@Override
	public void run() {
		while(true){
			System.out.println("Thread 2 : " + i++);
			synchronized(obj){
				try {
					obj.wait(2000 + (long)Math.random()*(5000-2000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
	}
}
class MThread3 extends Thread{
	Object obj = new Object();
	@Override
	public void run() {
		while(true){
			System.out.println(".");
			synchronized(obj){
				try {
					obj.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} 
		}
	}
}
public class MultiThread{
	
	public static void main(String[] args) {
		MThread1 mtr1 = new MThread1();
		MThread2 mtr2 = new MThread2();
		Thread t1 = new Thread(mtr1);
		Thread t2 = new Thread(mtr2);
		Thread t3 = new Thread(new MThread3());
		t1.start();
		t2.start();
		t3.start();
		
	}

	
	
}

