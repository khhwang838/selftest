/**
 * 작성된 날짜: 2014. 8. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package design_pattern.bridgePattern.implementorPart;

/**
 * @file design_pattern.bridgePattern.implementorPart.DrawingAPI_1.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 8. 21. 	product 개발 	   신 규 작 성
 *
 */
public class DrawingAPI_1 implements DrawingAPI{
	public void drawCircle(double x, double y, double radius) {
        System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
    }
}

