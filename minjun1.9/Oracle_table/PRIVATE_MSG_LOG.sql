drop table PRIVATE_MSG_LOG;

commit



CREATE TABLE TOMATO.PRIVATE_MSG_LOG
(
  CHATMSG  VARCHAR2(1000 BYTE),
  ROOMNUM  NUMBER,
  DAYS     VARCHAR2(40 BYTE),
  HOURS    VARCHAR2(40 BYTE)
)
TABLESPACE ts_TOMATO
PCTUSED    0
PCTFREE    10
INITRANS   1
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
LOGGING 
NOCOMPRESS 
NOCACHE
NOPARALLEL
MONITORING;


ALTER TABLE TOMATO.PRIVATE_MSG_LOG ADD (
  FOREIGN KEY (ROOMNUM) 
  REFERENCES TOMATO.PRIVATE_ROOM (ROOMNUM)
  ENABLE VALIDATE);