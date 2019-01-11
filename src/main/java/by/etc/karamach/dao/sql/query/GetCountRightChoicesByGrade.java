package by.etc.karamach.dao.sql.query;

public final class GetCountRightChoicesByGrade {
    public static final String STATEMENT = "select count(choices.id) " +
            "from choices " +
            "inner join answers a on choices.answer_id = a.id " +
            "where (choices.grade_id = ?) and (a.isRight = 1);";
    public static final int GRADE_ID_INPUT_INDEX = 1;
    public static final int CHOICES_COUNT_RESULT_INDEX = 1;

    private GetCountRightChoicesByGrade() {
    }
}
