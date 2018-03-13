package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * �ۼ��� ��¥: 2014. 2. 13.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .ReflectionTest.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� �� �� �� �� �� �� �� �� �� �� ��
 * ------------ ------------- ------------ ------------ 
 * Ȳ �� �� 2014. 2. 13. product ���� �� �� �� ��
 *
 */
public class ReflectionTest {
		public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
			Object c = Class.forName("MethodsGenerated").newInstance();
			Method[] m = c.getClass().getDeclaredMethods();
			int i=0;
			for(Method method : m){
				method.invoke(c,new Object[0]);
				i++;
			}
			System.out.println();
			System.out.println(i);
			System.out.println();
		}
		
}

