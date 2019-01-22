package by.etc.karamach.dao.sql.query;

public final class TakeTestStatusByTestId {
    public static final String STATEMENT = "SELECT tests.status FROM tests WHERE tests.id = ?;";
    public static final int TEST_ID_INPUT_INDEX = 1;
    public static final int TEST_STATUS_RESULT_INDEX = 1;

    private TakeTestStatusByTestId() {
    }
}
