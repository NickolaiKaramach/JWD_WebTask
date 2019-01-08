package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoSuchCommand implements Command {
    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) {
        try {

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.UNKNOWN_COMMAND_PAGE);

        } catch (ServletException | IOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }
    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.FATAL_ERROR_PAGE;
    }

}
