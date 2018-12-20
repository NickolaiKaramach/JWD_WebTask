package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.RequestParameterName;
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

public class CreateTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    //TODO: QUESTION? What to do with same
    private static final boolean DONT_CREATE_NEW_SESSION = false;

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession session = req.getSession(DONT_CREATE_NEW_SESSION);

        int userId = (int) session.getAttribute(SessionAttributeName.ID);
        String testName = req.getParameter(RequestParameterName.NAME);

        Test test = new Test();

        test.setOwnerId(userId);
        test.setName(testName);

        boolean status;
        try {
            status = testService.saveNewTest(test);
        } catch (ServiceException e) {
            //TODO: LOG !
            throw new CommandException(e);
        }

        if (status) {
            //TODO: Extract
            req.setAttribute("test", test);
            redirectToJsp(req, resp, JspPageName.TEST_PAGE);

        } else {
            //TODO: Show error to user
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
