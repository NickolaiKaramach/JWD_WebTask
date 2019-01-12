package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Answer;
import by.etc.karamach.bean.Question;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.AnswerService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TakeNextQuestion implements Command {
    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();

    private static final Logger logger = LogManager.getLogger();
    private static final String FINISH_TEST_PAGE = "controller?command=finish_test";

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);

        Integer currentQuestionNum = (Integer) existingSession.getAttribute(SessionAttributeName.CURRENT_QUESTION);

        Object questionListObject = existingSession.getAttribute(SessionAttributeName.QUESTION_LIST);


        if (((currentQuestionNum == null) || (questionListObject == null))) {
            throw new CommandException("Invalid request");
        }


        List<Question> questions = (List<Question>) questionListObject;


        try {

            if (currentQuestionNum >= questions.size()) {
                //TODO: Mock to Finish
                resp.sendRedirect(FINISH_TEST_PAGE);
                return;
            }

            Question question = questions.get(currentQuestionNum);


            List<Answer> answerList;

            answerList =
                    answerService.getAnswersByQuestionId(question.getId(), question.getOwnerId());

            req.setAttribute(RequestAttributeName.QUESTION, question);
            req.setAttribute(RequestAttributeName.ANSWER_LIST, answerList);

            currentQuestionNum++;
            existingSession.setAttribute(SessionAttributeName.CURRENT_QUESTION, currentQuestionNum);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.ASSESSMENT_PAGE);

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (ServletException | IOException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }


    }

    @Override
    public String getErrorJspPage() {
        return null;
    }
}
