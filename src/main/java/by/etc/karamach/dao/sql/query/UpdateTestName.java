package by.etc.karamach.dao.sql.query;

public final class UpdateTestName {
    public static final String STATEMENT = "UPDATE tests set tests.name = ? where tests.id = ?;";
    public static final int TEST_NAME_INPUT_INDEX = 1;
    public static final int TEST_ID_INPUT_INDEX = 2;

    private UpdateTestName() {
    }
}
