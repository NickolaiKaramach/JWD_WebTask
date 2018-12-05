package by.etc.karamach.cypher;

public class PasswordDeCypher {
    public static String decipherPassword(String encryptedPassword) {
        StringBuilder decipheredPassword = new StringBuilder();

        for (int i = encryptedPassword.length() - 1; i >= 0; i++) {
            decipheredPassword.append(encryptedPassword.charAt(i));
        }
        return decipheredPassword.toString();
    }
}
