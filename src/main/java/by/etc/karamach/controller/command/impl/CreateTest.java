package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.RequestAttributeName;
import by.etc.karamach.controller.RequestParameterName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import by.etc.karamach.utils.http.DispatchAssistant;
import by.etc.karamach.utils.http.DispatchException;
import by.etc.karamach.utils.http.SessionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CreateTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession session = SessionHelper.getExistingSession(req);

        Integer userId = (Integer) session.getAttribute(SessionAttributeName.ID);
        String testName = req.getParameter(RequestParameterName.NAME);

        if ((userId == null) || (testName == null)) {

            logger.error("Invalid data input!");
            throw new CommandException("Invalid data input, please try one more time!");
            //TODO: ERROR
        }


        try {

            Test test = constructTestFromData(userId, testName);

            testService.saveNewTest(test);

            req.setAttribute(RequestAttributeName.TEST, test);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TEST_PAGE);

        } catch (ServiceException | DispatchException e) {
            logger.error(e.getMessage(), e);


            throw new CommandException(e);
        }


        return null;
    }

    private Test constructTestFromData(Integer userId, String testName) {
        Test test = new Test();

        test.setOwnerId(userId);
        test.setName(testName);
        return test;
    }

}
