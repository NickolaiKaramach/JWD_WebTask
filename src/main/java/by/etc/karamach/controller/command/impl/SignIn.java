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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.util.RequestParameterName.*;

public class SignIn implements Command {

    private static final String INVALID_PASSWORD = "Invalid login or password";

    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        User user = takeUser(req);
        String nextPage;

        if (user == null) {
            //TODO: Show error to user
            req.setAttribute(MSG, INVALID_PASSWORD);
            nextPage = JspPageName.ERROR_PAGE;

        } else {
            HttpSession newSession = SessionHelper.createOrGetSession(req);
            SessionHelper.saveUserToSession(newSession, user);

            nextPage = JspPageName.USER_PAGE;
        }

        try {
            DispatchAssistant.redirectToJsp(req, resp, nextPage);

        } catch (IOException | ServletException e) {

            throw new CommandException(e);
        }

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

            throw new CommandException(e);
        }

        return user;
    }

}
