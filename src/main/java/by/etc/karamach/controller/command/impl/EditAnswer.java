package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Answer;
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

public class EditAnswer implements Command {
    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Optional<Integer> answerId = RequestDataExecutor.getIntegerByName(RequestParameterName.ANSWER_ID, req);

        try {
            if (!answerId.isPresent()) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);

            } else {

                Answer answer = answerService.getAnswerById(answerId.get(), userId);

                req.setAttribute(RequestAttributeName.ANSWER, answer);
                DispatchAssistant.redirectToJsp(req, resp, JspPageName.ANSWER_PAGE);

            }

        } catch (ServiceException e) {

            throw new CommandException(e);


        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }
    }
}
