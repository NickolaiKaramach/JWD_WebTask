package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CreateTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession session = SessionHelper.getExistingSession(req);

        Integer userId = (Integer) session.getAttribute(SessionAttributeName.ID);
        String testName = req.getParameter(RequestParameterName.NAME);

        if ((userId == null) || (testName == null)) {

            throw new CommandException("Invalid data input, please try one more time!");
            //TODO: SHOW ERROR
        }


        try {

            Test test = constructTestFromData(userId, testName);

            testService.saveNewTest(test);

            req.setAttribute(RequestAttributeName.TEST, test);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TEST_PAGE);

        } catch (ServiceException | IOException | ServletException e) {

            throw new CommandException(e);
        }

    }

    private Test constructTestFromData(Integer userId, String testName) {
        Test test = new Test();

        test.setOwnerId(userId);
        test.setName(testName);
        return test;
    }

}
