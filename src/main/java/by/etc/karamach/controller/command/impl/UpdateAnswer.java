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


public class UpdateAnswer implements Command {
    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final String ANSWER_PAGE_URL = "controller?command=edit_answer&answer_id=";
    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        Optional<Integer> answerId = RequestDataExecutor.getIntegerByName(RequestParameterName.ANSWER_ID, req);

        Optional<String> description = RequestDataExecutor.getStringByName(RequestParameterName.DESCRIPTION, req);

        Optional<Boolean> isRight = RequestDataExecutor.getBooleanByName(RequestParameterName.IS_RIGHT, req);

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        boolean isSuccessful;

        try {

            if (((!answerId.isPresent()) || (!description.isPresent())) || (!isRight.isPresent())) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);

                return;
            }

            isSuccessful = answerService.updateAnswer(answerId.get(), description.get(), isRight.get(), userId);

            if (isSuccessful) {

                resp.sendRedirect(ANSWER_PAGE_URL + answerId.get());

            } else {

                throw new CommandException("Something goes wrong...");

            }


        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

    }
}
