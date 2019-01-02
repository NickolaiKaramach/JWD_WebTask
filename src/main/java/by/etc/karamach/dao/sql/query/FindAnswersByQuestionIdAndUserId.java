package by.etc.karamach.dao.sql.query;

public final class FindAnswersByQuestionIdAndUserId {

    public static final int ID_RESUlT_INDEX = 1;
    public static final int DESCRIPTION_RESULT_INDEX = 2;
    public static final int IS_RIGHT_RESULT_INDEX = 3;

    public static final int QUESTION_ID_INPUT_INDEX = 1;
    public static final int QUESTION_OWNER_ID_INPUT_INDEX = 2;

    public static final String STATEMENT = "select answers.id, answers.description, answers.isRight from answers inner join questions q on answers.questions_id = q.id where (answers.questions_id = ?) AND (q.onwer_id = ?);";

    private FindAnswersByQuestionIdAndUserId() {
    }
}
