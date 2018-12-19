CREATE TABLE jwd_task.test
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30) DEFAULT '' NOT NULL,
    owner_id int(11) NOT NULL
);
CREATE UNIQUE INDEX test_id_uindex ON jwd_task.test (id);
INSERT INTO jwd_task.test (id, name, owner_id) VALUES (1, 'Java0', 5);
INSERT INTO jwd_task.test (id, name, owner_id) VALUES (2, 'Java1', 6);
INSERT INTO jwd_task.test (id, name, owner_id) VALUES (3, 'Java2', 7);