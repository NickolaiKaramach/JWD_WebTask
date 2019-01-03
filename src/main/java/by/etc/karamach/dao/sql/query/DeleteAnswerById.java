package by.etc.karamach.dao.sql.query;

public final class DeleteAnswerById {
    public static final String STATEMENT = "DELETE FROM answers WHERE answers.id = ?;";
    public static final int ANSWER_ID_INPUT_INDEX = 1;

    private DeleteAnswerById() {
    }
}
