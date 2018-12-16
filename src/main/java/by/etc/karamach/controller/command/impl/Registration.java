package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.AccessLevel;
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
    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        String email;
        String password;
        String name;

        name = req.getParameter(NAME);
        email = req.getParameter(EMAIL);
        password = req.getParameter(PASSWORD);

        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setAccessLevel(AccessLevel.USER);
        user.setName(name);


        registerUser(user);

        String status;
        status = SUCCESSFULLY_REGISTERED;

        HttpSession session = req.getSession();
        userService.saveUserToSession(session, user);


        req.setAttribute(MSG, status);
        redirectToJsp(req, resp, JspPageName.USER_PAGE);

        return null;
    }

    private void registerUser(User user) throws CommandException {
        try {
            userService.register(user);
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
