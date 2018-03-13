/**
 * 작성된 날짜: 2014. 11. 6.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package classLoader;

/**
 * @file classLoader.ClassLoaderTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 11. 6. 	product 개발 	   신 규 작 성
 *
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		ClassLoader loader = new ClassLoader() {
		};
		
		Class s = loader.loadClass(SuperClass.class.getName());
		Object so = s.newInstance();
		
		Class c = loader.loadClass(SubClass.class.getName());
		Object co = c.newInstance();
		
		Object o = loader.loadClass(SubClass.class.getName());
		
		System.out.println( ( co instanceof SuperClass ));
		System.out.println( ( o instanceof SuperClass ));
		
		
	}
	
	public static class SuperClass{
	}
	public static class SubClass extends SuperClass{		
	}
}

