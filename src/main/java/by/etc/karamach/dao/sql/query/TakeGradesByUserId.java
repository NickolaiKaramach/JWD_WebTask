package by.etc.karamach.dao.sql.query;

public final class TakeGradesByUserId {
    public static final String STATEMENT = "select grades.degree, grades.finish_time, t.name FROM grades inner join tests t on grades.tests_id = t.id WHERE (grades.is_finished = 1) and (grades.users_id = ?);";
    public static final int GRADE_USER_ID_INPUT_INDEX = 1;
    public static final int GRADE_DEGREE_RESULT_INDEX = 1;
    public static final int GRADE_FINISH_TIME_RESULT_INDEX = 2;
    public static final int TEST_NAME_RESULT_INDEX = 3;

    private TakeGradesByUserId() {
    }
}
