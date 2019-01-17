INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (1, 'nkaramach@gmail.com', '6774', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (2, 'bat@man.com', '6774', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (3, 'nk@gmail.com', '4776', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (4, 'n@gmail.com', '6774', 1, 'Nickolai');

INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (3, 'Java 0', 'PUBLISHED', 1);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (4, 'Another Java', 'PUBLISHED', 2);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (5, 'Java1', 'PUBLISHED', 1);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (10, '123', 'NEW', 3);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (28, 'Мой тест', 'PUBLISHED', 1);

INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (1, 'What is Java?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (2, 'What is JVM?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (3, 'What is AAAA?', 2);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (4, 'What is BBBB?', 2);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (5, 'What is JavaEE?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (6, 'What is JavaServlet?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (10, '321', 3);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (12, 'ÐÐ¾Ð¹ ÑÐµÑÑ', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (13, 'ии', 1);

INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 1);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 2);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 12);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (4, 3);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (4, 4);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (5, 5);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (5, 6);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (10, 10);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (28, 13);

INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (5, 50, 1, 3, '2019-01-11 17:14:04', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (6, 50, 1, 3, '2019-01-13 19:12:41', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (7, 50, 3, 3, '2019-01-14 14:36:42', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (8, 75, 1, 3, '2019-01-14 23:40:21', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (9, 100, 1, 3, '2019-01-14 23:49:10', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (10, 100, 1, 4, '2019-01-15 00:02:30', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (11, 50, 3, 3, '2019-01-16 14:41:37', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (12, 50, 3, 5, '2019-01-16 14:41:52', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (19, 0, 3, 3, '2019-01-16 16:27:47', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (38, 0, 1, 5, '2019-01-17 11:51:29', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (53, 0, 1, 3, '2019-01-17 12:11:00', 1);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (60, 0, 1, 3, '2019-01-17 17:17:41', 0);
INSERT INTO JWD_WebProject.grades (id, degree, users_id, tests_id, finish_time, is_finished)
VALUES (61, 0, 1, 28, '2019-01-17 16:23:49', 1);

INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (1, 'Java is a platform', 1, 1);
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
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (14, '123', 1, 10);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (15, '111', 0, 10);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (16, '333', 0, 10);

INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (13, 1, 2, 5);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (14, 2, 4, 5);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (15, 1, 2, 6);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (16, 2, 4, 6);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (17, 1, 2, 7);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (18, 2, 4, 7);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (19, 1, 2, 8);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (20, 2, 4, 8);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (21, 2, 4, 8);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (22, 2, 4, 8);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (23, 1, 1, 9);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (24, 2, 4, 9);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (25, 3, 5, 10);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (26, 4, 12, 10);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (27, 1, 2, 11);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (28, 2, 4, 11);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (29, 5, 7, 12);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (30, 6, 10, 12);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (31, 1, 2, 19);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (32, 1, 2, 19);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (34, 5, 8, 38);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (35, 5, 8, 38);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (50, 1, 2, 53);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (51, 1, 2, 60);
INSERT INTO JWD_WebProject.choices (id, question_id, answer_id, grade_id)
VALUES (52, 2, 4, 60);