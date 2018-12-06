package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.logic.AccessLevel;
import by.etc.karamach.logic.ServiceException;
import by.etc.karamach.logic.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.RequestParameterName.*;

public class SignIn implements Command {

    private static final String GREETING = "You have been logged in as a ";
    private static final String INVALID_PASSWORD = "Invalid login or password";

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        //TODO:Command - implement
        String login;
        String password;


        login = req.getParameter(LOGIN);
        password = req.getParameter(PASSWORD);


        User user;
        user = getUser(login, password);

        String status;

        if (user != null) {

            addUserDataToSession(req, user);
            status = GREETING + AccessLevel.getRoleName(user.getAccessLevel());

        } else {
            status = INVALID_PASSWORD;
        }

        req.setAttribute(MSG, status);
        redirectToJsp(req, resp);

        return null;
    }

    private void addUserDataToSession(HttpServletRequest req, User user) {
        HttpSession session = req.getSession();

        session.setAttribute(SessionAttributeName.LOGIN, user.getLogin());
        session.setAttribute(SessionAttributeName.PASSWORD, user.getPassword());
        session.setAttribute(SessionAttributeName.ACCESS_LEVEL, user.getAccessLevel());
    }


    private User getUser(String login, String password) throws CommandException {
        User user;

        try {
            user = ServiceFactory.getInstance().getUserService()
                    .signIn(login, password);

        } catch (ServiceException e) {
            //TODO: LOG!
            //TODO: QUESTION: Can we overdo message?
            throw new CommandException("Incorrect data", e);
        }

        return user;
    }

    //TODO: Equal methods
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
