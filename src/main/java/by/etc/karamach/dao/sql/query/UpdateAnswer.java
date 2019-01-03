package by.etc.karamach.dao.sql.query;

public final class UpdateAnswer {
    public static final int ANSWER_DESCRIPTION_INPUT_INDEX = 1;
    public static final int ANSWER_IS_RIGHT_INPUT_INDEX = 2;
    public static final int ANSWER_ID_INPUT_INDEX = 3;
    public static final String STATEMENT =
            "update answers set answers.description = ?, answers.isRight = ? where answers.id = ?;";

    private UpdateAnswer() {
    }
}
