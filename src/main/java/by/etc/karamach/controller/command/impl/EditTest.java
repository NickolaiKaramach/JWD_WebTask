package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.QuestionService;
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
import java.util.List;
import java.util.Optional;

public class EditTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();

    private static final QuestionService questionService = ServiceFactory.getInstance().getQuestionService();

    private static final transient Logger logger = LogManager.getLogger();


    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Optional<Integer> testId = RequestDataExecutor.getIntegerByName(RequestParameterName.TEST_ID, req);

        Test test;

        try {

            if (!testId.isPresent()) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);
                return;
            }

            boolean isTestOwner;
            isTestOwner = testService.isTestOwner(userId, testId.get());

            if (!isTestOwner) {
                throw new CommandException("You can't access not yours test page");
            }


            test = testService.getTestById(testId.get());


            List<Question> questions = questionService.getQuestionsByTestId(testId.get());
            test.setQuestionList(questions);

            req.setAttribute(RequestAttributeName.TEST, test);
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TEST_PAGE);

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }

    }
}
