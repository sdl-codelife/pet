# pet
做给医院给用户用的

宠物医院管理系统

CREATE TABLE t_user(
userid INT auto_increment NOT NULL,
usertype VARCHAR(10) NOT NULL,
username VARCHAR(10) NOT NULL,
userpassword VARCHAR(64) NOT NULL,
PRIMARY KEY(userid)
)


create table t_userinfo(
infoid int auto_increment NOT NULL,
usersex VARCHAR(2),
usertel VARCHAR(13),
userqq VARCHAR(13),
usernote VARCHAR(64),
userid int NOT NULL,,
PRIMARY KEY(infoid),
FOREIGN KEY(userid) REFERENCES t_user(userid) ON DELETE CASCADE ON UPDATE CASCADE
)

Create table t_pet(
petid INT auto_increment NOT NULL,
petname varchar(10) not null,
petbreed varchar(10),
petsex varchar(2),
petage varchar(2),
petweight varchar(10),
userid int NOT NULL,
PRIMARY KEY(petid),
FOREIGN KEY(userid) REFERENCES t_user(userid) ON DELETE CASCADE ON UPDATE CASCADE
)

CREATE TABLE t_description(
did INT auto_increment NOT NULL,
date VARCHAR(24),
petname VARCHAR(10),
description VARCHAR(256),
result VARCHAR(256),
resoved int NOT NULL default 0,
petid INT NOT NULL,
userid  INT NOT NULL,
PRIMARY KEY(did),
FOREIGN KEY(petid) REFERENCES t_pet(petid) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY(userid) REFERENCES t_user(userid) ON DELETE CASCADE ON UPDATE CASCADE
)