package by.etc.karamach.dao.sql.query;

public final class DeleteUnusedGrades {
    public static final String STATEMENT = "DELETE FROM grades WHERE (is_finished = 0) and(finish_time < CURRENT_TIMESTAMP());";

    private DeleteUnusedGrades() {
    }
}
