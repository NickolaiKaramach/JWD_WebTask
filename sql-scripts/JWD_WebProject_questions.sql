CREATE TABLE JWD_WebProject.questions
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description varchar(30) DEFAULT '' NOT NULL
);
CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.questions (id);
INSERT INTO JWD_WebProject.questions (id, description) VALUES (1, 'What is Java?');
INSERT INTO JWD_WebProject.questions (id, description) VALUES (2, 'What is JVM?');
INSERT INTO JWD_WebProject.questions (id, description) VALUES (3, 'What it JavaEE?');
INSERT INTO JWD_WebProject.questions (id, description) VALUES (4, 'What is Servlet?');