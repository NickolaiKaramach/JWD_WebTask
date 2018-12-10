package by.etc.karamach.dao.DAOImpl;

public class SQLQuery {
    public static final String FIND_USER_BY_LOGIN_AND_PASSWORD
            = "SELECT * FROM users WHERE email = ? AND password = ?;";
    public static final String SAVE_USER_AS_REGISTERED
            = "INSERT INTO users (email, id, password, access_level, name) VALUES (?, ?, ?, ?, ?);";
    public static final String FIND_USER_BY_LOGIN
            = "SELECT * FROM users WHERE email = ?;";
}
