--------------------------------------------------------
--  File created - Friday-January-05-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table ATTACHMENTS
--------------------------------------------------------

  CREATE TABLE "TRMS"."ATTACHMENTS" 
   (	"ATTACHMENT_ID" NUMBER, 
	"REIMBURSEMENT_ID" NUMBER, 
	"ATTACHMENT_DESC" VARCHAR2(60 BYTE), 
	"ATTACHMENT" BLOB
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
 LOB ("ATTACHMENT") STORE AS BASICFILE (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 RETENTION 
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)) ;
--------------------------------------------------------
--  DDL for Table EMPLOYEE
--------------------------------------------------------

  CREATE TABLE "TRMS"."EMPLOYEE" 
   (	"EMPLOYEEID" NUMBER, 
	"FIRSTNAME" VARCHAR2(20 BYTE), 
	"LASTNAME" VARCHAR2(30 BYTE), 
	"EMAIL" VARCHAR2(60 BYTE), 
	"PASSWORD" VARCHAR2(32 BYTE), 
	"SUPERVISORID" NUMBER, 
	"DEPTHEADID" NUMBER, 
	"EMPLOYEETYPEID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EMPLOYEETYPE
--------------------------------------------------------

  CREATE TABLE "TRMS"."EMPLOYEETYPE" 
   (	"EMPTYPEID" NUMBER, 
	"EMPTYPE" VARCHAR2(30 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table EVENTTYPE
--------------------------------------------------------

  CREATE TABLE "TRMS"."EVENTTYPE" 
   (	"EVENTTYPEID" NUMBER, 
	"EVENTTYPE" VARCHAR2(40 BYTE), 
	"REIMBURSEPCT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table GRADINGFORMATS
--------------------------------------------------------

  CREATE TABLE "TRMS"."GRADINGFORMATS" 
   (	"FORMATID" NUMBER, 
	"FORMATDESC" VARCHAR2(20 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Table REIMBURSEMENT
--------------------------------------------------------

  CREATE TABLE "TRMS"."REIMBURSEMENT" 
   (	"REIMBURSEMENT_ID" NUMBER, 
	"EMPLOYEE_ID" NUMBER, 
	"EVENTTYPE_ID" NUMBER, 
	"DESCRIPTION" VARCHAR2(500 BYTE), 
	"LOCATION" VARCHAR2(50 BYTE), 
	"JUSTIFICATION" VARCHAR2(500 BYTE), 
	"EVENT_START_DATE" DATE, 
	"GRADE_FMT_ID" NUMBER, 
	"COST" NUMBER, 
	"AMT_REIMBURSED" NUMBER, 
	"DATE_SUBMITTED" DATE, 
	"WORK_DAYS_MISSED" NUMBER, 
	"APPROVAL_STATUS" NUMBER, 
	"ADDITIONAL_NOTES" VARCHAR2(500 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Sequence SQ_REIMB_PK
--------------------------------------------------------

   CREATE SEQUENCE  "TRMS"."SQ_REIMB_PK"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 41 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into TRMS.ATTACHMENTS
SET DEFINE OFF;
REM INSERTING into TRMS.EMPLOYEE
SET DEFINE OFF;
Insert into TRMS.EMPLOYEE (EMPLOYEEID,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,SUPERVISORID,DEPTHEADID,EMPLOYEETYPEID) values (1,'Melyssa','Mcfadden','nonummy@augue.org','1',2,3,0);
Insert into TRMS.EMPLOYEE (EMPLOYEEID,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,SUPERVISORID,DEPTHEADID,EMPLOYEETYPEID) values (2,'Callum','Thompson','et.ultrices@odioPhasellus.net','2',null,3,1);
Insert into TRMS.EMPLOYEE (EMPLOYEEID,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,SUPERVISORID,DEPTHEADID,EMPLOYEETYPEID) values (3,'Bob','Bobson','robert.bobson@robbob.com','3',null,null,2);
Insert into TRMS.EMPLOYEE (EMPLOYEEID,FIRSTNAME,LASTNAME,EMAIL,PASSWORD,SUPERVISORID,DEPTHEADID,EMPLOYEETYPEID) values (4,'Paul','Paulson','paul.sonofdad@paulpaul.com','4',null,null,3);
REM INSERTING into TRMS.EMPLOYEETYPE
SET DEFINE OFF;
Insert into TRMS.EMPLOYEETYPE (EMPTYPEID,EMPTYPE) values (0,'GRUNT');
Insert into TRMS.EMPLOYEETYPE (EMPTYPEID,EMPTYPE) values (1,'SUPERVISOR');
Insert into TRMS.EMPLOYEETYPE (EMPTYPEID,EMPTYPE) values (2,'DEPT HEAD');
Insert into TRMS.EMPLOYEETYPE (EMPTYPEID,EMPTYPE) values (3,'BENCO');
REM INSERTING into TRMS.EVENTTYPE
SET DEFINE OFF;
Insert into TRMS.EVENTTYPE (EVENTTYPEID,EVENTTYPE,REIMBURSEPCT) values (1,'UNIVERSITY COURSE',0.8);
Insert into TRMS.EVENTTYPE (EVENTTYPEID,EVENTTYPE,REIMBURSEPCT) values (2,'SEMINAR',0.6);
Insert into TRMS.EVENTTYPE (EVENTTYPEID,EVENTTYPE,REIMBURSEPCT) values (3,'CERTIFICATION PREPARATION',0.75);
Insert into TRMS.EVENTTYPE (EVENTTYPEID,EVENTTYPE,REIMBURSEPCT) values (4,'CERTIFICATION',1);
Insert into TRMS.EVENTTYPE (EVENTTYPEID,EVENTTYPE,REIMBURSEPCT) values (5,'TECHNICAL TRAINING',0.9);
Insert into TRMS.EVENTTYPE (EVENTTYPEID,EVENTTYPE,REIMBURSEPCT) values (6,'OTHER',0.3);
REM INSERTING into TRMS.GRADINGFORMATS
SET DEFINE OFF;
Insert into TRMS.GRADINGFORMATS (FORMATID,FORMATDESC) values (1,'A-F');
Insert into TRMS.GRADINGFORMATS (FORMATID,FORMATDESC) values (2,'PASS/FAIL');
Insert into TRMS.GRADINGFORMATS (FORMATID,FORMATDESC) values (3,'Presentation');
REM INSERTING into TRMS.REIMBURSEMENT
SET DEFINE OFF;
Insert into TRMS.REIMBURSEMENT (REIMBURSEMENT_ID,EMPLOYEE_ID,EVENTTYPE_ID,DESCRIPTION,LOCATION,JUSTIFICATION,EVENT_START_DATE,GRADE_FMT_ID,COST,AMT_REIMBURSED,DATE_SUBMITTED,WORK_DAYS_MISSED,APPROVAL_STATUS,ADDITIONAL_NOTES) values (21,1,3,'Stuff','1','It won''t',to_date('01-JAN-01','DD-MON-RR'),3,5433,4074.75,to_date('03-JAN-18','DD-MON-RR'),0,1,'Lets goooooooooooo');
Insert into TRMS.REIMBURSEMENT (REIMBURSEMENT_ID,EMPLOYEE_ID,EVENTTYPE_ID,DESCRIPTION,LOCATION,JUSTIFICATION,EVENT_START_DATE,GRADE_FMT_ID,COST,AMT_REIMBURSED,DATE_SUBMITTED,WORK_DAYS_MISSED,APPROVAL_STATUS,ADDITIONAL_NOTES) values (22,2,6,'Stuff','Place','The best way',to_date('31-DEC-14','DD-MON-RR'),3,100,30,to_date('05-JAN-18','DD-MON-RR'),0,-1,null);
Insert into TRMS.REIMBURSEMENT (REIMBURSEMENT_ID,EMPLOYEE_ID,EVENTTYPE_ID,DESCRIPTION,LOCATION,JUSTIFICATION,EVENT_START_DATE,GRADE_FMT_ID,COST,AMT_REIMBURSED,DATE_SUBMITTED,WORK_DAYS_MISSED,APPROVAL_STATUS,ADDITIONAL_NOTES) values (23,4,2,'gwhg4p','463974','12345341325415',to_date('12-DEC-90','DD-MON-RR'),3,3404,2042.3999999999999,to_date('05-JAN-18','DD-MON-RR'),0,3,'APPROVED!');
Insert into TRMS.REIMBURSEMENT (REIMBURSEMENT_ID,EMPLOYEE_ID,EVENTTYPE_ID,DESCRIPTION,LOCATION,JUSTIFICATION,EVENT_START_DATE,GRADE_FMT_ID,COST,AMT_REIMBURSED,DATE_SUBMITTED,WORK_DAYS_MISSED,APPROVAL_STATUS,ADDITIONAL_NOTES) values (1,1,1,'asf','tra','3fsdaf',to_date('20-DEC-20','DD-MON-RR'),1,12,9.600000000000001,to_date('30-DEC-17','DD-MON-RR'),0,0,null);
Insert into TRMS.REIMBURSEMENT (REIMBURSEMENT_ID,EMPLOYEE_ID,EVENTTYPE_ID,DESCRIPTION,LOCATION,JUSTIFICATION,EVENT_START_DATE,GRADE_FMT_ID,COST,AMT_REIMBURSED,DATE_SUBMITTED,WORK_DAYS_MISSED,APPROVAL_STATUS,ADDITIONAL_NOTES) values (2,1,1,'123','13','213',to_date('07-SEP-10','DD-MON-RR'),3,12123,9698.4,to_date('30-DEC-17','DD-MON-RR'),0,0,null);
--------------------------------------------------------
--  DDL for Index EMPTYPE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "TRMS"."EMPTYPE_PK" ON "TRMS"."EMPLOYEETYPE" ("EMPTYPEID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger TR_NEW_REIMB
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "TRMS"."TR_NEW_REIMB" 
BEFORE INSERT ON REIMBURSEMENT
FOR EACH ROW
BEGIN
    SELECT SQ_REIMB_PK.NEXTVAL
    INTO :NEW.REIMBURSEMENT_ID FROM DUAL;
END;

/
ALTER TRIGGER "TRMS"."TR_NEW_REIMB" ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLOYEETYPE
--------------------------------------------------------

  ALTER TABLE "TRMS"."EMPLOYEETYPE" ADD CONSTRAINT "EMPTYPE_PK" PRIMARY KEY ("EMPTYPEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EVENTTYPE
--------------------------------------------------------

  ALTER TABLE "TRMS"."EVENTTYPE" ADD PRIMARY KEY ("EVENTTYPEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table REIMBURSEMENT
--------------------------------------------------------

  ALTER TABLE "TRMS"."REIMBURSEMENT" ADD PRIMARY KEY ("REIMBURSEMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "TRMS"."EMPLOYEE" ADD PRIMARY KEY ("EMPLOYEEID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table ATTACHMENTS
--------------------------------------------------------

  ALTER TABLE "TRMS"."ATTACHMENTS" ADD PRIMARY KEY ("ATTACHMENT_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Constraints for Table GRADINGFORMATS
--------------------------------------------------------

  ALTER TABLE "TRMS"."GRADINGFORMATS" ADD PRIMARY KEY ("FORMATID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ATTACHMENTS
--------------------------------------------------------

  ALTER TABLE "TRMS"."ATTACHMENTS" ADD CONSTRAINT "REIMBFK" FOREIGN KEY ("REIMBURSEMENT_ID")
	  REFERENCES "TRMS"."REIMBURSEMENT" ("REIMBURSEMENT_ID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table EMPLOYEE
--------------------------------------------------------

  ALTER TABLE "TRMS"."EMPLOYEE" ADD CONSTRAINT "DEPTHEADFK" FOREIGN KEY ("DEPTHEADID")
	  REFERENCES "TRMS"."EMPLOYEE" ("EMPLOYEEID") ENABLE;
  ALTER TABLE "TRMS"."EMPLOYEE" ADD CONSTRAINT "EMPTYPEFK" FOREIGN KEY ("EMPLOYEETYPEID")
	  REFERENCES "TRMS"."EMPLOYEETYPE" ("EMPTYPEID") ENABLE;
  ALTER TABLE "TRMS"."EMPLOYEE" ADD CONSTRAINT "SUPERVISORFK" FOREIGN KEY ("SUPERVISORID")
	  REFERENCES "TRMS"."EMPLOYEE" ("EMPLOYEEID") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table REIMBURSEMENT
--------------------------------------------------------

  ALTER TABLE "TRMS"."REIMBURSEMENT" ADD CONSTRAINT "EMPIDFK" FOREIGN KEY ("EMPLOYEE_ID")
	  REFERENCES "TRMS"."EMPLOYEE" ("EMPLOYEEID") ENABLE;
  ALTER TABLE "TRMS"."REIMBURSEMENT" ADD CONSTRAINT "EVENTTYPEFK" FOREIGN KEY ("EVENTTYPE_ID")
	  REFERENCES "TRMS"."EVENTTYPE" ("EVENTTYPEID") ENABLE;
  ALTER TABLE "TRMS"."REIMBURSEMENT" ADD CONSTRAINT "GRADEFMTFK" FOREIGN KEY ("GRADE_FMT_ID")
	  REFERENCES "TRMS"."GRADINGFORMATS" ("FORMATID") ENABLE;
