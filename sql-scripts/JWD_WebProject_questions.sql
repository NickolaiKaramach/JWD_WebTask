CREATE TABLE JWD_WebProject.questions
(
    id          int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description varchar(30) DEFAULT '' NOT NULL,
    onwer_id    int(11) NOT NULL
);
CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.questions (id);
INSERT INTO JWD_WebProject.questions (id, description, onwer_id)
VALUES (1, 'What is Java?', 1);
INSERT INTO JWD_WebProject.questions (id, description, onwer_id)
VALUES (2, 'What is JVM?', 1);
INSERT INTO JWD_WebProject.questions (id, description, onwer_id)
VALUES (3, 'What is AAAA?', 2);
INSERT INTO JWD_WebProject.questions (id, description, onwer_id)
VALUES (4, 'What is BBBB?', 2);
INSERT INTO JWD_WebProject.questions (id, description, onwer_id)
VALUES (5, 'What is JavaEE?', 1);
INSERT INTO JWD_WebProject.questions (id, description, onwer_id)
VALUES (6, 'What is JavaServlet?', 1);