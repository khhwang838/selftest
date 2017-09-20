package bxt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateBXTTables {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		CreateBXTTables ct = new CreateBXTTables();
		
		System.out.println("Creating tables....BXT_TEST_UNIT");
		ct.createTestUnitTables("BXT_TEST_UNIT");
		
		System.out.println("Creating tables....BXT_TEST_UNIT_OBJECT");
		ct.createTestUnitObjectTables("BXT_TEST_UNIT_OBJECT");
		
		System.out.println("Creating tables....BXT_TEST_UNIT_EXEC_LINE");
		ct.createTestUnitExecLineTables("BXT_TEST_UNIT_EXEC_LINE");
		
		System.out.println("Creating tables....BXT_TEST_UNIT_EXCEPTION");
		ct.createTestUnitExceptionTables("BXT_TEST_UNIT_EXCEPTION");
		
	}
	
	private void createTestUnitTables(String baseTableName) throws SQLException, ClassNotFoundException{
		
		int num = 1;
		
		for ( ; num < 32 ; num++ ){
			List<String> ddlForOneTable = getTestUnitTableDDL(baseTableName + "_" + String.format("%2d", num).replace(' ', '0'));
			executeDDL(ddlForOneTable);
		}
	}
	
	private void createTestUnitObjectTables(String baseTableName) throws SQLException, ClassNotFoundException{
		int num = 1;
		
		for ( ; num < 32 ; num++ ){
			List<String> ddlForOneTable = getTestUnitObjectTableDDL(baseTableName + "_" + String.format("%2d", num).replace(' ', '0'));
			executeDDL(ddlForOneTable);
		}
	}
	private void createTestUnitExecLineTables(String baseTableName) throws SQLException, ClassNotFoundException{
		int num = 1;
		
		for ( ; num < 32 ; num++ ){
			List<String> ddlForOneTable = getTestUnitExecLineTableDDL(baseTableName + "_" + String.format("%2d", num).replace(' ', '0'));
			executeDDL(ddlForOneTable);
		}
	}
	private void createTestUnitExceptionTables(String baseTableName) throws SQLException, ClassNotFoundException{
		int num = 1;
		
		for ( ; num < 32 ; num++ ){
			List<String> ddlForOneTable = getTestUnitExceptionTableDDL(baseTableName + "_" + String.format("%2d", num).replace(' ', '0'));
			executeDDL(ddlForOneTable);
		}
	}
	
	private void executeDDL(List<String> ddlList) throws ClassNotFoundException{
		
		Connection conn = DBUtils.instance().getConnection();
		PreparedStatement ps = null;
		
		boolean isSuccess = true;
		
		System.out.println("Executing DDLs.....");
		
		try{
			for ( int i = 0 ; i < ddlList.size() ; i++ ){
				System.out.println("executes : " + ddlList.get(i));
				ps = conn.prepareStatement(ddlList.get(i));
				ps.execute();
				
				System.out.println((i+1) + " : " + ps.getUpdateCount());
			}
			
			if ( isSuccess ){
				conn.commit();
			}else{
				conn.rollback();
			}
			if ( ps != null ){
				ps.close();
			}
			if ( conn != null ){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	private List<String> getTestUnitTableDDL(String tableName) {

		String createTable = "CREATE TABLE " + tableName + " (" 
				+ " TEST_UNIT_UID VARCHAR2(32) NOT NULL,"
				+ " CALLER_TEST_UNIT_UID VARCHAR2(32) NOT NULL,"
				+ " TEST_UNIT_NM VARCHAR2(1000),"
				+ " ROOT_TEST_UNIT_UID VARCHAR2(32) NOT NULL,"
				+ " RESULT_CD VARCHAR2(1) NOT NULL," 
				+ " OBJECT_HASH_ID VARCHAR2(128),"
				+ " OBJECT_RCD_TRG_YN VARCHAR2(1),"
				+ " EXCEPTION_TEST_UNIT_UID VARCHAR2(32),"
				+ " SYS_ID VARCHAR2(16) NOT NULL," 
				+ " CLASS_ID VARCHAR2(64) NOT NULL,"
				+ " METHOD_ID VARCHAR2(32) NOT NULL,"
				+ " METHOD_VER_HASH_ID VARCHAR2(128) NOT NULL,"
				+ " CALLER_CLASS_ID VARCHAR2(64)," 
				+ " CALLER_METHOD_ID VARCHAR2(32),"
				+ " CALLER_METHOD_VER_HASH_ID VARCHAR2(128),"
				+ " METHOD_CALL_CNT NUMBER(8)," 
				+ " CST_01_FIELD_VAL VARCHAR2(50),"
				+ " CST_02_FIELD_VAL VARCHAR2(50),"
				+ " CST_03_FIELD_VAL VARCHAR2(50),"
				+ " CST_04_FIELD_VAL VARCHAR2(50)," 
				+ " BASE_DATE VARCHAR2(8) NOT NULL,"
				+ " BEGIN_DTTM VARCHAR2(23)," 
				+ " END_DTTM VARCHAR2(23),"
				+ " ELAPSED_SEC NUMBER(8)," 
				+ " NANO_TIME NUMBER(19),"
				+ " STATS_PROC_YN VARCHAR2(1) NOT NULL," 
				+ " AGENT_ID VARCHAR2(32),"
				+ " PROC_ID VARCHAR2(16)," 
				+ " THREAD_NM VARCHAR2(1000),"
				+ " AGENT_CD VARCHAR2(1)," 
				+ " NRM_PROC_CNT NUMBER(8),"
				+ " ERR_PROC_CNT NUMBER(8)," 
				+ " RECURS_PROC_CNT NUMBER(8)" + ")";
		String createUniqIndex = "CREATE UNIQUE INDEX PK_" + tableName + " ON " + tableName + " ( TEST_UNIT_UID ASC )";
		String createUniqIndex01 = "CREATE INDEX IX_" + tableName + "_01 ON " + tableName
				+ " ( BEGIN_DTTM ASC, RESULT_CD ASC, CLASS_ID ASC )";
		String createUniqIndex02 = "CREATE INDEX IX_" + tableName + "_02 ON " + tableName
				+ " ( ROOT_TEST_UNIT_UID ASC, CALLER_TEST_UNIT_UID ASC )";
		String createUniqIndex03 = "CREATE INDEX IX_" + tableName + "_03 ON " + tableName
				+ " ( BASE_DATE ASC, STATS_PROC_YN ASC, BEGIN_DTTM ASC )";
		String makeUniqIndexAsPK = "ALTER TABLE " + tableName + " ADD CONSTRAINT PK_" + tableName
				+ " PRIMARY KEY ( TEST_UNIT_UID )";

		List<String> ddlList = new ArrayList<String>();
		ddlList.add(createTable);
		ddlList.add(createUniqIndex);
		ddlList.add(createUniqIndex01);
		ddlList.add(createUniqIndex02);
		ddlList.add(createUniqIndex03);
		ddlList.add(makeUniqIndexAsPK);
		
		return ddlList;
	}
	private List<String> getTestUnitObjectTableDDL(String tableName){
		
		String createTable = "CREATE TABLE "+ tableName +" ("
				+ " TEST_UNIT_UID VARCHAR2(32) NOT NULL,"
				+ " OBJECT_CD VARCHAR2(1) NOT NULL,"
				+ " OBJECT_SEQ NUMBER(8) NOT NULL,"
				+ " SYS_ID VARCHAR2(16) NOT NULL,"
				+ " OBJECT_QN VARCHAR2(1000),"
				+ " SIZE_EXCEED_YN VARCHAR2(1),"
				+ " OBJECT_DATA BLOB,"
				+ " BASE_DATE VARCHAR2(8) NOT NULL,"
				+ " REG_DTTM VARCHAR2(23) NOT NULL "
				+ ")";
		
		String createUniqIndex = "CREATE UNIQUE INDEX PK_"+ tableName
				+ " ON "+ tableName +" ("
				+ " TEST_UNIT_UID ASC,"
				+ " OBJECT_CD ASC,"
				+ " OBJECT_SEQ ASC"
				+ " )";
		String makeUniqIndexAsPK = "ALTER TABLE " + tableName
				+ " ADD"
				+ " CONSTRAINT PK_" + tableName
				+ " PRIMARY KEY ("
				+ " TEST_UNIT_UID,"
				+ " OBJECT_CD,"
				+ " OBJECT_SEQ"
				+ " )";
		
		List<String> ddlList = new ArrayList<String>();
		ddlList.add(createTable);
		ddlList.add(createUniqIndex);
		ddlList.add(makeUniqIndexAsPK);
		return ddlList;
	}
	private List<String> getTestUnitExecLineTableDDL(String tableName){
		
		String createTable = "CREATE TABLE "+ tableName +" ("
				+ " TEST_UNIT_UID VARCHAR2(32) NOT NULL,"
				+ " SEQ NUMBER(8) NOT NULL,"
				+ " SYS_ID VARCHAR2(16) NOT NULL,"
				+ " LINE_DATA VARCHAR2(4000),"
				+ " BASE_DATE VARCHAR2(8) NOT NULL,"
				+ " REG_DTTM VARCHAR2(23) NOT NULL "
				+ ")";
		String createUniqIndex = "CREATE UNIQUE INDEX PK_" + tableName
				+ " ON "+ tableName +" ("
				+ " TEST_UNIT_UID ASC,"
				+ " SEQ ASC"
				+ " )";
		String makeUniqIndexAsPK = "ALTER TABLE " + tableName 
				+ " ADD"
				+ " CONSTRAINT PK_" + tableName
				+ " PRIMARY KEY ("
				+ " TEST_UNIT_UID,"
				+ " SEQ"
				+ " )";
		
		List<String> ddlList = new ArrayList<String>();
		ddlList.add(createTable);
		ddlList.add(createUniqIndex);
		ddlList.add(makeUniqIndexAsPK);
		return ddlList;
	}
	private List<String> getTestUnitExceptionTableDDL(String tableName){
		
		String createTable = "CREATE TABLE "+ tableName +" ("
				+ " TEST_UNIT_UID VARCHAR2(32) NOT NULL,"
				+ " SYS_ID VARCHAR2(16) NOT NULL,"
				+ " EXCEPTION_QN VARCHAR2(1000) NOT NULL,"
				+ " CATCH_YN VARCHAR2(1) NOT NULL,"
				+ " EXCEPTION_MSG VARCHAR2(4000),"
				+ " OBJECT_DATA BLOB,"
				+ " BASE_DATE VARCHAR2(8) NOT NULL,"
				+ " REG_DTTM VARCHAR2(23) NOT NULL "
				+ ")";
		String createUniqIndex = "CREATE UNIQUE INDEX PK_" + tableName
				+ " ON "+ tableName +" ("
				+ " TEST_UNIT_UID ASC"
				+ " )";
		String makeUniqIndexAsPK = "ALTER TABLE " + tableName
				+ " ADD"
				+ " CONSTRAINT PK_" + tableName
				+ " PRIMARY KEY ("
				+ " TEST_UNIT_UID"
				+ " )";
				
		List<String> ddlList = new ArrayList<String>();
		ddlList.add(createTable);
		ddlList.add(createUniqIndex);
		ddlList.add(makeUniqIndexAsPK);
		return ddlList;
	}
}
