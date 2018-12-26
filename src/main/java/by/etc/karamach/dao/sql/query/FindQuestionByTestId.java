package by.etc.karamach.dao.sql.query;

public final class FindQuestionByTestId {
    public static final String STATEMENT = "select questions.id, questions.description FROM questions where test_id = ?;";
    public static final int ID_RESULT_INDEX = 1;
    public static final int DESCRIPTION_RESULT_INDEX = 2;
    public static final int TEST_ID_INPUT_INDEX = 1;

    private FindQuestionByTestId() {
    }
}

