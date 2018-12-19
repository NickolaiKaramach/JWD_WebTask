CREATE TABLE jwd_task.questions
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    description varchar(30) DEFAULT '' NOT NULL,
    test_id int(11) NOT NULL
);
CREATE UNIQUE INDEX questions_id_uindex ON jwd_task.questions (id);
INSERT INTO jwd_task.questions (id, description, test_id) VALUES (1, 'What is Java?', 1);
INSERT INTO jwd_task.questions (id, description, test_id) VALUES (2, 'What is JVM', 1);
INSERT INTO jwd_task.questions (id, description, test_id) VALUES (3, 'What is OOD', 2);
INSERT INTO jwd_task.questions (id, description, test_id) VALUES (4, 'What is design patterns', 2);
INSERT INTO jwd_task.questions (id, description, test_id) VALUES (5, 'What is Java EE', 3);
INSERT INTO jwd_task.questions (id, description, test_id) VALUES (6, 'What is Servlet in Java', 3);