package sourceGenerate;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;

/**
 * �ۼ��� ��¥: 2014. 2. 13.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */

/**
 * @file .Generator.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 * 
 *          �� �� �� �� �� �� �� �� �� �� �� �� ------------ ------------- ------------
 *          ------------ Ȳ �� �� 2014. 2. 13. product ���� �� �� �� ��
 * 
 */

public class Generator {
	final static int MIN = 1;
	final static int MAX = 100;
	final static int numOfMethods = 1;
	final static int statementsPerMethods = 500;
	private static int numOfVarStatements = 4;

	public static void main(String[] args) throws IOException {
		/*
		 * args[0] : class name args[1] : number of methods
		 */

		// String filepath = args[0] + ".java" ;
		String filePath = "e:\\MethodsGenerated.java";
		String fileName = filePath.split(Pattern.quote("\\"))[filePath
				.split(Pattern.quote("\\")).length - 1];
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(filePath));

			String buf = "";
			// buf += startClass(args[0]);
			buf += startClass(fileName.split(Pattern.quote("."))[0]);
			buf += nextLine();
			for (int i = 0; i < numOfMethods; i++)
				buf += genRandomMethod(randNo(MIN, statementsPerMethods));
			buf += endBrace();

			bw.write(buf);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bw != null)
				bw.close();
		}
	}

	private static String startClass(String classNm) {
		return "public class " + classNm + " {";
	}

	private static String startMainMethod() {
		return "public static void main(String[] args){";
	}

	private static String endBrace() {
		return "}";
	}

	private static String nextLine() {
		return "\n\t";
	}

	private static String endLine() {
		return ";" + nextLine();
	}

	private static int randNo(int min, int max) {
		return (int) (min + Math.random() * (max - min));
	}

	private static String genAlpha(int length) {
		String out = "";
		int randChar = 0;
		for (int i = 0; i < length; i++) {
			while (randChar < 65 || (randChar > 90 && randChar < 97)
					|| randChar > 122)
				randChar = (int) (65 + Math.random() * 122);
			out += (char) randChar;
			randChar = 0;
		}
		return out;
	}

	private static String genAlphaNum(int length) {
		String out = "";
		int randChar = 0;
		for (int i = 0; i < length; i++) {
			while (randChar < 48 || (randChar > 57 && randChar < 65)
					|| (randChar > 90 && randChar < 97) || randChar > 122)
				randChar = (int) (48 + Math.random() * 122);
			out += (char) randChar;
			randChar = 0;
		}
		return out;
	}

	private static String genArithOper(int length) {
		String out = "";
		int index = 1;

		do {
			int randNo = (int) (MIN + Math.random() * MAX);
			out += randNo;

			int randOp = (int) (1 + Math.random() * 4);
			switch (randOp) {
			case 1:
				out += "+";
				break;
			case 2:
				out += "-";
				break;
			case 3:
				out += "*";
				break;
			case 4:
				out += "/";
				break;
			default:
				break;
			}
		} while (index-- > 0);
		int randNo = (int) (MIN + Math.random() * MAX);
		out += randNo;

		return out;
	}

	private static String genStrVar() {
		String out = "";
		out += "String " + genAlpha(randNo(1, 10))
				+ genAlphaNum(randNo(10, 11)) + " = " + "\""
				+ genAlphaNum(randNo(MIN, 50)) + "\"";
		return out;
	}

	private static String genInitializedStrVar() {
		String out = "";
		out += "String " + genAlpha(randNo(1, 10))
				+ genAlphaNum(randNo(10, 11)) + " = " + "\"" + "\"";
		return out;
	}

	private static String genIntVar() {
		String out = "";
		out += "int " + genAlpha(randNo(9, 10)) + " = ";
		return out;
	}

	private static String genInitializedIntVar() {
		String out = "";
		out += "int " + genAlpha(randNo(9, 10)) + " = 0";
		return out;
	}

	private static String genIfStatement() {
		String out = "";
		String intVar = genAlpha(10);
		out += "int " + intVar + " = " + randNo(MIN, MAX) + endLine() + "if( "
				+ intVar + " > " + MAX / 2 + "){" 
//				+ genSysOut(genAlphaNum(randNo(MIN, 50)))
				;
		out += endBrace();
		return out;
	}

//	private static String genSysOut(String str) {
//		String out = "";
//		out += "System.out.println(\"" + str + "\");";
//		return out;
//	}

	private static String genForLoop(int loopCnt) {
		String out = "";
		out += "for(int i=0; i<" + loopCnt + ";i++){";
		if (randNo(MIN, 10) % 2 == 0) {
			out += genIfStatement();
		} else{
//			out += genSysOut(genAlphaNum(randNo(MIN, 30)));
		}
		out += endBrace();

		return out;
	}

	private static String genRandomMethod(int numOfStatements) {
		String out = "";

		// Access Modifier
		out += "public ";

		// Return Type
		int returnType = (int) (1 + Math.random() * (3 - 1));
		if (returnType == 1)
			out += "int ";
		else if (returnType == 2)
			out += "String ";
		else
			out += "void ";

		// Method Name
		String methodNm = null;
		methodNm = genAlpha(1) + genAlphaNum(9); 
		out += methodNm;

		// Method Arguments
		out += "(){";
		out += nextLine();

		// Method Contents
		// creating statements
		int randNo;
		int tmpRand;
//		System.out.println( " " + methodNm + " : " + numOfStatements);
		for (int i = 0; i < numOfStatements; i++) {
			randNo = randNo(MIN, 100);

			switch (randNo % 15) {
			case 0:

				tmpRand = randNo(1, 10);
				if (tmpRand % 2 == 0) {
					out += genIntVar();
					out += genArithOper(randNo(2, 5));
					out += endLine();
				} else {
					out += genInitializedIntVar();
					out += endLine();
				}

				break;
			case 1:

				tmpRand = randNo(1, 10);
				if (tmpRand % 2 == 0) {
					out += genStrVar();
					out += endLine();
				} else {
					out += genInitializedStrVar();
					out += endLine();
				}
				break;
			case 2:
			case 3:
				out += genIfStatement() + nextLine();
				break;
			case 4:
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
//				out += genSysOut(genAlphaNum(randNo(MIN, 20))) + nextLine();
				break;	
			case 13:
			case 14:
				out += genForLoop(randNo(MIN, 3)) + nextLine();
				break;
			default:
				break;
			}
		}

		// return value
		switch (returnType) {
		case 1:
			out += "return " + randNo(MIN, MAX) + endLine();
			break;
		case 2:
			out += "return " + "\"" + genAlpha(randNo(MIN, 10)) + "\""
					+ endLine();
			break;
		case 3:
			break;
		default:
			break;
		}
		// Closing Method
		out += endBrace() + nextLine();

		return out;
	}

}
