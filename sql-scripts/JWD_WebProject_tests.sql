CREATE TABLE JWD_WebProject.tests
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30) DEFAULT '' NOT NULL,
    status varchar(30) DEFAULT '' NOT NULL,
    users_id int(11) NOT NULL,
    CONSTRAINT fk_tests_users FOREIGN KEY (users_id) REFERENCES JWD_WebProject.users (id)
);
CREATE UNIQUE INDEX id_UNIQUE ON JWD_WebProject.tests (id);
CREATE INDEX fk_tests_users_idx ON JWD_WebProject.tests (users_id);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id) VALUES (1, 'Java0', 'NEW', 1);
INSERT INTO JWD_WebProject.tests (id, name, status, users_id) VALUES (2, 'Java1', 'NEW', 2);