package by.etc.karamach.dao.sql.query;

public final class SaveNewChoice {
    public static final String STATEMENT = "insert into choices (question_id, answer_id, grade_id) VALUES (?, ?, ?);";
    public static final int QUESTION_ID_INPUT_INDEX = 1;
    public static final int ANSWER_ID_INPUT_INDEX = 2;
    public static final int GRADE_ID_INPUT_INDEX = 3;

    private SaveNewChoice() {
    }
}
