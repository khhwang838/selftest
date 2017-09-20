/**
 * 작성된 날짜: 2014. 6. 12.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package handlingFile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @file handlingFile.CRUD.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 6. 12. 	product 개발 	   신 규 작 성
 *
 */
public class CRUD {
	public static void main(String[] args) throws IOException {
		String fileName = "E:\\testfile.txt";
		File file = new File( fileName);
		file.createNewFile();
		
		// 파일 읽기
		if(file.canRead()){
			BufferedInputStream readFile = new BufferedInputStream(new FileInputStream(file));
			if(readFile.available() == 0){
				// 파일 쓰기
				BufferedWriter writeFile = new BufferedWriter(new FileWriter(fileName, true));
				writeFile.append("파일 쓰기 테스트");
				writeFile.close();
			}
			readFile.close();
			// 읽어와서 출력하기
			BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
			String s;
			while((s = fileReader.readLine()) != null){
				System.out.println(s);
			}
			fileReader.close();
			
		}
		else
			System.out.println("Cannot read file");
		
	}
}

