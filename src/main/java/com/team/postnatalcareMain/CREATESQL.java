package com.team.postnatalcareMain;

//���̺� ���� USER����� �����Ұ� pos_user�̷������� �����ؾ���
//���̺��� Į���� user_id �̷����� ���� ���ϰ� �򰥷��� user_id -> id�� ���� ��ü ���̺� �� ������

//�Ʒ� �ּ�ó�� �Ǿ��ִ� ��(//) �� �ܾ ctrl / �ΰ� ���� ������ ��ü �ּ� ����

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





//���� PK(num)�ڵ� ������ ���� ������ ����
//���� 1~999
//��� 1000~1999
//�ǻ� 2000~2999
// �̷������� ���� ��ĥ���� ���� �������� �����ؾ� �Ѵ� ���� ������ ���� �� ���⿡ ������Ʈ �ٶ�.
//CREATE SEQUENCE POS_USER_SEQ INCREMENT BY 1 MAXVALUE 999 MINVALUE 1 NOCACHE;


