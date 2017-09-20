/**
 * 작성된 날짜: 2014. 8. 5.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package BMT;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @file sourceGenerate.CSVGenerator.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 8. 5. 	product 개발 	   신 규 작 성
 *
 */
public class CSVGenerator {
	
	final static int numOfClasses = 1000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
	
	String fileName = "E:\\apache-jmeter-2.11\\BMT_TEST\\분기 커버리지 정합성\\test_2_1url.csv";
	
	BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
	List<String> iteration = new ArrayList<String>();
	
	String num = null;
	int nextNum = 0;
	String nextNumStr = null;
	
	String line;
	// 읽어오기
	System.out.println("reading file....");
	while((line = fileReader.readLine()) != null){
		num = line.substring(4, 8);
		nextNum = Integer.valueOf(num) + 1; 
		iteration.add(line);
	}
	fileReader.close();
	
	System.out.println("writing file....");
	// 파일 쓰기
	BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName, true));

		
	for(int j = 0 ; j < numOfClasses - 1; j++){
		
		nextNumStr = String.format("%04d", Integer.valueOf(nextNum));
		
		for(int i = 0; i < iteration.size() ; i++){
			iteration.set(i, iteration.get(i).replace(num, nextNumStr));
		}
		
		writeFile.write(listToString(iteration));
		nextNum++;
		num = nextNumStr;
	}
		
	writeFile.close();
	
	System.out.println("Done.");
}
	private static String listToString(List<String> newSrc) {
		StringBuilder builder = new StringBuilder();
		for(String s : newSrc){
			builder.append(s);
			builder.append("\n");
		}
		
		return builder.toString();
	}
}

