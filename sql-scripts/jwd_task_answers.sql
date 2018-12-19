CREATE TABLE jwd_task.answers
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description varchar(50) DEFAULT '' NOT NULL,
    question_id int(11) NOT NULL,
    isRight tinyint(1) DEFAULT '0' NOT NULL
);
CREATE UNIQUE INDEX answers_id_uindex ON jwd_task.answers (id);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (1, 'An animal', 1, 0);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (2, 'A new smartphone', 1, 0);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (3, 'Programming language or platform', 1, 1);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (4, 'Java Volatile Mechanism', 2, 0);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (5, 'Java Virtual Machine', 2, 1);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (6, 'Jaguar Vegan Magazine', 2, 0);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (7, 'Object oriented design', 3, 1);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (8, 'Some abstract algorithms..', 4, 1);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (9, 'Java Enterprise Edition', 5, 1);
INSERT INTO jwd_task.answers (id, description, question_id, isRight) VALUES (10, 'Servlet - java class', 6, 1);