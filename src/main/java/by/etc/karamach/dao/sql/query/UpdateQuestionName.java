package by.etc.karamach.dao.sql.query;

public final class UpdateQuestionName {
    public static final String STATEMENT =
            "UPDATE questions set description = ? where id = ?;";
    public static final int QUESTION_DESCRIPTION_INPUT_INDEX = 1;
    public static final int QUESTION_ID_INPUT_INDEX = 2;

    private UpdateQuestionName() {
    }


}
