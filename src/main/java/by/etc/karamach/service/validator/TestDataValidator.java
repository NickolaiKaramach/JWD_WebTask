package by.etc.karamach.service.validator;

public final class TestDataValidator {
    private TestDataValidator() {
    }

    public static boolean isValidTestName(String testName) {
        return (((testName != null) && (!testName.isEmpty())) && (testName.length() < 200));
    }

    public static boolean isValidTestId(int testId) {
        return testId >= 0;
    }

}
