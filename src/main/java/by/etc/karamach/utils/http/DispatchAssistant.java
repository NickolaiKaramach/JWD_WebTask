package by.etc.karamach.utils.http;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class DispatchAssistant {

    private DispatchAssistant() {
    }

    public static void redirectToJsp(HttpServletRequest req, HttpServletResponse resp,
                                     String jspPageName) throws DispatchException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspPageName);

        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            //TODO: LOG!
            throw new DispatchException(e);
        }
    }


}
