package by.etc.karamach.utils.validator;

public final class TestDataValidator {
    private TestDataValidator() {
    }

    public static boolean isValidTestName(String testName) {
        return (testName != null) && (!testName.isEmpty());
    }

    public static boolean isValidTestId(int testId) {
        return testId >= 0;
    }

}
