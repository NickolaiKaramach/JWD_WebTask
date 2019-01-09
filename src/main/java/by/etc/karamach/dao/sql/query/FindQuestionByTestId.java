package by.etc.karamach.dao.sql.query;

public final class FindQuestionByTestId {
    public static final String STATEMENT =
            "select questions.id, questions.description, questions.onwer_id " +
                    "from questions " +
                    "inner join tests_has_questions on questions.id = tests_has_questions.questions_id " +
                    "inner join tests on tests.id = tests_has_questions.tests_id " +
                    "where tests.id = ?;";
    public static final int ID_RESULT_INDEX = 1;
    public static final int DESCRIPTION_RESULT_INDEX = 2;
    public static final int OWNER_ID_RESULT_INDEX = 3;
    public static final int TEST_ID_INPUT_INDEX = 1;

    private FindQuestionByTestId() {
    }
}

