package by.etc.karamach.dao.sql.query;

public final class FindTestsByOwnerId {
    public static final String STATEMENT
            = "SELECT " +
            "tests.id, tests.name, tests.owner_id " +
            "FROM " +
            "tests" +
            " WHERE " +
            "(tests.owner_id = ?);";
    public static final int OWNER_ID_INPUT_INDEX = 1;

    private FindTestsByOwnerId() {
    }

}
