package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.User;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestDataExecutor;
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
import java.util.Optional;

import static by.etc.karamach.controller.util.RequestParameterName.EMAIL;
import static by.etc.karamach.controller.util.RequestParameterName.PASSWORD;

public class SignIn implements Command {

    private static final UserService userService = ServiceFactory.getInstance().getUserService();

    private static final transient Logger logger = LogManager.getLogger();


    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        User user = takeUser(req);
        String nextPage;

        if (user == null) {
            throw new CommandException("Invalid password!");

        }

        HttpSession newSession = SessionHelper.createOrGetSession(req);
        SessionHelper.saveUserToSession(newSession, user);

        nextPage = JspPageName.INDEX_JSP;


        try {

            DispatchAssistant.redirectToJsp(req, resp, nextPage);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }

    }

    private User takeUser(HttpServletRequest req) throws CommandException {
        Optional<String> email;
        Optional<String> password;


        email = RequestDataExecutor.getStringByName(EMAIL, req);
        password = RequestDataExecutor.getStringByName(PASSWORD, req);

        User user;

        if ((!email.isPresent()) || (!password.isPresent())) {

            throw new CommandException("Invalid request!");

        }

        try {

            user = userService.signIn(email.get(), password.get());

        } catch (ServiceException e) {

            throw new CommandException(e);
        }

        return user;
    }

}
