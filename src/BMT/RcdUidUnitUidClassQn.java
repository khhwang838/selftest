/**
 * 작성된 날짜: 2014. 10. 21.
 * Copyright 2013 BankwareGlobal co. All rights reserved.
 */
package BMT;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @file BMT.RcdUidUnitUid.java
 * @filetype java source file
 * @brief
 * @author Kihyun.Hwang
 * @version 1.0
 * @history
 *
 * 성 명			일 자				근 거 자 료 	  변 경 내 용
 * ------------ ------------- 	------------ ------------ 
 * 황 기 현 		2014. 10. 21. 	product 개발 	   신 규 작 성
 *
 */
public class RcdUidUnitUidClassQn {

	private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String JDBC_URL = "jdbc:oracle:thin:@emerald:1521:orcl";//"jdbc:oracle:thin:@centos.vb:1521:orcl";
	private final static String JDBC_USER = "bxt";
	private final static String JDBC_PASSWD = "bxt";
	
	public static void main(String[] args) throws SQLException, IOException {
		
		makeFile(readRcdUidUnitUid());
		
		makeClassQnList(readClassQn());
		
	}
	
	private static void makeClassQnList(List<String> readClassQn) throws IOException {
		
		String filePath = "E:\\apache-jmeter-2.11\\BMT_TEST\\응답시간\\ClassQn.csv";
		
		System.out.println("writing file");

		// 파일 쓰기
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(filePath, false));

		StringBuilder sb; 
		for( String classQn : readClassQn ){
			sb = new StringBuilder();
			sb.append(classQn);
			sb.append("\r");
			
			writeFile.write( sb.toString() );
		}
		writeFile.close();
		
		System.out.println("Done.");
	}

	private static void makeFile(List<String[]> readRcdUidUnitUid) throws IOException {
		
		String filePath = "E:\\apache-jmeter-2.11\\BMT_TEST\\응답시간\\RcdUidUnitUid.csv";
		
		System.out.println("writing file");

		// 파일 쓰기
		BufferedWriter writeFile = new BufferedWriter(new FileWriter(filePath, false));

		StringBuilder sb; 
		for( String[] rowData : readRcdUidUnitUid ){
			sb = new StringBuilder();
			sb.append(rowData[0]);
			sb.append(",");
			sb.append(rowData[1]);
			sb.append("\r");
			
			writeFile.write( sb.toString() );
		}
		writeFile.close();
		
		System.out.println("Done.");
		
	}

	private static List<String[]> readRcdUidUnitUid() throws SQLException{
		
		System.out.println("\n o Reading Rcd, Unit UID from database");
		
		final List<String[]> out = new ArrayList<String[]>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);

			final String sql = "select test_rcd_uid, test_unit_uid from bxt_test_unit where rownum < 50000";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			String[] row;
			while (rs.next()) {
				row = new String[2];
				row[0] = rs.getString(1);
				row[1] = rs.getString(2);
				out.add(row);
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return out;
	}
	
	private static List<String> readClassQn() throws SQLException{
		
		System.out.println("\n o Reading ClassQn from database");
		
		final List<String> out = new ArrayList<String>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(JDBC_DRIVER);

			conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);

			final String sql = "select class_qn from bxt_class";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			String classQn;
			while (rs.next()) {
				classQn = rs.getString(1);
				out.add(classQn);
			}
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
		return out;
	}
}

