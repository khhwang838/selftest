/**
 * 작성된 날짜: 2014. 8. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package design_pattern.bridgePattern;

import design_pattern.bridgePattern.abstractPart.CircleShape;
import design_pattern.bridgePattern.abstractPart.Shape;
import design_pattern.bridgePattern.implementorPart.DrawingAPI_1;
import design_pattern.bridgePattern.implementorPart.DrawingAPI_2;

/**
 * @file design_pattern.bridgePattern.BridgePattern.java
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
public class BridgePattern {
	public static void main(String[] args) {
		Shape[] shapes = new Shape[2];
		shapes[0] = new CircleShape(1, 2, 3, new DrawingAPI_1());
		shapes[1] = new CircleShape(5, 7, 11, new DrawingAPI_2());

		for (Shape shape : shapes) {
			shape.resizeByPercentage(2.5);
			shape.draw();
		}
	}
}

