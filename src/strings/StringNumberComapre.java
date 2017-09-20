package strings;
/**
 * �ۼ��� ��¥: 2014. 2. 27.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .StringNumberComapre.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� ��			�� ��				�� �� �� �� 	  �� �� �� ��
 * ------------ ------------- 	------------ ------------ 
 * Ȳ �� �� 		2014. 2. 27. 	product ���� 	   �� �� �� ��
 *
 */
public class StringNumberComapre {
	public static void main(String[] args) {
		String a = "20140503050402";
		String b = "201305030504020";
		if(Long.parseLong(a) < Long.parseLong(b))
			System.out.println(b);
		else
			System.out.println(a);
		
		String c = "1";
		String d = "0";
		String e = "1";
		String f = "2";
		System.out.println(c.compareTo(d));
		System.out.println(c.compareTo(e));
		System.out.println(c.compareTo(f));
	}
}

