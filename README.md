# PostnatalCare

상세 내용 컨트롤러,SQL.XML에 주석확인
톰캣연동 후 실행 첫 페이지  localhost:본인포트/company/login

DB생성 참고
PostnatalCare\src\main\java\com\team\postnatalcare\CREATESQL

# 관리자 생성 SQL 
insert into pos_user (num,id,password,state,job,name,age,phone,gender,address) values(pos_user_seq.nextval,'admin','admin',1,'관리자','admin','day',0,'남자','address');

# 유저 테이블명 POS_USER

CREATE TABLE POS_USER 
(
  NUM NUMBER(15, 0) NOT NULL 
, ID VARCHAR2(30 BYTE) NOT NULL 
, PASSWORD VARCHAR2(30 BYTE) NOT NULL 
, STATE NUMBER(2, 0) 
, JOB VARCHAR2(20 BYTE) 
, NAME VARCHAR2(20 BYTE) 
, AGE VARCHAR2(20 BYTE) 
, PHONE NUMBER(20, 0) 
, GENDER VARCHAR2(10 BYTE) 
, ADDRESS VARCHAR2(100 BYTE) 
, CONSTRAINT POS_USER_PK PRIMARY KEY 
  (
    NUM 
  )
  USING INDEX 
  (
      CREATE UNIQUE INDEX POS_USER_PK ON POS_USER (NUM ASC) 
      LOGGING 
      TABLESPACE SYSTEM 
      PCTFREE 10 
      INITRANS 2 
      STORAGE 
      ( 
        INITIAL 65536 
        NEXT 1048576 
        MINEXTENTS 1 
        MAXEXTENTS UNLIMITED 
        FREELISTS 1 
        FREELIST GROUPS 1 
        BUFFER_POOL DEFAULT 
      ) 
      NOPARALLEL 
  )
  ENABLE 
) 
LOGGING 
TABLESPACE SYSTEM 
PCTFREE 10 
PCTUSED 40 
INITRANS 1 
STORAGE 
( 
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1 
  MAXEXTENTS UNLIMITED 
  FREELISTS 1 
  FREELIST GROUPS 1 
  BUFFER_POOL DEFAULT 
) 
NOPARALLEL;

# 유저 PK시퀀스 POS_USER_SEQ
CREATE SEQUENCE POS_USER_SEQ INCREMENT BY 1 MAXVALUE 999 MINVALUE 1 NOCACHE;


