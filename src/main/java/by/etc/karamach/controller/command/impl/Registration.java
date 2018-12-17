package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

        boolean isSuccessful = registerUser(user);
        String nextPage;

        if (isSuccessful) {

            HttpSession session = req.getSession();
            userService.saveUserToSession(session, user);

            req.setAttribute(MSG, SUCCESSFULLY_REGISTERED);
            nextPage = JspPageName.USER_PAGE;


        } else {
            req.setAttribute(ERROR, ERROR_TRUE);
            req.setAttribute(ERROR_MSG, EMAIL_TAKEN);

            nextPage = JspPageName.REGISTER_PAGE;
        }


        //TODO: Doesn't redirect normally
        redirectToJsp(req, resp, nextPage);

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

    private boolean registerUser(User user) throws CommandException {
        boolean result;

        try {
            result = userService.register(user);
        } catch (ServiceException e) {
            //TODO: LOG !
            throw new CommandException(e);
        }

        return result;
    }

    private void redirectToJsp(HttpServletRequest req, HttpServletResponse resp, String jspPageName) throws CommandException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(jspPageName);

        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            //TODO: LOG!
            throw new CommandException("Something goes wrong", e);
        }
    }
}
