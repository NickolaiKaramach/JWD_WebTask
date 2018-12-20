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


    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        User user = createUserFromRequest(req);
        boolean isSuccess;

        try {

            isSuccess = userService.register(user);

        } catch (ServiceException e) {
            //TODO: LOG !
            throw new CommandException(e);
        }


        String nextPage;

        if (isSuccess) {

            HttpSession session = SessionHelper.createOrGetSession(req);
            userService.saveUserToSession(session, user);

            req.setAttribute(MSG, SUCCESSFULLY_REGISTERED);
            nextPage = JspPageName.USER_PAGE;

        } else {

            req.setAttribute(ERROR, ERROR_TRUE);
            req.setAttribute(ERROR_MSG, EMAIL_TAKEN);

            nextPage = JspPageName.REGISTER_PAGE;
        }

        try {

            DispatchAssistant.redirectToJsp(req, resp, nextPage);

        } catch (DispatchException e) {
            //TODO: LOG !
            throw new CommandException(e);
        }

        return null;
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
