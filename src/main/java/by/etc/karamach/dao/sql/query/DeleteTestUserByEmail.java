package by.etc.karamach.dao.sql.query;

public final class DeleteTestUserByEmail {
    public static final String STATEMENT = "delete from users where users.email = ?;";
    public static final int USER_EMAIL_INPUT_INDEX = 1;

    private DeleteTestUserByEmail() {
    }
}
