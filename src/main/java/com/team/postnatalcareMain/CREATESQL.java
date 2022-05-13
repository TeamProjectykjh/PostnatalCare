package com.team.postnatalcareMain;

//테이블 명이 USER예약어 생성불가 pos_user이런식으로 변경해야함
//테이블의 칼럼명 user_id 이런식은 좋지 못하고 헷갈려서 user_id -> id로 변경 전체 테이블 다 적용요망

//아래 주석처리 되어있는 값(//) 다 긁어서 ctrl / 두개 같이 누르면 전체 주석 제거

//CREATE TABLE POS_USER 
//(
//  NUM NUMBER(15, 0) NOT NULL 
//, ID VARCHAR2(30 BYTE) NOT NULL 
//, PASSWORD VARCHAR2(30 BYTE) NOT NULL 
//, STATE NUMBER(2, 0) 
//, JOB VARCHAR2(20 BYTE) 
//, NAME VARCHAR2(20 BYTE) 
//, AGE VARCHAR2(20 BYTE) 
//, PHONE NUMBER(20, 0) 
//, GENDER VARCHAR2(10 BYTE) 
//, ADDRESS VARCHAR2(100 BYTE) 
//, CONSTRAINT POS_USER_PK PRIMARY KEY 
//  (
//    NUM 
//  )
//  USING INDEX 
//  (
//      CREATE UNIQUE INDEX POS_USER_PK ON POS_USER (NUM ASC) 
//      LOGGING 
//      TABLESPACE SYSTEM 
//      PCTFREE 10 
//      INITRANS 2 
//      STORAGE 
//      ( 
//        INITIAL 65536 
//        NEXT 1048576 
//        MINEXTENTS 1 
//        MAXEXTENTS UNLIMITED 
//        FREELISTS 1 
//        FREELIST GROUPS 1 
//        BUFFER_POOL DEFAULT 
//      ) 
//      NOPARALLEL 
//  )
//  ENABLE 
//) 
//LOGGING 
//TABLESPACE SYSTEM 
//PCTFREE 10 
//PCTUSED 40 
//INITRANS 1 
//STORAGE 
//( 
//  INITIAL 65536 
//  NEXT 1048576 
//  MINEXTENTS 1 
//  MAXEXTENTS UNLIMITED 
//  FREELISTS 1 
//  FREELIST GROUPS 1 
//  BUFFER_POOL DEFAULT 
//) 
//NOPARALLEL;





//유저 PK(num)자동 생성을 위한 시퀀스 생성
//유저 1~999
//산모 1000~1999
//의사 2000~2999
//산후 3000~3999
//이런식으로 서로 겹칠일이 없게 시퀀스를 생성해야 한다 추후 시퀀스 생성 시 여기에 업데이트 바람.
//CREATE SEQUENCE POS_USER_SEQ INCREMENT BY 1 MAXVALUE 999 MINVALUE 1 NOCACHE;


//CREATE SEQUENCE POS_SANHU_SEQ INCREMENT BY 1 MAXVALUE 3999 MINVALUE 3000 NOCACHE;


