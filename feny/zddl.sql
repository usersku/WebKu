use master
go

--�������ݿ�
if DB_ID('jsp') is not null
drop database jsp
go
create database jsp
go
use jsp
go

--������
if OBJECT_ID('stus') is not null
drop table stus
go
create table stus
(
id int identity(1,1) not null,
name varchar(100) not null,
pwd varchar(100) not null,
age int not null,
address varchar(100) not null,
)
go
insert into stus (name,pwd,age,address)
select 'С��','123','22','�����Ƹ�'

Select*from stus
select * from stus where name=? and pwd=?