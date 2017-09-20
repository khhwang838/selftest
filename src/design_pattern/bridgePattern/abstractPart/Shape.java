/**
 * 작성된 날짜: 2014. 8. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package design_pattern.bridgePattern.abstractPart;

import design_pattern.bridgePattern.implementorPart.DrawingAPI;


/**
 * @file design_pattern.bridgePattern.abstractPart.Shape.java
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
public abstract class Shape {
	protected DrawingAPI drawingAPI;

	protected Shape(DrawingAPI drawingAPI) {
		this.drawingAPI = drawingAPI;
	}

	public abstract void draw();

	public abstract void resizeByPercentage(double pct);
}

