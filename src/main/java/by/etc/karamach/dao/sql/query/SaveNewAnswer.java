package by.etc.karamach.dao.sql.query;

public final class SaveNewAnswer {
    public static final String STATEMENT =
            "INSERT INTO answers (description, isRight, questions_id) values (?, ?, ?);";
    public static final int ANSWER_DESCRIPTION_INPUT_INDEX = 1;
    public static final int ANSWER_IS_RIGHT_INPUT_INDEX = 2;
    public static final int ANSWER_QUESTION_ID_INPUT_INDEX = 3;

    private SaveNewAnswer() {
    }
}
