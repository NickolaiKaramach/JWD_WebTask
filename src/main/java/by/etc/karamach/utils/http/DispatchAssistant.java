package by.etc.karamach.utils.http;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public final class DispatchAssistant {
    private static final Logger logger = LogManager.getLogger();

    private DispatchAssistant() {
    }

    public static void redirectToJsp(HttpServletRequest req, HttpServletResponse resp,
                                     String jspPageName) throws DispatchException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspPageName);

        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {

            logger.error(ExceptionUtils.getStackTrace(e));


            throw new DispatchException(e);
        }
    }


}
