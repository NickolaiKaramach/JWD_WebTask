package by.etc.karamach.dao.sql.query;

public final class FindUserByEmail {
    public static final int LOGIN_INPUT_INDEX = 1;
    public static final String STATEMENT
            = "SELECT " +
            "users.id, users.access_level, users.email, users.password, users.name " +
            "FROM " +
            "users " +
            "WHERE " +
            "email = ?;";

    private FindUserByEmail() {
    }
}
