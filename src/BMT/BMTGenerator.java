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
 * @file sourceGenerate.BMTGenerator.java
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
public class BMTGenerator {

	public static void main(String[] args) throws IOException {
		
		String baseName = "E:\\BG\\BXTesterTFT\\egov\\eGov-2.7.0-64bit\\workspace\\BxTesterTestApp\\src\\main\\java\\bxs\\bmt\\service\\BMT";
		String fileName =  baseName + "0001.java";
		int numOfFiles = 1000;
		
		BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
		List<String> newSrc = new ArrayList<String>();
		String classDefLine = "public class BMT"; 
		String num = null;
		int newNum = 0;
		String newNumStr = null;
		
		
		String line;
		// 읽어오기
		while((line = fileReader.readLine()) != null){
			if(line.startsWith(classDefLine)){
				num = line.substring(16, 20);
				newNum = Integer.valueOf(num) + 1; 
			}
			newSrc.add(line);
		}
		fileReader.close();
		
		// 파일 쓰기
		while(--numOfFiles > 0){
			
			newNumStr = String.format("%04d", Integer.valueOf(newNum));
			System.out.println("BMT" + newNumStr + " generated.");
			
			for(int i = 0; i < newSrc.size() ; i++){
				if(newSrc.get(i).startsWith(classDefLine)){
					fileName = baseName + newNumStr + ".java";
					newSrc.set(i, newSrc.get(i).replace(num, newNumStr));
				}
				if(newSrc.get(i).contains("/BMT"+num)){
					newSrc.set(i, newSrc.get(i).replace(num, newNumStr));
				}
			}
			
			BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName, false));
			writeFile.write(listToString(newSrc));
			writeFile.close();
			newNum++;
			num = newNumStr;
			
		}
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

