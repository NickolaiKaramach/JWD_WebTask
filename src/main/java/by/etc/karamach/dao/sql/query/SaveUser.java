package by.etc.karamach.dao.sql.query;

public final class SaveUser {
    public static final String STATEMENT
            =
            "INSERT INTO " +
                    "users " +
                    "(email, id, password, access_level, name) " +
                    "VALUES " +
                    "(?, ?, ?, ?, ?);";
    public static final int EMAIL_INPUT_INDEX = 1;
    public static final int ID_INPUT_INDEX = 2;
    public static final int PASSWORD_INPUT_INDEX = 3;
    public static final int ACCESS_LEVEL_INPUT_INDEX = 4;
    public static final int NAME_INPUT_INDEX = 5;

    private SaveUser() {
    }
}
