select *
from employee;

create table message
(
    seq     number,
    name    varchar(30),
    message varchar(400)
);
drop table message;
select *
from message;
CREATE SEQUENCE message_seq
    START WITH 1
    INCREMENT BY 1 nomaxvalue
  NOCACHE;