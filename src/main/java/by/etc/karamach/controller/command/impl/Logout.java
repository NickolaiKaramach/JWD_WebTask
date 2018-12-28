package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.utils.http.DispatchAssistant;
import by.etc.karamach.utils.http.DispatchException;
import by.etc.karamach.utils.http.SessionHelper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Command {
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession session = SessionHelper.getExistingSession(req);

        session.invalidate();


        try {

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.INDEX_JSP);

        } catch (DispatchException e) {

            logger.error(ExceptionUtils.getStackTrace(e));


            throw new CommandException(e);

        }


        return null;
    }
}
