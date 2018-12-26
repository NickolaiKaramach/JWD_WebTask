package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.UserService;
import by.etc.karamach.utils.http.DispatchAssistant;
import by.etc.karamach.utils.http.DispatchException;
import by.etc.karamach.utils.http.SessionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static by.etc.karamach.controller.RequestParameterName.*;

public class SignIn implements Command {

    private static final Logger logger = LogManager.getLogger();

    private static final String INVALID_PASSWORD = "Invalid login or password";

    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession session = SessionHelper.getExistingSession(req);

        if ((session != null) &&
                (session.getAttribute(SessionAttributeName.ID) != null)) {

            try {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.USER_PAGE);

            } catch (DispatchException e) {

                logger.error(e.getMessage());
                logger.error(e.getStackTrace().toString());

                throw new CommandException(e);
            }

            return null;
        }


        User user = takeUser(req);

        if (user == null) {
            //TODO: Show error to user
            req.setAttribute(MSG, INVALID_PASSWORD);

            try {


                //TODO: Show error to user
                DispatchAssistant.redirectToJsp(req, resp, JspPageName.ERROR_PAGE);

            } catch (DispatchException e) {

                logger.error(e.getMessage());
                logger.error(e.getStackTrace().toString());

                throw new CommandException(e);
            }

            return null;
        }

        HttpSession newSession = SessionHelper.createOrGetSession(req);
        SessionHelper.saveUserToSession(newSession, user);

        try {
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.USER_PAGE);

        } catch (DispatchException e) {

            throw new CommandException(e);
        }

        return null;
    }

    private User takeUser(HttpServletRequest req) throws CommandException {
        String email;
        String password;


        email = req.getParameter(EMAIL);
        password = req.getParameter(PASSWORD);


        User user;

        try {
            user = userService.signIn(email, password);

        } catch (ServiceException e) {

            logger.error(e.getMessage());
            logger.error(e.getStackTrace().toString());

            throw new CommandException(e);
        }

        return user;
    }

}
