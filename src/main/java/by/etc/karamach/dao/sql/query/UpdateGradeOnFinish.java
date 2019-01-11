package by.etc.karamach.dao.sql.query;

public final class UpdateGradeOnFinish {
    public static final String STATEMENT =
            "UPDATE grades set grades.degree = ?, grades.finish_time = ?, grades.is_finished = 1 WHERE grades.id = ?;";
    public static final int GRADE_DEGREE_INPUT_INDEX = 1;
    public static final int GRADE_FINISH_TIME_INPUT_INDEX = 2;
    public static final int GRADE_ID_INPUT_INDEX = 3;

    private UpdateGradeOnFinish() {
    }

}
