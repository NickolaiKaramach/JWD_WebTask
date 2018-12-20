package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetMyTest implements Command {
    private static final boolean DONT_CREATE_NEW_SESSION = false;
    private TestService testService = ServiceFactory.getInstance().getTestService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        HttpSession session = req.getSession(DONT_CREATE_NEW_SESSION);

        if ((session == null) ||
                (session.getAttribute(SessionAttributeName.ID) == null)) {

            redirectToJsp(req, resp, JspPageName.LOGIN_PAGE);

        } else {

            try {

                int userId = (int) session.getAttribute(SessionAttributeName.ID);

                tests = testService.getMyTests(userId);

                //TODO:Extract
                req.setAttribute("mytests", tests);

                redirectToJsp(req, resp, JspPageName.USER_TESTS);

            } catch (ServiceException e) {
                //TODO: LOG!
                throw new CommandException(e);
            }
        }

        return null;
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
