package by.etc.karamach.dao.sql.query;

public final class FindTestsByOwnerId {
    public static final String STATEMENT
            = "SELECT " +
            "tests.id, tests.name, tests.users_id " +
            "FROM " +
            "tests" +
            " WHERE " +
            "(tests.users_id = ?);";
    public static final int OWNER_ID_INPUT_INDEX = 1;

    private FindTestsByOwnerId() {
    }

}
