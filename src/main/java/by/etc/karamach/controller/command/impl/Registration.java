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

public class Registration implements Command {

    private static final String SUCCESSFULLY_REGISTERED = "Successfully added new user!";

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        String login;
        String password;


        login = req.getParameter(LOGIN);
        password = req.getParameter(PASSWORD);

        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setAccessLevel(AccessLevel.USER);


        registerUser(user);

        String status;
        status = SUCCESSFULLY_REGISTERED;

        addUserDataToSession(req, user);

        req.setAttribute(MSG, status);
        redirectToJsp(req, resp, JspPageName.USER_PAGE);

        return null;
    }

    private void addUserDataToSession(HttpServletRequest req, User user) {
        HttpSession session = req.getSession();

        session.setAttribute(SessionAttributeName.LOGIN, user.getLogin());
        session.setAttribute(SessionAttributeName.PASSWORD, user.getPassword());
        session.setAttribute(SessionAttributeName.ACCESS_LEVEL, user.getAccessLevel());
    }

    private void registerUser(User user) throws CommandException {
        try {
            ServiceFactory.getInstance().getUserService().register(user);
        } catch (ServiceException e) {
            //TODO: LOG !
            throw new CommandException(e);
        }
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
