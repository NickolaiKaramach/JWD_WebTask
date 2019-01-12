package by.etc.karamach.controller;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.command.CommandProvider;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestAttributeName;
import by.etc.karamach.controller.util.RequestParameterName;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//TODO: 1. Logger hierarchy


public final class Controller extends HttpServlet {

    private static final long serialVersionUID = -4642709576494909869L;

    private static final transient Logger logger = LogManager.getLogger();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String commandName = req.getParameter(RequestParameterName.COMMAND_NAME);

        Command command = CommandProvider.getInstance().getCommand(commandName);

        try {
            command.executeTask(req, resp);
        } catch (CommandException e) {

            logger.error(ExceptionUtils.getStackTrace(e));


            //TODO: Place error msg at jsp
            //TODO: Show easy-to-understand message to user
            req.setAttribute(RequestAttributeName.ERROR, e);
            redirectToErrorPage(req, resp, command.getErrorJspPage());
        }
    }

    private void redirectToErrorPage(HttpServletRequest req, HttpServletResponse resp, String jspName) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspName);

        if (dispatcher == null) {
            dispatcher = req.getRequestDispatcher(JspPageName.FATAL_ERROR_PAGE);
        }

        dispatcher.forward(req, resp);
    }

}
