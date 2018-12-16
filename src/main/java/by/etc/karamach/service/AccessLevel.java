package by.etc.karamach.service;

public final class AccessLevel {
    public static final int GUEST = 0;
    public static final int USER = 1;
    public static final int ADMIN = 2;
    private static final String UNKNOWN_ROLE = "Unknown role";
    private static final String ADMIN_ROLE = "Admin";
    private static final String USER_ROLE = "User";
    private static final String GUEST_ROLE = "Guest";

    //TODO: Remove
    public static String getRoleName(int accessLevel) {
        String roleName;

        switch (accessLevel) {
            case GUEST:
                roleName = GUEST_ROLE;
                break;
            case USER:
                roleName = USER_ROLE;
                break;
            case ADMIN:
                roleName = ADMIN_ROLE;
                break;
            default:
                roleName = UNKNOWN_ROLE;
        }

        return roleName;
    }
}
