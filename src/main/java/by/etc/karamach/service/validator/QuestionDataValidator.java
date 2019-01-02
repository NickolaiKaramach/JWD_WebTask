package by.etc.karamach.service.validator;

public final class QuestionDataValidator {
    private QuestionDataValidator() {
    }

    public boolean isValidQuestionId(int questionId) {
        return (questionId > 0);
    }
}
