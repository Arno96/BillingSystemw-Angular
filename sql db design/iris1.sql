select * from emp
drop table emp;

create table emp(id number,name varchar2(15),mobile varchar2(15),address varchar2(15));

insert into emp values(1,'Prameet','9748300000','Noida');

commit


select * from developer

select * from project

select * from developerrole

select * from projectconfig
select * from devallocation
select * from devattendance

delete from devattendance
delete from devallocation
delete from projectconfig where configid=63;
commit
rollback
desc devallocation
