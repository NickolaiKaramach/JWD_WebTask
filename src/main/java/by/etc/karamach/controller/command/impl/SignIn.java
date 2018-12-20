package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.SessionAttributeName;
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

public class SignIn implements Command {

    private static final String GREETING = "You have been logged in.";
    private static final String INVALID_PASSWORD = "Invalid login or password";
    private static final boolean DONT_CREATE_NEW_SESSION = false;
    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession session = req.getSession(DONT_CREATE_NEW_SESSION);

        boolean isAlreadyLoggedIn = false;
        if (session != null) {
            isAlreadyLoggedIn = (session.getAttribute(SessionAttributeName.ACCESS_LEVEL) != null);
        }

        String status;

        if (!isAlreadyLoggedIn) {
            String email;
            String password;


            email = req.getParameter(EMAIL);
            password = req.getParameter(PASSWORD);


            User user;
            user = getUser(email, password);


            if (user != null) {

                HttpSession newSession = req.getSession();
                userService.saveUserToSession(newSession, user);

                status = GREETING;

            } else {
                status = INVALID_PASSWORD;
            }
        } else {
            status = "Is already logged in!";
        }

        req.setAttribute(MSG, status);
        redirectToJsp(req, resp);

        return null;
    }


    private User getUser(String login, String password) throws CommandException {
        User user;

        try {
            user = userService.signIn(login, password);

        } catch (ServiceException e) {
            //TODO: LOG!
            //TODO: QUESTION: Can we overdo message?
            throw new CommandException("Incorrect data", e);
        }

        return user;
    }

    //TODO: Same methods
    private void redirectToJsp(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        RequestDispatcher dispatcher = req.getRequestDispatcher(JspPageName.USER_PAGE);

        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            //TODO: LOG!
            throw new CommandException("Something goes wrong", e);
        }
    }
}
