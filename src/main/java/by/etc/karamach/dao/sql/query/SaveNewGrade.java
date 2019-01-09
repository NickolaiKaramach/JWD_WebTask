package by.etc.karamach.dao.sql.query;

public final class SaveNewGrade {
    public static final String STATEMENT = "INSERT INTO grades (users_id, tests_id, finish_time) VALUES (?, ?, ?);";
    public static final String GET_LAST_ID_STATEMENT =
            "select @@identity;";
    public static final int GRADE_USER_ID_INPUT_INDEX = 1;
    public static final int GRADE_TEST_ID_INPUT_INDEX = 2;
    public static final int GRADE_FINISH_TIME_INPUT_INDEX = 3;

    private SaveNewGrade() {
    }
}
