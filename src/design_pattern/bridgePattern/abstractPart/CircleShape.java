/**
 * 작성된 날짜: 2014. 8. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package design_pattern.bridgePattern.abstractPart;

import design_pattern.bridgePattern.implementorPart.DrawingAPI;


/**
 * @file design_pattern.bridgePattern.abstractPart.CircleShape.java
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
public class CircleShape extends Shape{
	private double x, y, radius;

	public CircleShape(double x, double y, double radius, DrawingAPI drawingAPI) {
		super(drawingAPI);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void draw() {
		drawingAPI.drawCircle(x, y, radius);
	}

	public void resizeByPercentage(double pct) {
		radius *= pct;
	}
}

