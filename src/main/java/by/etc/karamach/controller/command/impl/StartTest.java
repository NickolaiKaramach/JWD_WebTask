package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.bean.Question;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.command.CommandName;
import by.etc.karamach.controller.command.CommandProvider;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.GradeService;
import by.etc.karamach.service.QuestionService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class StartTest implements Command {

    private static final GradeService gradeService = ServiceFactory.getInstance().getGradeService();
    private static final QuestionService questionService = ServiceFactory.getInstance().getQuestionService();


    private static final Logger logger = LogManager.getLogger();

    private static final int FIRST_QUESTION_INDEX = 0;

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        int testId = Integer.valueOf(req.getParameter(RequestParameterName.TEST_ID));


        try {

            Grade grade;
            grade = gradeService.startTest(userId, testId);

            List<Question> questionList;
            questionList = questionService.getQuestionsByTestId(testId);

            existingSession.setAttribute(SessionAttributeName.GRADE, grade);
            existingSession.setAttribute(SessionAttributeName.QUESTION_LIST, questionList);
            existingSession.setAttribute(SessionAttributeName.CURRENT_QUESTION, FIRST_QUESTION_INDEX);

            Command nextCommandToExecute =
                    CommandProvider.getInstance().getCommand(CommandName.TAKE_NEXT_QUESTION.toString());

            nextCommandToExecute.executeTask(req, resp);


        } catch (ServiceException e) {

            throw new CommandException(e);

        }

    }

    @Override
    public String getErrorPage() {
        return null;
    }
}
