package by.etc.karamach.dao.sql.query;

public final class FindAnswerByAnswerIdAndUserId {
    public static final String STATEMENT = "select  answers.isRight, answers.description from answers inner join questions q on answers.questions_id = q.id WHERE answers.id = ? and q.onwer_id = ?;";
    public static final int ANSWER_IS_RIGHT_RESULT_INDEX = 1;
    public static final int ANSWER_DESCRIPTION_RESULT_INDEX = 2;
    public static final int ANSWER_ID_INPUT_INDEX = 1;
    public static final int USER_ID_INPUT_INDEX = 2;

    private FindAnswerByAnswerIdAndUserId() {
    }
}
