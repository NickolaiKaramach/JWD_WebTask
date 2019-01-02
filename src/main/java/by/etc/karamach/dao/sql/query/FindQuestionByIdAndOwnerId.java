package by.etc.karamach.dao.sql.query;

public final class FindQuestionByIdAndOwnerId {
    public static final String STATEMENT = "select questions.description from questions where (questions.id = ?) and (questions.onwer_id = ?);";
    public static final int QUESTION_DESCRIPTION_RESULT_INDEX = 1;
    public static final int QUESTION_ID_INPUT_INDEX = 1;
    public static final int QUESTION_OWNER_ID_INPUT_INDEX = 2;

    private FindQuestionByIdAndOwnerId() {
    }
}
