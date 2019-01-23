INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (1, 'nkaramach@gmail.com', '6774', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (2, 'bat@man.com', '6774', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (3, 'nk@gmail.com', '4776', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (4, 'n@gmail.com', '6774', 1, 'Nickolai');
INSERT INTO JWD_WebProject.users (id, email, password, access_level, name)
VALUES (5, 'michel@gmail.com', '6774', 1, 'Michel');

INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (3, 'Java для начинающих', 'PUBLISHED', 1);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (5, 'Java средний уровень', 'PUBLISHED', 1);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (33, 'JavaScript For Beginners', 'PUBLISHED', 5);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (34, 'JavaScript Middle level', 'PUBLISHED', 5);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id)
VALUES (35, 'Примитивные типы в Java', 'NEW', 1);

INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (1, 'Что такое Java?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (2, 'Что такое JVM?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (5, 'Что такое Java EE?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (6, 'Что такое Java Servlet?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (19, 'Какие из этих вызовов синтаксически верно сгенерируют исключение?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (20, 'Чему равно значение выражения 4 - "5" + 0xf - "1e1"?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (21, 'Какая арифметическая операция приводит к ошибке в javascript?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (22, 'Есть ли разница между вызовами i++ и ++i?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (23, 'Какие конструкции для циклов есть в javascript?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (24,
        'Можно ли инициировать DOM-событие из javascript?  Например, сэмулировать клик мышкой на элементе, чтобы javascript-код кликнул за пользователя.',
        5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (26, 'Какой оператор из этих - выполняет не только математические операции?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (27, 'Что из этого - не событие мыши ?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (29, 'В каком случае из перечисленных событие не попадет на обработку javascript?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (30, 'Где в документе может располагаться тэг script по стандарту HTML ?', 5);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (31, 'Назначение Java MicroEdition?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (32, 'Что такое JDK?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (33, 'Множественное наследование в Java?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (34, 'Размер(бит) boolean?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (35, 'Размер(байт) char?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (36, 'Размер(бит) short?', 1);
INSERT INTO JWD_WebProject.questions (id, description, owner_id)
VALUES (37, 'Размер(бит) int? ', 1);

INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 1);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 2);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (5, 5);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (5, 6);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (33, 19);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (33, 20);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (33, 21);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (33, 22);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (33, 23);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (34, 24);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (34, 26);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (34, 27);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (34, 29);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (34, 30);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 31);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (3, 32);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (5, 33);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (35, 34);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (35, 35);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (35, 36);
INSERT INTO JWD_WebProject.tests_has_questions (tests_id, questions_id)
VALUES (35, 37);

INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (5, 50, '2019-01-11 17:14:04', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (6, 50, '2019-01-13 19:12:41', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (7, 50, '2019-01-14 14:36:42', 1, 3, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (8, 75, '2019-01-14 23:40:21', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (9, 100, '2019-01-14 23:49:10', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (11, 50, '2019-01-16 14:41:37', 1, 3, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (12, 50, '2019-01-16 14:41:52', 1, 3, 5);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (19, 0, '2019-01-16 16:27:47', 1, 3, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (38, 0, '2019-01-17 11:51:29', 1, 1, 5);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (53, 0, '2019-01-17 12:11:00', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (63, 0, '2019-01-22 17:37:45', 1, 3, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (67, 50, '2019-01-22 22:07:59', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (68, 0, '2019-01-23 09:58:44', 1, 1, 3);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (69, 100, '2019-01-23 12:25:07', 1, 5, 33);
INSERT INTO JWD_WebProject.grades (id, degree, finish_time, is_finished, users_id, tests_id)
VALUES (70, 67, '2019-01-23 12:45:36', 1, 2, 34);

INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (1, 'Java - это платформа', 1, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (2, 'Java это кофе', 0, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (3, 'Java Vehicle Master', 0, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (4, 'Java Virtual Machine', 1, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (7, 'Java Enterprise Edition', 1, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (8, 'Java Economic Environment', 0, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (10, 'Java метод', 0, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (21, 'throw "Ошибка"', 0, 19);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (22, 'throw new Error("Ошибка")', 1, 19);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (23, 'throw { message: "Ошибка" }', 0, 19);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (24, 'throw Error("Ошибка")', 0, 19);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (25, 'Ни один.', 0, 19);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (26, 'Цифре', 1, 20);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (27, 'Строке', 0, 20);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (28, 'NaN', 0, 20);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (29, 'Деление на ноль.', 0, 21);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (30, 'Умножение числа на строку', 0, 21);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (31, 'Корень из отрицательного числа.', 0, 21);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (32, 'Никакая из вышеперечисленных', 1, 21);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (33, 'Разница в значении, которое возвращает такой вызов.', 1, 22);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (34, 'Разница в значении i после вызова.', 0, 22);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (35, 'Нет никакой разницы.', 0, 22);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (36, 'Только две: for и while.', 0, 23);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (37, 'Только одна: for.', 0, 23);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (38, 'Три: for, while и do...while.', 1, 23);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (39, 'Да, можно', 1, 24);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (40, 'Нет, нельзя', 0, 24);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (41, 'В некоторых браузерах можно', 0, 24);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (43, '*', 0, 26);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (44, '/', 0, 26);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (45, '+', 1, 26);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (46, '-', 0, 26);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (47, 'onclick', 0, 27);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (48, 'onmousescroll', 1, 27);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (49, 'onmouseover', 0, 27);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (50, 'Если в момент его наступления обрабатывается другое событие', 0, 29);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (51, 'Если страничка просматривается локально, т.е offline', 0, 29);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (52, 'Только если javascript отключен', 1, 29);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (53, 'Только в HEAD', 0, 30);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (54, 'Только в BODY', 0, 30);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (55, 'В HEAD или в BODY', 1, 30);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (56, 'Где угодно, главное чтоб был	', 1, 30);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (57, 'Java - стиль программирования', 0, 1);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (58, 'Junior Virtual Master', 0, 2);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (59, 'Для неопытных программистов и детей', 0, 31);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (60, 'Для небольших проектов', 0, 31);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (61, 'Для мобильных устройств', 1, 31);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (62, 'Это Java Disney for Kids, парк развлечений для детей программистов', 0, 32);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (63, 'Java Distribution in Korea ', 0, 32);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (64, 'Java Development Kit', 1, 32);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (65, 'Java Enjoy Everything - стиль жизни', 0, 5);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (66, 'Программный компонент, расширяющий возможности сервера', 1, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (67, 'Аппаратный компонент, увеличивающий возможности сервера', 0, 6);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (68, 'Нет даже близко похожих механизмов', 0, 33);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (69, 'Есть, один класс может наследоваться от множества других', 0, 33);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (70, 'Множественное наследование классов не существует, однако есть похожие механизмы', 1, 33);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (71, '1 бит', 0, 34);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (72, '4 бита', 0, 34);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (73, '8 бит', 0, 34);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (74, 'Может изменяться  ', 1, 34);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (75, '8', 1, 35);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (76, '16', 0, 35);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (77, '1', 0, 35);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (78, '2', 1, 35);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (79, '4', 0, 36);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (80, '16', 1, 36);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (81, '32', 0, 36);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (82, '24', 0, 36);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (83, '8', 0, 37);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (84, '16', 0, 37);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (85, '24', 0, 37);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (86, '32', 1, 37);
INSERT INTO JWD_WebProject.answers (id, description, isRight, questions_id)
VALUES (87, '64', 0, 37);

INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (13, 5, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (14, 5, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (15, 6, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (16, 6, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (17, 7, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (18, 7, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (19, 8, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (20, 8, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (21, 8, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (22, 8, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (23, 9, 1, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (24, 9, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (27, 11, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (28, 11, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (29, 12, 7, 5);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (30, 12, 10, 6);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (31, 19, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (32, 19, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (34, 38, 8, 5);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (35, 38, 8, 5);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (50, 53, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (53, 63, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (56, 67, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (57, 67, 4, 2);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (58, 68, 2, 1);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (59, 69, 22, 19);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (60, 69, 26, 20);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (61, 69, 32, 21);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (62, 69, 33, 22);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (63, 69, 38, 23);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (64, 70, 39, 24);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (65, 70, 45, 26);
INSERT INTO JWD_WebProject.choices (id, grade_id, answer_id, question_id)
VALUES (66, 70, 49, 27);
