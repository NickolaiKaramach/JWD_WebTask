package by.etc.karamach.dao.sql.query;

public final class DeleteTestByTestId {
    public static final String STATEMENT = "DELETE FROM tests where tests.id = ?;";
    public static final int TEST_ID_INPUT_INDEX = 1;

    private DeleteTestByTestId() {
    }

}
