package by.etc.karamach.dao.sql.query;

public final class DeleteUnusedChoices {
    public static final String STATEMENT = "DELETE c FROM choices c INNER JOIN grades g on c.grade_id = g.id WHERE (g.is_finished = 0) AND (finish_time < current_timestamp());\n";

    private DeleteUnusedChoices() {
    }
}
