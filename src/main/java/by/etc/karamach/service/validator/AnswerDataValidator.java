package by.etc.karamach.service.validator;

public final class AnswerDataValidator {
    private AnswerDataValidator() {
    }

    public static boolean isValidAnswerDescription(String description) {
        return (((description != null) && (!description.isEmpty())) && (description.length() < 200));
    }

    public static boolean isValidAnswerId(int answerId) {

        return answerId > 0;
    }
}
