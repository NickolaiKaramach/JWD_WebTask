CREATE TABLE jwd_task.users
(
    email varchar(30) DEFAULT '' NOT NULL,
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    password varchar(30) DEFAULT '' NOT NULL,
    access_level int(11) DEFAULT '0',
    name varchar(30) DEFAULT '' NOT NULL
);
CREATE UNIQUE INDEX users_login_uindex ON jwd_task.users (email);
INSERT INTO jwd_task.users (email, id, password, access_level, name) VALUES ('nkaramach@gmail.com', 5, '6774', 1, 'Nickolai');
INSERT INTO jwd_task.users (email, id, password, access_level, name) VALUES ('aliaksandra47@gmail.com', 6, '6774', 1, 'Aliaksandra');
INSERT INTO jwd_task.users (email, id, password, access_level, name) VALUES ('a@gmail.com', 7, '6774', 1, 'Alisa');