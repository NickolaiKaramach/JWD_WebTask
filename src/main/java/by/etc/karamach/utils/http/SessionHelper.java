package by.etc.karamach.utils.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class SessionHelper {
    private SessionHelper() {
    }

    public static HttpSession getExistingSession(HttpServletRequest request) {
        return request.getSession(false);
    }

    public static HttpSession createOrGetSession(HttpServletRequest request) {
        return request.getSession(true);
    }
}
