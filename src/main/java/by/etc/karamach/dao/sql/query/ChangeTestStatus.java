package by.etc.karamach.dao.sql.query;

public final class ChangeTestStatus {
    public static final String STATEMENT = "UPDATE tests set tests.status = ? where tests.id = ?;";
    public static final int TEST_STAUS_INPUT_INDEX = 1;
    public static final int TEST_ID_INPUT_INDEX = 2;

    private ChangeTestStatus() {
    }
}
