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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class EditTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();

    private static final QuestionService questionService = ServiceFactory.getInstance().getQuestionService();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        int testId = Integer.valueOf(req.getParameter(RequestParameterName.TEST_ID));


        Test test;

        try {

            boolean isTestOwner;
            isTestOwner = testService.isTestOwner(userId, testId);

            if (!isTestOwner) {
                throw new CommandException("You can't access not yours test page");
            }


            test = testService.getTestById(testId);


            List<Question> questions = questionService.getQuestionsByTestId(testId);
            test.setQuestionList(questions);

            req.setAttribute(RequestAttributeName.TEST, test);
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TEST_PAGE);

        } catch (ServiceException | IOException | ServletException e) {

            throw new CommandException(e);
        }

    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.USER_TESTS;
    }
}
