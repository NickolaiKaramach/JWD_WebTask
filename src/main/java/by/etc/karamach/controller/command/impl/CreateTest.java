package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.Controller.SERVER_PATH;

public class CreateTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    private static final String USER_TESTS_PAGE = SERVER_PATH + "/controller?command=get_my_tests";
    private static final transient Logger logger = LogManager.getLogger();

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

            resp.sendRedirect(USER_TESTS_PAGE);


        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.TEST_PAGE;
    }

    private Test constructTestFromData(Integer userId, String testName) {
        Test test = new Test();

        test.setOwnerId(userId);
        test.setName(testName);
        return test;
    }

}
