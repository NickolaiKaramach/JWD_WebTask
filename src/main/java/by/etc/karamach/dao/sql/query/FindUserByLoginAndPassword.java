package by.etc.karamach.dao.sql.query;

public final class FindUserByLoginAndPassword {
    public static final int LOGIN_INPUT_INDEX = 1;
    public static final int PASSWORD_INPUT_INDEX = 2;

    public static final int ID_RESULT_INDEX = 1;
    public static final int ACCESS_LEVEL_RESULT_INDEX = 2;
    public static final int EMAIL_RESULT_INDEX = 3;
    public static final int PASSWORD_RESULT_INDEX = 4;
    public static final int NAME_RESULT_INDEX = 5;

    public static final String STATEMENT
            = "select " +
            "users.id, users.access_level, users.email, users.password, users.name " +
            "FROM " +
            "users " +
            "WHERE " +
            "(email = ?) and (password = ?);";

    private FindUserByLoginAndPassword() {
    }
}