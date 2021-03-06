CREATE TABLE TOMATO.MEMBER
(
  ID       VARCHAR2(50 BYTE)                    NOT NULL,
  PW       VARCHAR2(50 BYTE)                    NOT NULL,
  NAME     VARCHAR2(20 BYTE)                    NOT NULL,
  PHONE    VARCHAR2(20 BYTE),
  ADDRESS  VARCHAR2(60 BYTE)
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


CREATE UNIQUE INDEX TOMATO.MEMBER_PK ON TOMATO.MEMBER
(ID)
LOGGING
TABLESPACE ts_TOMATO
PCTFREE    10
INITRANS   2
MAXTRANS   255
STORAGE    (
            INITIAL          64K
            NEXT             1M
            MINEXTENTS       1
            MAXEXTENTS       UNLIMITED
            PCTINCREASE      0
            BUFFER_POOL      DEFAULT
           )
NOPARALLEL;


ALTER TABLE TOMATO.MEMBER ADD (
  CONSTRAINT MEMBER_PK
  PRIMARY KEY
  (ID)
  USING INDEX TOMATO.MEMBER_PK
  ENABLE VALIDATE);
