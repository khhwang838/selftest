DROP TABLE NAVER_STOCK;
-- 네이버 주식
CREATE TABLE NAVER_STOCK
(
	CODE                       VARCHAR(255) NOT NULL, -- 종목코드
	SETTLEMENT_TYPE            VARCHAR(255) NOT NULL, -- 실적타입
	SETTLEMENT_YYYYMM          VARCHAR(255) NOT NULL, -- 결산년월
	NAME                       VARCHAR(255) NULL,     -- 종목명
	SALES                      VARCHAR(255) NULL,     -- 매출액(억원)
	BUSINESS_PROFITS           VARCHAR(255) NULL,     -- 영업이익(억원)
	NET_INCOME                 VARCHAR(255) NULL,     -- 당기순이익(억원)
	BUSINESS_PROFITS_RATE      VARCHAR(255) NULL,     -- 영업이익률(%)
	NET_INCOME_RATE            VARCHAR(255) NULL,     -- 순이익률(%)
	ROE                        VARCHAR(255) NULL,     -- ROE(%)
	DEBT_RATE                  VARCHAR(255) NULL,     -- 부채비율(%)
	QUICK_RATE                 VARCHAR(255) NULL,     -- 당좌비율(%)
	RESERVE_RATE               VARCHAR(255) NULL,     -- 유보율(%)
	EPS                        VARCHAR(255) NULL,     -- EPS(원)
	BPS                        VARCHAR(255) NULL,     -- BPS(원)
	DIVIDENDS_PER_SHARE        VARCHAR(255) NULL,     -- 주당배당금(원)
	MARKET_VALUE_DIVIDEND_RATE VARCHAR(255) NULL,     -- 시가배당률(%)
	PAYOUT_RATE                VARCHAR(255) NULL      -- 배당성향(%)
);

-- 네이버 주식
COMMENT ON TABLE NAVER_STOCK IS '네이버 주식';

-- 종목코드
COMMENT ON COLUMN NAVER_STOCK.CODE IS '종목코드';

-- 실적타입
COMMENT ON COLUMN NAVER_STOCK.SETTLEMENT_TYPE IS '실적타입';

-- 결산년월
COMMENT ON COLUMN NAVER_STOCK.SETTLEMENT_YYYYMM IS '결산년월';

-- 종목명
COMMENT ON COLUMN NAVER_STOCK.NAME IS '종목명';

-- 매출액(억원)
COMMENT ON COLUMN NAVER_STOCK.SALES IS '매출액(억원)';

-- 영업이익(억원)
COMMENT ON COLUMN NAVER_STOCK.BUSINESS_PROFITS IS '영업이익(억원)';

-- 당기순이익(억원)
COMMENT ON COLUMN NAVER_STOCK.NET_INCOME IS '당기순이익(억원)';

-- 영업이익률(%)
COMMENT ON COLUMN NAVER_STOCK.BUSINESS_PROFITS_RATE IS '영업이익률(%)';

-- 순이익률(%)
COMMENT ON COLUMN NAVER_STOCK.NET_INCOME_RATE IS '순이익률(%)';

-- ROE(%)
COMMENT ON COLUMN NAVER_STOCK.ROE IS 'ROE(%)';

-- 부채비율(%)
COMMENT ON COLUMN NAVER_STOCK.DEBT_RATE IS '부채비율(%)';

-- 당좌비율(%)
COMMENT ON COLUMN NAVER_STOCK.QUICK_RATE IS '당좌비율(%)';

-- 유보율(%)
COMMENT ON COLUMN NAVER_STOCK.RESERVE_RATE IS '유보율(%)';

-- EPS(원)
COMMENT ON COLUMN NAVER_STOCK.EPS IS 'EPS(원)';

-- BPS(원)
COMMENT ON COLUMN NAVER_STOCK.BPS IS 'BPS(원)';

-- 주당배당금(원)
COMMENT ON COLUMN NAVER_STOCK.DIVIDENDS_PER_SHARE IS '주당배당금(원)';

-- 시가배당률(%)
COMMENT ON COLUMN NAVER_STOCK.MARKET_VALUE_DIVIDEND_RATE IS '시가배당률(%)';

-- 배당성향(%)
COMMENT ON COLUMN NAVER_STOCK.PAYOUT_RATE IS '배당성향(%)';

-- 네이버 주식
ALTER TABLE NAVER_STOCK
	ADD CONSTRAINT PK_NAVER_STOCK
		 -- 네이버 주식 기본키
	PRIMARY KEY (
		CODE,              -- 종목코드
		SETTLEMENT_TYPE,   -- 실적타입
		SETTLEMENT_YYYYMM  -- 결산년월
		);

-- 네이버 주식 기본키
COMMENT ON CONSTRAINT PK_NAVER_STOCK ON NAVER_STOCK IS '네이버 주식 기본키';