package by.etc.karamach.dao.sql.query;

public final class FindAllTests {
    public static final String statement
            = "SELECT " +
            "tests.id, tests.name, tests.owner_id " +
            "FROM " +
            "tests " +
            "WHERE " +
            "tests.status = 'PUBLISHED';";
    public static final int ID_RESULT_INDEX = 1;
    public static final int NAME_RESULT_INDEX = 2;
    public static final int OWNER_ID_RESULT_INDEX = 3;

    private FindAllTests() {
    }
}
