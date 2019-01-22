package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class PrepareForTest implements Command {
    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Optional<Integer> testId = RequestDataExecutor.getIntegerByName(RequestParameterName.TEST_ID, req);


        try {

            if (!testId.isPresent()) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);

            } else {

                Test test;
                test = testService.prepareForTest(userId, testId.get());

                req.setAttribute(RequestAttributeName.TEST, test);
                DispatchAssistant.redirectToJsp(req, resp, JspPageName.PREASSESSMENT_PAGE);

            }

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (ServletException | IOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }
    }
}
