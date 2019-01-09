CREATE TABLE JWD_WebProject.users
(
  id           int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  email        varchar(30) DEFAULT '' NOT NULL,
  password     varchar(30) DEFAULT '' NOT NULL,
  access_level int(11) NOT NULL
);
CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.users (id);
CREATE UNIQUE INDEX email_UNIQUE ON JWD_WebProject.users (email);
INSERT INTO JWD_WebProject.users (id, email, password, access_level)
VALUES (1, 'nkaramach@gmail.com', '4776', 1);
INSERT INTO JWD_WebProject.users (id, email, password, access_level)
VALUES (2, 'bat@man.com', '4776', 1);