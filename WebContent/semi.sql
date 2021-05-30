
/* Drop Tables */

DROP TABLE pay CASCADE CONSTRAINTS;
DROP TABLE book CASCADE CONSTRAINTS;
DROP TABLE comments CASCADE CONSTRAINTS;
DROP TABLE customer CASCADE CONSTRAINTS;
DROP TABLE event CASCADE CONSTRAINTS;
DROP TABLE movieComments CASCADE CONSTRAINTS;
DROP TABLE show CASCADE CONSTRAINTS;
DROP TABLE movie CASCADE CONSTRAINTS;
DROP TABLE notice CASCADE CONSTRAINTS;
DROP TABLE room CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE book
(
	bookNum number NOT NULL,
	booker varchar2(10) NOT NULL,
	showNum number NOT NULL,
	bookDate date NOT NULL,
	price number NOT NULL,
	UserNum number NOT NULL,
	cancel varchar2(20) NOT NULL,
	seatNum number NOT NULL,
	seatArray varchar2(5) NOT NULL,
	PRIMARY KEY (bookNum)
);


CREATE TABLE comments
(
	commentNum number NOT NULL,
	content varchar2(200) NOT NULL,
	writedate date NOT NULL,
	noticeNum number NOT NULL,
	writer number NOT NULL,
	PRIMARY KEY (commentNum)
);


CREATE TABLE customer
(
	-- 
	-- 
	customerNum number NOT NULL,
	title varchar2(20) NOT NULL,
	content varchar2(1000) NOT NULL,
	ref number NOT NULL,
	lev number NOT NULL,
	step number NOT NULL,
	writedate date NOT NULL,
	writer number NOT NULL,
	PRIMARY KEY (customerNum)
);


CREATE TABLE event
(
	eventNum number NOT NULL,
	title varchar2(20) NOT NULL,
	content varchar2(1000) NOT NULL,
	writedate date NOT NULL,
	hit number NOT NULL,
	PRIMARY KEY (eventNum)
);


CREATE TABLE movie
(
	-- 
	-- 
	showNum number NOT NULL,
	movieTitle varchar2(50) NOT NULL,
	movieContent varchar2(1000) NOT NULL,
	director varchar2(10) NOT NULL,
	genre varchar2(20) NOT NULL,
	rating varchar2(20) NOT NULL,
	image varchar2(100) NOT NULL,
	PRIMARY KEY (showNum)
);


CREATE TABLE movieComments
(
	-- 
	-- 
	movieCommentsNum number NOT NULL,
	id varchar2(20) NOT NULL,
	content varchar2(200) NOT NULL,
	star number NOT NULL,
	writedate date NOT NULL,
	-- 
	-- 
	showNum number NOT NULL,
	UserNum number NOT NULL,
	PRIMARY KEY (movieCommentsNum)
);


CREATE TABLE notice
(
	noticeNum number NOT NULL,
	title varchar2(20) NOT NULL,
	content varchar2(1000) NOT NULL,
	writedate date NOT NULL,
	hit number,
	PRIMARY KEY (noticeNum)
);


CREATE TABLE pay
(
	payNum number NOT NULL,
	userNum number NOT NULL,
	bookNum number NOT NULL,
	method varchar2(20) NOT NULL,
	tot number NOT NULL,
	payDate date NOT NULL,
	PRIMARY KEY (payNum)
);


CREATE TABLE room
(
	roomserialNum number NOT NULL,
	theaterName varchar2(20) NOT NULL,
	sitCount number NOT NULL,
	location varchar2(20) NOT NULL,
	roomNum number,
	PRIMARY KEY (roomserialNum)
);


CREATE TABLE show
(
	showNum number NOT NULL,
	-- 
	-- 
	movieNum number NOT NULL,
	beginTime date NOT NULL,
	endTime date NOT NULL,
	showDate date NOT NULL,
	roomserialNum number NOT NULL,
	PRIMARY KEY (showNum)
);


CREATE TABLE users
(
	UserNum number NOT NULL,
	id varchar2(20) NOT NULL,
	pwd varchar2(20) NOT NULL,
	name varchar2(10) NOT NULL,
	email varchar2(50) NOT NULL,
	phone varchar2(20) NOT NULL,
	age number NOT NULL,
	delUser varchar2(20) NOT NULL,
	PRIMARY KEY (UserNum)
);



/* Create Foreign Keys */

ALTER TABLE pay
	ADD FOREIGN KEY (bookNum)
	REFERENCES book (bookNum)
;


ALTER TABLE movieComments
	ADD FOREIGN KEY (showNum)
	REFERENCES movie (showNum)
;


ALTER TABLE show
	ADD FOREIGN KEY (movieNum)
	REFERENCES movie (showNum)
;


ALTER TABLE comments
	ADD FOREIGN KEY (noticeNum)
	REFERENCES notice (noticeNum)
;


ALTER TABLE show
	ADD FOREIGN KEY (roomserialNum)
	REFERENCES room (roomserialNum)
;


ALTER TABLE book
	ADD FOREIGN KEY (showNum)
	REFERENCES show (showNum)
;


ALTER TABLE book
	ADD FOREIGN KEY (UserNum)
	REFERENCES users (UserNum)
;


ALTER TABLE comments
	ADD FOREIGN KEY (writer)
	REFERENCES users (UserNum)
;


ALTER TABLE customer
	ADD FOREIGN KEY (writer)
	REFERENCES users (UserNum)
;


ALTER TABLE movieComments
	ADD FOREIGN KEY (UserNum)
	REFERENCES users (UserNum)
;

commit;




