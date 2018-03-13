/**
 * 작성된 날짜: 2014. 10. 22.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package BCItest;

import java.io.IOException;

import org.junit.Test;
import org.objectweb.asm.ClassReader;

/**
 * @file BCItest.BCITest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 10. 22. 	product 개발 	   신 규 작 성
 *
 */
public class BCITest {

	@Test
	public void test() throws IOException {
		MyClassVisitor cv = new MyClassVisitor(327680);	// ASM5 = 327680
		ClassReader cr = new ClassReader("BCITest.HelloWorld");
		cr.accept(cv, 2);
		
	}

}

