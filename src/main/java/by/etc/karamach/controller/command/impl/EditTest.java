package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.RequestAttributeName;
import by.etc.karamach.controller.RequestParameterName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.QuestionService;
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
import java.util.List;

public class EditTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();

    private static final QuestionService questionService = ServiceFactory.getInstance().getQuestionService();

    private static final Logger logger = LogManager.getLogger();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        int testId = Integer.valueOf(req.getParameter(RequestParameterName.TEST_ID));

        boolean isTestOwner;

        try {

            isTestOwner = testService.isTestOwner(userId, testId);

        } catch (ServiceException e) {

            logger.error(e.getMessage(), e);
            throw new CommandException(e);
        }


        if (!isTestOwner) {
            logger.error("User " + userId + " access invalid test");
            throw new CommandException("You can't access not yours test page");
        }

        Test test;

        try {

            test = testService.getTestById(testId);

            List<Question> questions = questionService.getQuestionsByTestId(testId);

            test.setQuestionList(questions);

            req.setAttribute(RequestAttributeName.TEST, test);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TEST_PAGE);

        } catch (ServiceException | DispatchException e) {

            logger.error(e.getMessage(), e);
            throw new CommandException(e);

        }

        return null;
    }
}
