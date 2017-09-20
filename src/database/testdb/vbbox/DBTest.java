package database.testdb.vbbox;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import numbers.GenerateNumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import strings.generateID;
import strings.generateName;
import exception.KHException;


public class DBTest {

	private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final static String JDBC_URL = "jdbc:oracle:thin:@BGHwang:1521:orcl";//"jdbc:oracle:thin:@centos.vb:1521:orcl";
	private final static String JDBC_USER = "scott";
	private final static String JDBC_PASSWD = "tiger";

	final Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		new DBTest().run();
	}

	protected void run() {

		Connection conn = null;

		logger.info("Start ... ");

		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e1) {
			logger.error("fail to load Driver : {} ", e1.getMessage());
			e1.printStackTrace();
		}

		try {

			conn = DriverManager
					.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWD);
			logger.info("DBMS Connected : {}", conn);

			conn.setAutoCommit(false);
			applicationRun(conn);
			conn.commit();

			logger.info("Normal End");

		} catch (SQLException e) {
			logger.error("Error End {}", e.getMessage());
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.rollback();
					conn.close();
				} catch (SQLException e) {
				}
			}
		}
	}

	protected void applicationRun(Connection conn) throws SQLException {

		final String sql = "select empno, ename from emp";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				logger.debug("{}, {}", rs.getInt(1), rs.getString(2));
				System.out.println(rs.getString("EMPNO") + "\t" + rs.getString("ENAME"));
			}

		} catch (SQLException e) {
			throw e;
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}
	
	private void insertBigTestDB(Connection conn) throws SQLException, KHException, IOException{
		String sql = "insert into BIGTABLE ";
		int age, zipcode = 0, height = 0, weight = 0;
		String id, fname, lname, addr1, addr2, state, marriage, eyecolor, handicap;
		
		id = generateID.genRndId(10, 0);
		age = GenerateNumber.genRndNum(18, 110);
		fname = generateName.genRndFName();
	    lname = generateName.genRndLName();
	    addr1 =
	    addr2 =
	    state =
	    marriage =
	    eyecolor =
	    handicap =
	    
		sql += "(ID, FNAME, LNAME, AGE, ADDR1, ADDR2, ZIPCODE, STATE, MARRIAGE, HEIGHT, WEIGHT, EYECOLOR, HANDICAP) ";
		sql += "values(" + id + ", " + fname + ", " + lname + ", " + age + ", " + addr1 + ", " + addr2 + ", " + zipcode + ", " + state + ", " + marriage + ", " + height + ", " + weight + ", " + eyecolor + ", " + handicap + ")";
		
		
		
		Statement stmt = null;
		ResultSet rs = null;
		try{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		}
		catch(SQLException e){
			
		}
		finally{
			if (stmt != null) {
				stmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		}
	}
}
