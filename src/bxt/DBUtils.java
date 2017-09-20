package bxt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	private static final DBUtils instance = new DBUtils();
	private static Connection conn;
	private final String url = "jdbc:oracle:thin:@182.162.100.120:10110:orcl";
	private final String user = "bxtqem";
	private final String passwd = "bxtqem";
	private final String driver = "oracle.jdbc.driver.OracleDriver";
	
	public static DBUtils instance(){
		return instance;
	}
	
	public Connection getConnection() {
		
		try{
			if ( conn == null || conn.isClosed() ){
				Class.forName(driver);
				System.out.println("Connecting to database....");
				conn = DriverManager.getConnection(url, user, passwd);
				conn.setAutoCommit(false);
			}			
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
