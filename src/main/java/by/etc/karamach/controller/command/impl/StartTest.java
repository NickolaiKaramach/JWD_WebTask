package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.bean.Question;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class StartTest implements Command {

    private static final GradeService gradeService = ServiceFactory.getInstance().getGradeService();
    private static final QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
    private static final TestService testService = ServiceFactory.getInstance().getTestService();

    private static final int FIRST_QUESTION_INDEX = 0;
    private static final String TAKE_NEXT_QUESTION_COMMAND = "controller?command=take_next_question";

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Optional<Integer> testId = RequestDataExecutor.getIntegerByName(RequestParameterName.TEST_ID, req);


        try {

            if (!testId.isPresent()) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);
                return;
            }

            Grade grade;
            grade = gradeService.startTest(userId, testId.get());

            List<Question> questionList;
            questionList = questionService.getQuestionsByTestId(testId.get());

            existingSession.setAttribute(SessionAttributeName.GRADE, grade);
            existingSession.setAttribute(SessionAttributeName.QUESTION_LIST, questionList);
            existingSession.setAttribute(SessionAttributeName.CURRENT_QUESTION, FIRST_QUESTION_INDEX);

            resp.sendRedirect(TAKE_NEXT_QUESTION_COMMAND);


        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            throw new RuntimeException(e);

        }

    }
}
