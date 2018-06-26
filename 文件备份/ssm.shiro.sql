create database test;
use test;
insert into user(username,userpwd) value('zhangsan','123456');
insert into user(username,userpwd) value('lisi','123123');
insert into user(username,userpwd) value('wangwu','456465');
insert into city_pm(city_name,city_pm) value('广州',254);
insert into city_pm(city_name,city_pm) value('深圳',152);
insert into city_pm(city_name,city_pm) value('珠海',232);
create table user(
	userid int primary key auto_increment,
    username varchar(20) not null,
    userpwd varchar(200) not null
);
select * from user;
select * from user_roles;
-- 角色表
create table user_roles(
	rolesid int primary key auto_increment,
    userid int not null,
    rolesname varchar(20) not null
);
alter table user_roles 
	add constraint FK_USER_ROLES_USERID foreign key(userid) references user(userid);

insert into user_roles(userid,rolesname) values(4,'admin');
insert into user_roles(userid,rolesname) values(5,'user');
