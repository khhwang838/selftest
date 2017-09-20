/* 테스트 유닛 */
CREATE TABLE BXT_TEST_UNIT_01 (
	TEST_UNIT_UID VARCHAR2(32) NOT NULL, /* 테스트 유닛 UID */
	CALLER_TEST_UNIT_UID VARCHAR2(32) NOT NULL, /* 호출자 테스트 유닛 UID */
	TEST_UNIT_NM VARCHAR2(1000), /* 테스트 유닛 명 */
	ROOT_TEST_UNIT_UID VARCHAR2(32) NOT NULL, /* 루트테스트유닛UID */
	RESULT_CD VARCHAR2(1) NOT NULL, /* 결과 코드 */
	OBJECT_HASH_ID VARCHAR2(128), /* 오브젝트 해쉬ID */
	OBJECT_RCD_TRG_YN VARCHAR2(1), /* 오브젝트레코딩대상여부 */
	EXCEPTION_TEST_UNIT_UID VARCHAR2(32), /* 익셉션 테스트 유닛 UID */
	SYS_ID VARCHAR2(16) NOT NULL, /* 시스템 ID */
	CLASS_ID VARCHAR2(64) NOT NULL, /* 클래스ID */
	METHOD_ID VARCHAR2(32) NOT NULL, /* 메소드ID */
	METHOD_VER_HASH_ID VARCHAR2(128) NOT NULL, /* 메소드 버전 해쉬ID */
	CALLER_CLASS_ID VARCHAR2(64), /* 호출자 클래스ID */
	CALLER_METHOD_ID VARCHAR2(32), /* 호출자 메소드ID */
	CALLER_METHOD_VER_HASH_ID VARCHAR2(128), /* 호출자 메소드 버전 해쉬ID */
	METHOD_CALL_CNT NUMBER(8), /* 메소드 호출 건수 */
	CST_01_FIELD_VAL VARCHAR2(50), /* 커스텀 01 필드 값 */
	CST_02_FIELD_VAL VARCHAR2(50), /* 커스텀 02 필드 값 */
	CST_03_FIELD_VAL VARCHAR2(50), /* 커스텀 03 필드 값 */
	CST_04_FIELD_VAL VARCHAR2(50), /* 커스텀 04 필드 값 */
	BASE_DATE VARCHAR2(8) NOT NULL, /* 기준일자 */
	BEGIN_DTTM VARCHAR2(23), /* 시작 일시 */
	END_DTTM VARCHAR2(23), /* 종료 일시 */
	ELAPSED_SEC NUMBER(8), /* 경과시간 초 */
	NANO_TIME NUMBER(19), /* 나노타임 */
	STATS_PROC_YN VARCHAR2(1) NOT NULL, /* 통계처리여부 */
	AGENT_ID VARCHAR2(32), /* AGENT ID */
	PROC_ID VARCHAR2(16), /* 프로세스ID */
	THREAD_NM VARCHAR2(1000), /* 쓰레드 명 */
	AGENT_CD VARCHAR2(1), /* AGENT 코드 */
	NRM_PROC_CNT NUMBER(8), /* 정상처리건수 */
	ERR_PROC_CNT NUMBER(8), /* 오류처리건수 */
	RECURS_PROC_CNT NUMBER(8) /* 재귀처리건수 */
);

COMMENT ON TABLE BXT_TEST_UNIT_01 IS '테스트 유닛';
COMMENT ON COLUMN BXT_TEST_UNIT_01.TEST_UNIT_UID IS '테스트 유닛 UID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CALLER_TEST_UNIT_UID IS '호출자 테스트 유닛 UID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.TEST_UNIT_NM IS '테스트 유닛 명';
COMMENT ON COLUMN BXT_TEST_UNIT_01.ROOT_TEST_UNIT_UID IS '루트테스트유닛UID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.RESULT_CD IS '결과 코드';
COMMENT ON COLUMN BXT_TEST_UNIT_01.OBJECT_HASH_ID IS '오브젝트 해쉬ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.OBJECT_RCD_TRG_YN IS '오브젝트레코딩대상여부';
COMMENT ON COLUMN BXT_TEST_UNIT_01.EXCEPTION_TEST_UNIT_UID IS '익셉션 테스트 유닛 UID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.SYS_ID IS '시스템 ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CLASS_ID IS '클래스ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.METHOD_ID IS '메소드ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.METHOD_VER_HASH_ID IS '메소드 버전 해쉬ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CALLER_CLASS_ID IS '호출자 클래스ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CALLER_METHOD_ID IS '호출자 메소드ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CALLER_METHOD_VER_HASH_ID IS '호출자 메소드 버전 해쉬ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.METHOD_CALL_CNT IS '메소드 호출 건수';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CST_01_FIELD_VAL IS '커스텀 01 필드 값';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CST_02_FIELD_VAL IS '커스텀 02 필드 값';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CST_03_FIELD_VAL IS '커스텀 03 필드 값';
COMMENT ON COLUMN BXT_TEST_UNIT_01.CST_04_FIELD_VAL IS '커스텀 04 필드 값';
COMMENT ON COLUMN BXT_TEST_UNIT_01.BASE_DATE IS '기준일자';
COMMENT ON COLUMN BXT_TEST_UNIT_01.BEGIN_DTTM IS '시작 일시';
COMMENT ON COLUMN BXT_TEST_UNIT_01.END_DTTM IS '종료 일시';
COMMENT ON COLUMN BXT_TEST_UNIT_01.ELAPSED_SEC IS '경과시간 초';
COMMENT ON COLUMN BXT_TEST_UNIT_01.NANO_TIME IS '나노타임';
COMMENT ON COLUMN BXT_TEST_UNIT_01.STATS_PROC_YN IS '통계처리여부';
COMMENT ON COLUMN BXT_TEST_UNIT_01.AGENT_ID IS 'AGENT ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.PROC_ID IS '프로세스ID';
COMMENT ON COLUMN BXT_TEST_UNIT_01.THREAD_NM IS '쓰레드 명';
COMMENT ON COLUMN BXT_TEST_UNIT_01.AGENT_CD IS 'AGENT 코드';
COMMENT ON COLUMN BXT_TEST_UNIT_01.NRM_PROC_CNT IS '정상처리건수';
COMMENT ON COLUMN BXT_TEST_UNIT_01.ERR_PROC_CNT IS '오류처리건수';
COMMENT ON COLUMN BXT_TEST_UNIT_01.RECURS_PROC_CNT IS '재귀처리건수';

CREATE UNIQUE INDEX PK_BXT_TEST_UNIT_01
	ON BXT_TEST_UNIT_01 (
		TEST_UNIT_UID ASC
	);

CREATE INDEX IX_BXT_TEST_UNIT_01_01
	ON BXT_TEST_UNIT_01 (
		BEGIN_DTTM ASC,
		RESULT_CD ASC,
		CLASS_ID ASC
	);

CREATE INDEX IX_BXT_TEST_UNIT_01_02
	ON BXT_TEST_UNIT_01 (
		ROOT_TEST_UNIT_UID ASC,
		CALLER_TEST_UNIT_UID ASC
	);

CREATE INDEX IX_BXT_TEST_UNIT_01_03
	ON BXT_TEST_UNIT_01 (
		BASE_DATE ASC,
		STATS_PROC_YN ASC,
		BEGIN_DTTM ASC
	);

ALTER TABLE BXT_TEST_UNIT_01
	ADD
		CONSTRAINT PK_BXT_TEST_UNIT_01
		PRIMARY KEY (
			TEST_UNIT_UID
		);
