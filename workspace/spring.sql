select * from employee;

create table message(
    seq number,
    name varchar(30),
    message varchar(400)
);
drop table members;
select * from message;
CREATE SEQUENCE members_seq
  START WITH 1
  INCREMENT BY 1 
  nomaxvalue  
  NOCACHE;
create table members(
    seq number,
    id varchar(20),
    pw varchar(70),
    name varchar(20),
    tel varchar(20)
);
select id from members where id='aaa' and pw='aaa';