
-- for ORACLE
-- sequence
CREATE SEQUENCE HIBERNATE_SEQUENCE MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 10000;

-- table
CREATE TABLE SMS_MESSAGE
(
	SMS_ID NUMBER,
	SMS_CONTENT NVARCHAR2(1000)
);

ALTER TABLE SMS_MESSAGE ADD CONSTRAINT PK_SMS_MESSAGE_ID PRIMARY KEY (SMS_ID);

CREATE TABLE SMS_MESSAGE_HISTORY
(
	SMS_ID NUMBER,
	SMS_CONTENT NVARCHAR2(1000)
);

ALTER TABLE SMS_MESSAGE_HISTORY ADD CONSTRAINT PK_SMS_MESSAGE_HIS_ID PRIMARY KEY (SMS_ID);

