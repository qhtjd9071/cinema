DROP TABLE AUTHORITIES;
DROP TABLE CUSTOMERS;
DROP TABLE EVENTS;
DROP TABLE COMMENTS;
DROP TABLE NOTICES;
DROP TABLE PAYS;
DROP TABLE BOOKS;
DROP TABLE SHOWS;
DROP TABLE USERS;
DROP TABLE MOVIES;
DROP TABLE ROOMS;

CREATE TABLE USERS(
    ID VARCHAR2(100) NOT NULL,
    PWD VARCHAR2(100) NOT NULL,
    NAME VARCHAR2(50) NOT NULL,
    EMAIL VARCHAR2(300) NOT NULL,
    BIRTH VARCHAR2(100) NOT NULL,
    PHONE VARCHAR2(100) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE AUTHORITIES (
    ID VARCHAR2(100) NOT NULL,
    ENABLED NUMBER NOT NULL,
    AUTHORITY VARCHAR2(100) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (ID) REFERENCES USERS (ID)
);

CREATE TABLE CUSTOMERS(
    ID NUMBER NOT NULL,
    TITLE VARCHAR2(300) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    REF NUMBER NOT NULL,
    LEV NUMBER NOT NULL,
    STEP NUMBER NOT NULL,
    CREATEDATE DATE NOT NULL,
    USERID VARCHAR2(100) NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (USERID) REFERENCES USERS (ID)
);

CREATE TABLE EVENTS (
    ID NUMBER NOT NULL,
    TITLE VARCHAR2(300) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    CREATEDATE DATE NOT NULL,
    MAINIMAGE VARCHAR2(2000) NOT NULL,
    DETAILIMAGE VARCHAR2(2000) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE MOVIES(
    ID NUMBER NOT NULL,
    TITLE VARCHAR2(300) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    DIRECTOR VARCHAR2(100) NOT NULL,
    GENRE VARCHAR2(100) NOT NULL,
    RATING VARCHAR2(50) NOT NULL,
    IMAGE VARCHAR2(2000) NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE COMMENTS(
    ID NUMBER NOT NULL,
    CONTENT VARCHAR2(2000) NOT NULL,
    STAR NUMBER NOT NULL,
    CREATEDATE DATE NOT NULL,
    USERID VARCHAR2(100) NOT NULL,
    MOVIEID NUMBER NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (USERID) REFERENCES USERS (ID),
    FOREIGN KEY (MOVIEID) REFERENCES MOVIES (ID)
);

CREATE TABLE NOTICES(
    ID NUMBER NOT NULL,
    TITLE VARCHAR2(300) NOT NULL,
    CONTENT VARCHAR2(4000) NOT NULL,
    CREATEDATE DATE NOT NULL,
    HIT NUMBER NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE ROOMS(
    ID NUMBER NOT NULL,
    THEATERNAME VARCHAR2(300) NOT NULL,
    SEATCOUNT NUMBER NOT NULL,
    LOCATION VARCHAR2(100) NOT NULL,
    ROOMNUM NUMBER NOT NULL,
    PRIMARY KEY (ID)
);

CREATE TABLE SHOWS(
    ID NUMBER NOT NULL,
    MOVIEID NUMBER NOT NULL,
    BEGINTIME DATE NOT NULL,
    ENDTIME DATE NOT NULL,
    ROOMID NUMBER NOT NULL,
    PRICE NUMBER NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (MOVIEID) REFERENCES MOVIES(ID),
    FOREIGN KEY (ROOMID) REFERENCES ROOMS(ID)
);

CREATE TABLE BOOKS(
    ID NUMBER NOT NULL,
    CREATEDATE DATE NOT NULL,
    PRICE NUMBER NOT NULL,
    SEATNUM VARCHAR2(1000) NOT NULL,
    SHOWID NUMBER NOT NULL,
    USERID VARCHAR2(100) NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY (SHOWID) REFERENCES SHOWS (ID),
    FOREIGN KEY (USERID) REFERENCES USERS (ID)
);


CREATE TABLE PAYS(
    ID VARCHAR2(1000) NOT NULL,
    BOOKID NUMBER NOT NULL,
    METHOD VARCHAR2(100),
    TOTAL NUMBER,
    CREATEDATE DATE NOT NULL,
    PRIMARY KEY (ID),
    FOREIGN KEY (BOOKID) REFERENCES BOOKS (ID)
);

DROP SEQUENCE BOOKS_SEQ;
CREATE SEQUENCE BOOKS_SEQ;
DROP SEQUENCE COMMENTS_SEQ;
CREATE SEQUENCE COMMENTS_SEQ;
DROP SEQUENCE CUSTOMERS_SEQ;
CREATE SEQUENCE CUSTOMERS_SEQ;
DROP SEQUENCE EVENTS_SEQ;
CREATE SEQUENCE EVENTS_SEQ;
DROP SEQUENCE MOVIES_SEQ;
CREATE SEQUENCE MOVIES_SEQ;
DROP SEQUENCE NOTICES_SEQ;
CREATE SEQUENCE NOTICES_SEQ;
DROP SEQUENCE ROOMS_SEQ;
CREATE SEQUENCE ROOMS_SEQ;
DROP SEQUENCE SHOWS_SEQ;
CREATE SEQUENCE SHOWS_SEQ;

CREATE OR REPLACE TRIGGER JOIN_TRIGGER
AFTER
INSERT ON USERS
FOR EACH ROW
BEGIN
    INSERT INTO AUTHORITIES VALUES(:NEW.ID,1,'ROLE_USER');
END;

INSERT INTO USERS VALUES('admin','$2a$10$MXZiX6ycHruj47Wvp1Aer.eUuZCHyEc4eB31a.BzVKDtc7tzHZWGC','관리자','admin@email','12345678','01011112222');

UPDATE AUTHORITIES SET AUTHORITY='ROLE_ADMIN' WHERE ID='admin';

COMMIT;