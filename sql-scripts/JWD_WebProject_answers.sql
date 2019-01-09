CREATE TABLE JWD_WebProject.answers
(
    id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(30) DEFAULT '' NOT NULL,
    isRight tinyint(1) DEFAULT '0' NOT NULL,
    questions_id int(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, questions_id),
    CONSTRAINT fk_answers_questions1 FOREIGN KEY (questions_id) REFERENCES JWD_WebProject.questions (id)
);
CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.answers (id);
CREATE INDEX fk_answers_questions1_idx ON JWD_WebProject.answers (questions_id);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (1, 'Java is platform', 1, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (2, 'Java is coffee', 0, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (3, 'Java Vehicle Master', 0, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (4, 'Java Virtual Machine', 1, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (5, 'AAAA', 1, 3);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (6, 'BBBB', 0, 3);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (7, 'Java Enterprise Edition', 1, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (8, 'Java Est. Est. ', 0, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (9, 'Java class', 1, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (10, 'Java method', 0, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (11, 'AAAA', 0, 4);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (12, 'BBBB', 1, 4);