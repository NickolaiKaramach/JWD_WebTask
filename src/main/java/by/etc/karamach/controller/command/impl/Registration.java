package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.JspPageName;
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

public class Registration implements Command {

    private static final String SUCCESSFULLY_REGISTERED = "Successfully added new user!";
    private static final String EMAIL_TAKEN = "Email is already taken!";
    private static final int ACCESS_LEVEL_USER = 1;

    private static final UserService userService = ServiceFactory.getInstance().getUserService();
    private static final boolean ERROR_TRUE = true;
    private static final Logger logger = LogManager.getLogger();


    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        User user = createUserFromRequest(req);

        boolean isSuccess;

        try {

            isSuccess = userService.register(user);
            user = userService.signIn(user.getEmail(), user.getPassword());

        } catch (ServiceException e) {

            logger.error(e.getMessage(), e);


            throw new CommandException(e);
        }


        String nextPage;


        nextPage = formResponse(req, user, isSuccess);

        try {

            DispatchAssistant.redirectToJsp(req, resp, nextPage);

        } catch (DispatchException e) {

            logger.error(e.getMessage(), e);


            throw new CommandException(e);
        }

        return null;
    }

    private String formResponse(HttpServletRequest req, User user, boolean isSuccess) {
        String nextPage;

        if (isSuccess) {


            HttpSession session = SessionHelper.createOrGetSession(req);
            SessionHelper.saveUserToSession(session, user);

            req.setAttribute(MSG, SUCCESSFULLY_REGISTERED);
            nextPage = JspPageName.USER_PAGE;

        } else {

            req.setAttribute(ERROR, ERROR_TRUE);
            req.setAttribute(ERROR_MSG, EMAIL_TAKEN);

            nextPage = JspPageName.REGISTER_PAGE;
        }

        return nextPage;
    }

    private User createUserFromRequest(HttpServletRequest req) {
        String name;
        String email;
        String password;

        name = req.getParameter(NAME);
        email = req.getParameter(EMAIL);
        password = req.getParameter(PASSWORD);

        User user = new User();

        user.setEmail(email);
        user.setPassword(password);
        user.setAccessLevel(ACCESS_LEVEL_USER);
        user.setName(name);

        return user;
    }

}
