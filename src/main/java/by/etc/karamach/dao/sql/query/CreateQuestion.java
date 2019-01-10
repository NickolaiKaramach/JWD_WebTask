package by.etc.karamach.dao.sql.query;

public final class CreateQuestion {
    public static final String STATEMENT =
            "INSERT INTO questions(description, owner_id) VALUES (?, ?);";
    public static final String GET_LAST_ID_STATEMENT =
            "select @@identity;";
    public static final String CREATE_RELATION_STATEMENT =
            "INSERT into tests_has_questions (tests_id, questions_id) values (?, ?);";
    public static final int QUESTION_DESCRIPTION_INPUT_INDEX = 1;
    public static final int QUESTION_OWNER_ID_INPUT_INDEX = 2;
    public static final int LAST_ID_RESULT_INDEX = 1;
    public static final int QUESTION_ID_INPUT_INDEX = 2;
    public static final int TEST_ID_INPUT_INDEX = 1;

    private CreateQuestion() {
    }

}
