package by.etc.karamach.dao.sql.query;

public final class DeleteQuestionByQuestionId {
    public static final String STATEMENT =
            "delete from tests_has_questions where questions_id = ?; ";
    public static final String SECOND_STATEMENT = "delete from questions where id = ?;";
    public static final int QUESTION_ID_INPUT_INDEX = 1;
    public static final int QUESTION_ID_SECOND_INPUT_INDEX = 1;

    private DeleteQuestionByQuestionId() {
    }

}
