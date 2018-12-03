package by.etc.karamach.validator;

public class UserDataValidator {
    public static boolean isValidLogin(String login) {
        return (login != null) && (!login.isEmpty());
    }

    public static boolean isValidPassword(String password) {
        return (password != null) && (!password.isEmpty());
    }
}
