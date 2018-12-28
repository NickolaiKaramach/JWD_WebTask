CREATE TABLE JWD_WebProject.grades
(
    id int(11) NOT NULL AUTO_INCREMENT,
    degree int(11) DEFAULT '0' NOT NULL,
    users_id int(11) NOT NULL,
    tests_id int(11) NOT NULL,
    finish_time datetime NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (id, tests_id),
    CONSTRAINT fk_grades_users1 FOREIGN KEY (users_id) REFERENCES JWD_WebProject.users (id),
    CONSTRAINT fk_grades_tests1 FOREIGN KEY (tests_id) REFERENCES JWD_WebProject.tests (id)
);
CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.grades (id);
CREATE INDEX fk_grades_users1_idx ON JWD_WebProject.grades (users_id);
CREATE INDEX fk_grades_tests1_idx ON JWD_WebProject.grades (tests_id);