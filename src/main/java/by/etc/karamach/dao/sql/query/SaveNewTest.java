package by.etc.karamach.dao.sql.query;

public final class SaveNewTest {
    public static final String STATEMENT
            = "INSERT INTO JWD_WebProject.tests (name, users_id, status) VALUES ( ?, ?, 'IN PROCESS');";
    public static final int NAME_INPUT_INDEX = 1;
    public static final int OWNER_ID_INPUT_INDEX = 2;

    private SaveNewTest() {
    }
}
