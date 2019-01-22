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


public class CreateAnswer implements Command {

    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final String IS_CHECKED_STATUS = "on";
    private static final String QUESTION_PAGE = "controller?command=edit_question&question_id=";
    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        Optional<Integer> questionId = RequestDataExecutor.getIntegerByName(RequestParameterName.QUESTION_ID, req);

        Optional<String> description = RequestDataExecutor.getStringByName(RequestParameterName.DESCRIPTION, req);

        Optional<Boolean> isRight = RequestDataExecutor.getBooleanByName(RequestParameterName.IS_RIGHT, req);

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);


        try {

            if (((!questionId.isPresent()) || (!description.isPresent())) || (!isRight.isPresent())) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);

            } else {

                answerService.saveAnswer(questionId.get(), description.get(), isRight.get(), userId);

                resp.sendRedirect(QUESTION_PAGE + questionId.get());
            }

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }
    }
}
