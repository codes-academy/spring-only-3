select *
from employee;

create table message
(
    seq     number,
    name    varchar(30),
    message varchar(400)
);
drop table pay;
select *
from members;
CREATE SEQUENCE b_seq
    START WITH 1
    INCREMENT BY 1 nomaxvalue
  NOCACHE;
create table members
(
    seq  number,
    id   varchar(20),
    pw   varchar(70),
    name varchar(20),
    tel  varchar(20)
);
select id
from members
where id = 'aaa'
  and pw = 'aaa';
select *
from pay;
select *
from seller;
create table pay
(
    seq   number primary key,
    pid   varchar(20) not null,
    pname varchar(20) not null
);
create table seller
(
    seq number primary key,
    bid varchar(20) not null,
    pid varchar(20) not null
);
alter table board add (snail varchar(100) default null);
select *
from board
order by seq desc;
select b_seq.nextval
from dual;
create table board
(
    seq       number,
    title     varchar(50),
    contents  varchar(300),
    writer    varchar(20),
    writedate date default sysdate,
    viewcount number,
    ipaddr    varchar(50),
    snail     varchar(100)
);
insert into board
values (b_seq.nextval, 'title11', 'content22', 'writer11', sysdate, '0', 'ipaddr');