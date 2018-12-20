CREATE TABLE jwd_task.tests
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(30) DEFAULT '' NOT NULL,
    owner_id int(11) NOT NULL,
    status varchar(30) DEFAULT '' NOT NULL
);
CREATE UNIQUE INDEX test_id_uindex ON jwd_task.tests (id);
INSERT INTO jwd_task.tests (id, name, owner_id, status) VALUES (1, 'Java0', 5, 'PUBLISHED');
INSERT INTO jwd_task.tests (id, name, owner_id, status) VALUES (2, 'Java1', 6, 'PUBLISHED');
INSERT INTO jwd_task.tests (id, name, owner_id, status) VALUES (3, 'Java2', 7, 'PUBLISHED');