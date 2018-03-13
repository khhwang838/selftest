/**
 * 작성된 날짜: 2014. 6. 9.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package strings;

/**
 * @file strings.stringBuilder.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 6. 9. 	product 개발 	   신 규 작 성
 *
 */
public class stringBuilder {
	public static void main(String[] args) {
		StringBuilder sql = new StringBuilder();
		sql.append(" select ");
		sql.append(" concat(concat(substr(cfg_key, 11, length(cfg_key)), ':'), cfg_val) as recrule ");
		sql.append(" from BXT_CONFIG where CFG_KEY like 'rec.class.%' ");
		System.out.println(sql.toString());
	}
}

