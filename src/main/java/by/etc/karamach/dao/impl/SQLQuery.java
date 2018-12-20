package by.etc.karamach.dao.impl;

public class SQLQuery {
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD
            = "SELECT * FROM users WHERE email = ? AND password = ?;";
    public static final String SAVE_USER_AS_REGISTERED
            = "INSERT INTO users (email, id, password, access_level, name) VALUES (?, ?, ?, ?, ?);";
    public static final String FIND_USER_BY_LOGIN
            = "SELECT * FROM users WHERE email = ?;";
    public static final String FIND_ALL_TESTS
            = "SELECT tests.id, tests.name, tests.owner_id FROM tests WHERE tests.status = 'PUBLISHED';";
    public static final String FIND_TESTS_BY_OWNER_ID
            = "SELECT tests.id, tests.name, tests.owner_id FROM tests WHERE (tests.status = 'PUBLISHED') AND (tests.owner_id = ?);";
}
