package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.SessionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession session = SessionHelper.getExistingSession(req);

        session.invalidate();


        try {

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.INDEX_JSP);

        } catch (IOException | ServletException e) {

            throw new CommandException(e);

        }


        return null;
    }
}
