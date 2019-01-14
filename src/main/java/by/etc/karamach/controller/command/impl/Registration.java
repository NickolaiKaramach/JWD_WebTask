package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.util.RequestParameterName.*;

public class Registration implements Command {

    private static final String SUCCESSFULLY_REGISTERED = "Successfully added new user!";
    private static final String EMAIL_TAKEN = "Email is already taken!";
    private static final int ACCESS_LEVEL_USER = 1;

    private static final UserService userService = ServiceFactory.getInstance().getUserService();
    private static final boolean ERROR_TRUE = true;

    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        User user = createUserFromRequest(req);

        boolean isSuccess;

        try {

            isSuccess = userService.register(user);
            user = userService.signIn(user.getEmail(), user.getPassword());


            String nextPage;
            nextPage = formResponse(req, user, isSuccess);


            DispatchAssistant.redirectToJsp(req, resp, nextPage);

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }

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
