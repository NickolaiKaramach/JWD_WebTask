package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.logic.ServiceException;
import by.etc.karamach.logic.ServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.etc.karamach.controller.RequestParameterName.LOGIN;
import static by.etc.karamach.controller.RequestParameterName.MSG;
import static by.etc.karamach.controller.RequestParameterName.PASSWORD;

public class SignIn implements Command {

    private static final String USER_GREETING = "You have been logged in as a User!";
    private static final String INVALID_PASSWORD = "Invalid password";

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        //TODO:Command - implement
        String login;
        String password;


        login = (String) req.getParameter(LOGIN);
        password = (String) req.getParameter(PASSWORD);


        String status;
        status = getEnterStatus(login, password);


        req.setAttribute(MSG, status);
        redirectToJsp(req, resp);

        return null;
    }




    private String getEnterStatus(String login, String password) throws CommandException {
        boolean isLoggedIn;

        try {
            isLoggedIn = ServiceFactory.getInstance().getUserService()
                    .SignIn(login, password);

        } catch (ServiceException e) {
            //TODO: LOG!
            //TODO: QUESTION: Can we overdo message?
            throw new CommandException("Incorrect data", e);
        }

        String status;

        status = isLoggedIn ? USER_GREETING : INVALID_PASSWORD;
        return status;
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
