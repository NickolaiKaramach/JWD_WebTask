package by.etc.karamach.dao.sql.query;

public final class FindTestByTestId {
    public static final String STATEMENT
            = "SELECT " +
            "tests.id, tests.name, tests.users_id " +
            "FROM " +
            "tests" +
            " WHERE " +
            "(tests.id = ?);";
    public static final int TEST_ID_INPUT_INDEX = 1;

    private FindTestByTestId() {
    }
}
