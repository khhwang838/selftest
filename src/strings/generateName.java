/**
 * 작성된 날짜: 2014. 3. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import numbers.GenerateNumber;
import exception.KHException;

/**
 * @file strings.generateName.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 3. 21. 		product 개발 	   신 규 작 성
 *
 */
public class generateName {

	public static String genRndFName() throws KHException, IOException{
		String name="";
		String fnameFilePath = "";
		if(GenerateNumber.genRndNum(0, 20)%2 == 0){
			fnameFilePath = "D:\\lib\\femalefnamelist.txt";
		}
		else fnameFilePath = "D:\\lib\\malefnamelist.txt";
		FileReader fr = new FileReader(fnameFilePath);
		BufferedReader br = new BufferedReader(fr);
		List<String> nameList = new ArrayList<String>();
		while(true){
			String line = br.readLine();
			if(line != null)
				nameList.add(line);
			else break;
		}
		int rndName = GenerateNumber.genRndNum(0, nameList.size());
		name = nameList.get(rndName);
		fr.close();
		br.close();
		return name;
	}
	
	public static String genRndLName() throws KHException, IOException{
		String name="";		
		String fnameFilePath = "D:\\lib\\lnamelist.txt";
		FileReader fr = new FileReader(fnameFilePath);
		BufferedReader br = new BufferedReader(fr);
		List<String> nameList = new ArrayList<String>();
		while(true){
			String line = br.readLine();
			if(line != null)
				nameList.add(line);
			else break;
		}
		int rndName = GenerateNumber.genRndNum(0, nameList.size());
		name = nameList.get(rndName);
		fr.close();
		br.close();
		return name;
	}
}





