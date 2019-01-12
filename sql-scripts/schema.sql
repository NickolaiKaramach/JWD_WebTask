CREATE TABLE JWD_WebProject.questions
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description varchar(30) DEFAULT '' NOT NULL,
    owner_id int(11) NOT NULL
);


CREATE TABLE JWD_WebProject.users
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    email varchar(30) DEFAULT '' NOT NULL,
    password varchar(30) DEFAULT '' NOT NULL,
    access_level int(11) NOT NULL,
    name varchar(45)
);

CREATE TABLE JWD_WebProject.tests
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30) DEFAULT '' NOT NULL,
    status varchar(30) DEFAULT '' NOT NULL,
    users_id int(11) NOT NULL
);



CREATE TABLE JWD_WebProject.answers
(
    id int(11) NOT NULL AUTO_INCREMENT,
    description varchar(30) DEFAULT '' NOT NULL,
    isRight tinyint(1) DEFAULT '0' NOT NULL,
    questions_id int(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, questions_id)
);


CREATE TABLE JWD_WebProject.grades
(
    id int(11) NOT NULL AUTO_INCREMENT,
    degree int(11) DEFAULT '0' NOT NULL,
    users_id int(11) NOT NULL,
    tests_id int(11) NOT NULL,
    finish_time datetime,
    is_finished tinyint(1) DEFAULT '0',
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, tests_id)
);

CREATE TABLE JWD_WebProject.choices
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    question_id int(11) NOT NULL,
    answer_id int(11) NOT NULL,
    grade_id int(11) NOT NULL
);


CREATE TABLE JWD_WebProject.tests_has_questions
(
    tests_id int(11) NOT NULL,
    questions_id int(11) NOT NULL
);




CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.answers (id);
CREATE INDEX fk_answers_questions1_idx ON JWD_WebProject.answers (questions_id);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (1, 'Java is platform', 1, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (2, 'Java is coffee', 0, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (3, 'Java Vehicle Master', 0, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (4, 'Java Virtual Machine', 1, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (5, 'AAAA', 1, 3);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (6, 'BBBB', 0, 3);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (7, 'Java Enterprise Edition', 1, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (8, 'Java Est. Est. ', 0, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (9, 'Java class', 1, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (10, 'Java method', 0, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (11, 'AAAA', 0, 4);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id) VALUES (12, 'BBBB', 1, 4);

CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.choices (id);
CREATE INDEX fk_choices_questions1_idx ON JWD_WebProject.choices (question_id);
CREATE INDEX fk_choices_answers1_idx ON JWD_WebProject.choices (answer_id);
CREATE INDEX fk_choices_grades1_idx ON JWD_WebProject.choices (grade_id);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id) VALUES (1, 1, 2, 1);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id) VALUES (2, 2, 4, 1);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id) VALUES (3, 1, 2, 2);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id) VALUES (4, 2, 3, 2);

CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.grades (id);
CREATE INDEX fk_grades_users1_idx ON JWD_WebProject.grades (users_id);
CREATE INDEX fk_grades_tests1_idx ON JWD_WebProject.grades (tests_id);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished) VALUES (1, 0, 1, 3, '2019-01-09 16:51:05', 0);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished) VALUES (2, 0, 1, 3, '2019-01-09 17:24:57', 0);

CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.questions (id);
INSERT INTO JWD_WebProject.questions (id, description, owner_id) VALUES (1, 'What is Java?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id) VALUES (2, 'What is JVM?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id) VALUES (3, 'What is AAAA?', 2);
INSERT INTO JWD_WebProject.questions (id, description, owner_id) VALUES (4, 'What is BBBB?', 2);
INSERT INTO JWD_WebProject.questions (id, description, owner_id) VALUES (5, 'What is JavaEE?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id) VALUES (6, 'What is JavaServlet?', 1);

CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.tests (id);
CREATE INDEX fk_tests_users_idx ON JWD_WebProject.tests (users_id);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id) VALUES (3, 'Java0', 'PUBLISHED', 1);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id) VALUES (4, 'Another Java', 'PUBLISHED', 2);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id) VALUES (5, 'Java1', 'PUBLISHED', 1);

CREATE INDEX fk_tests_has_questions_tests1_idx ON JWD_WebProject.tests_has_questions (tests_id);
CREATE INDEX fk_tests_has_questions_questions1_idx ON JWD_WebProject.tests_has_questions (questions_id);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (3, 1);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (3, 2);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (4, 3);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (4, 4);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (5, 5);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id) VALUES (5, 6);

CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.users (id);
CREATE UNIQUE INDEX email_UNIQUE ON JWD_WebProject.users (email);
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name) VALUES (1, 'nkaramach@gmail.com', '6774', 1, null);
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name) VALUES (2, 'bat@man.com', '6774', 1, null);