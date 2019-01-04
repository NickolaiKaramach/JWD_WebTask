package by.etc.karamach.service.validator;

public final class QuestionDataValidator {
    private QuestionDataValidator() {
    }

    public static boolean isValidQuestionId(int questionId) {
        return (questionId > 0);
    }

    public static boolean isValidDescription(String description) {
        return (((description != null) && (!description.isEmpty())) && (description.length() < 30));
    }
}
