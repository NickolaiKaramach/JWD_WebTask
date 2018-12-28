CREATE TABLE JWD_WebProject.tests_has_questions
(
    tests_id int(11) NOT NULL,
    questions_id int(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (tests_id, questions_id),
    CONSTRAINT fk_tests_has_questions_tests1 FOREIGN KEY (tests_id) REFERENCES JWD_WebProject.tests (id),
    CONSTRAINT fk_tests_has_questions_questions1 FOREIGN KEY (questions_id) REFERENCES JWD_WebProject.questions (id)
);
CREATE INDEX fk_tests_has_questions_tests1_idx ON JWD_WebProject.tests_has_questions (tests_id);
CREATE INDEX fk_tests_has_questions_questions1_idx ON JWD_WebProject.tests_has_questions (questions_id);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (1, 1);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (1, 2);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (2, 3);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (2, 4);