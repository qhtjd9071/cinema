
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
DROP TABLE integration CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE book
(
	bookNum number NOT NULL,
	showNum number NOT NULL,
	bookDate date NOT NULL,
	price number NOT NULL,
	userNum number NOT NULL,
	cancel varchar2(50),
	seatNum varchar2(50) NOT NULL,
	PRIMARY KEY (bookNum)
);


CREATE TABLE comments
(
	commentNum number NOT NULL,
	content varchar2(300) NOT NULL,
	writedate date NOT NULL,
	noticeNum number NOT NULL,
	writer number NOT NULL,
	PRIMARY KEY (commentNum)
);


CREATE TABLE customer
(
	customerNum number NOT NULL,
	title varchar2(100) NOT NULL,
	content varchar2(2000) NOT NULL,
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
	title varchar2(100) NOT NULL,
	content varchar2(2000) NOT NULL,
	writedate date NOT NULL,
	hit number NOT NULL,
    mainImage varchar2(1000) NOT NULL,
    detailImage varchar2(1000) NOT NULL,
	PRIMARY KEY (eventNum)
);


CREATE TABLE movie
(
	movieNum number NOT NULL,
	movieTitle varchar2(100) NOT NULL,
	movieContent varchar2(2000) NOT NULL,
	director varchar2(100) NOT NULL,
	genre varchar2(100) NOT NULL,
	rating varchar2(100) NOT NULL,
	image varchar2(1000) NOT NULL,
	PRIMARY KEY (movieNum)
);


CREATE TABLE movieComments
(
	movieCommentsNum number NOT NULL,
	id varchar2(100) NOT NULL,
	content varchar2(2000) NOT NULL,
	star number NOT NULL,
	writedate date NOT NULL,
	UserNum number NOT NULL,
    movieNum number NOT NULL,
	PRIMARY KEY (movieCommentsNum)
);


CREATE TABLE notice
(
	noticeNum number NOT NULL,
	title varchar2(100) NOT NULL,
	content varchar2(2000) NOT NULL,
	writedate date NOT NULL,
	hit number  NOT NULL,
	PRIMARY KEY (noticeNum)
);


CREATE TABLE pay
(
	payNum varchar2(1000) NOT NULL,
	intNum number NOT NULL,
	method varchar2(100),
	tot number,
	payDate date NOT NULL,
	PRIMARY KEY (payNum)
);


CREATE TABLE room
(
	roomserialNum number NOT NULL,
	theaterName varchar2(100) NOT NULL,
	sitCount number NOT NULL,
	location varchar2(100) NOT NULL,
	roomNum number,
	PRIMARY KEY (roomserialNum)
);


CREATE TABLE show
(
	showNum number NOT NULL,
	movieNum number NOT NULL,
	beginTime date NOT NULL,
	endTime date NOT NULL,
	roomserialNum number NOT NULL,
    price number NOT NULL,
	PRIMARY KEY (showNum)
);


CREATE TABLE users
(
	userNum number NOT NULL,
	id varchar2(100) NOT NULL,
	pwd varchar2(100) NOT NULL,
	name varchar2(100) NOT NULL,
	email varchar2(100) NOT NULL,
    year varchar2(100) NOT NULL,
	phone varchar2(100) NOT NULL,
	delUser varchar2(100),
	PRIMARY KEY (userNum)
);

CREATE TABLE integration
(
    intNum number NOT NULL,
    bookNumArray varchar2(100) NOT NULL,
    PRIMARY KEY (intNum)
);

ALTER TABLE pay
	ADD FOREIGN KEY (intNum)
	REFERENCES integration (intNum)
;


ALTER TABLE movieComments
	ADD FOREIGN KEY (movieNum)
	REFERENCES movie (movieNum)
;


ALTER TABLE show
	ADD FOREIGN KEY (movieNum)
	REFERENCES movie (movieNum)
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
	ADD FOREIGN KEY (userNum)
	REFERENCES users (userNum)
;


ALTER TABLE comments
	ADD FOREIGN KEY (writer)
	REFERENCES users (userNum)
;


ALTER TABLE customer
	ADD FOREIGN KEY (writer)
	REFERENCES users (userNum)
;


ALTER TABLE movieComments
	ADD FOREIGN KEY (userNum)
	REFERENCES users (userNum)
;

commit;