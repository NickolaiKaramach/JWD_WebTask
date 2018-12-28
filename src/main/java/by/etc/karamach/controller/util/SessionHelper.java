package by.etc.karamach.controller.util;

import by.etc.karamach.bean.User;

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

    public static void saveUserToSession(HttpSession session, User user) {

        session.setAttribute(SessionAttributeName.EMAIL, user.getEmail());
        session.setAttribute(SessionAttributeName.PASSWORD, user.getPassword());
        session.setAttribute(SessionAttributeName.ACCESS_LEVEL, user.getAccessLevel());
        session.setAttribute(SessionAttributeName.NAME, user.getName());
        session.setAttribute(SessionAttributeName.ID, user.getId());
    }
}
