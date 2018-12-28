package by.etc.karamach.controller.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class DispatchAssistant {

    private DispatchAssistant() {
    }

    public static void redirectToJsp(HttpServletRequest req, HttpServletResponse resp,
                                     String jspPageName) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspPageName);

        dispatcher.forward(req, resp);

    }

}
