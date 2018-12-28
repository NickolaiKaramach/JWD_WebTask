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