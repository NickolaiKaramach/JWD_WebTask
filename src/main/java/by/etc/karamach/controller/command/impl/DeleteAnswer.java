package by.etc.karamach.controller.command.impl;

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
import java.util.Optional;


public class DeleteAnswer implements Command {
    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final String QUESTION_PAGE_URL = "controller?command=edit_question&question_id=";

    private static final transient Logger logger = LogManager.getLogger();


    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        Optional<Integer> answerId = RequestDataExecutor.getIntegerByName(RequestParameterName.ANSWER_ID, req);

        Optional<Integer> questionId = RequestDataExecutor.getIntegerByName(RequestParameterName.QUESTION_ID, req);

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        try {

            if ((!answerId.isPresent()) || (!questionId.isPresent())) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);

            } else {

                answerService.deleteAnswer(answerId.get(), userId);

                resp.sendRedirect(QUESTION_PAGE_URL + questionId.get());
            }

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }
    }

}
