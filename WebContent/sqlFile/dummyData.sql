insert into users values(1,'test','1234','testname','testemail','testphone',20, null);
insert into movie values(1,'testmovietitle','testmoviecontent','director','testgenre',5,'testimage');
insert into room values(1,'종로영화관',20,'서울',1);
insert into show values(1,1,to_date('2021-06-01 13:30:30','yyyy-mm-dd hh24:mi:ss'),to_date('2021-06-01 13:30:30','yyyy-mm-dd hh24:mi:ss'),1);

drop sequence book_seq;
create sequence book_seq;