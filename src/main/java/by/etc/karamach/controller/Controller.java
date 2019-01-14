package by.etc.karamach.controller;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.command.CommandProvider;
import by.etc.karamach.controller.util.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


//TODO: 1. Logger hierarchy


public final class Controller extends HttpServlet {

    private static final long serialVersionUID = -4642709576494909869L;

    private static final transient Logger logger = LogManager.getLogger();
    private static final String PATH_PARAM_MARKER = "?";
    private static final String EQUAL = "=";
    private static final String ADDING_PATH_PARAM_MARKER = "&";

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
            redirectToErrorPage(req, resp, command.getErrorPage(), e.getMessage());
        }
    }

    private void redirectToErrorPage(HttpServletRequest req, HttpServletResponse resp, String page, String message) throws ServletException, IOException {


        HttpSession session = SessionHelper.getExistingSession(req);


        if ((session == null) || (session.getAttribute(SessionAttributeName.LAST_URL) == null)) {

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.FATAL_ERROR_PAGE);

        } else {

            String lastUrl = (String) session.getAttribute(SessionAttributeName.LAST_URL);
            String pathMessageParameter;

            if (!lastUrl.contains(PATH_PARAM_MARKER)) {

                pathMessageParameter = PATH_PARAM_MARKER + RequestParameterName.ERROR_MSG + EQUAL + message;

            } else {

                pathMessageParameter = ADDING_PATH_PARAM_MARKER + RequestParameterName.ERROR_MSG + EQUAL + message;

            }

            resp.sendRedirect(lastUrl + pathMessageParameter);

        }
    }

}
