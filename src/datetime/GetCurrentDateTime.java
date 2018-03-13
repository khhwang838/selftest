package datetime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * �ۼ��� ��¥: 2014. 2. 20.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .GetCurrentTime.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * �� �� �� �� �� �� �� �� �� �� �� ��
 * ------------ ------------- ------------ ------------ 
 * Ȳ �� �� 2014. 2. 20. product ���� �� �� �� ��
 *
 */

public class GetCurrentDateTime {
	public static void main(String[] args) {
		System.out.println(new SimpleDateFormat("yyMMddHHmmss").format(new 
				Date()));
	}
}

