package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.command.CommandName;
import by.etc.karamach.controller.command.CommandProvider;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.ChoiceService;
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

public class MakeChoice implements Command {
    private static final ChoiceService choiceService = ServiceFactory.getInstance().getChoiceService();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Object gradeObj = existingSession.getAttribute(SessionAttributeName.GRADE);
        if (gradeObj == null) {
            throw new CommandException("Illegal request!");
        }

        Grade grade = (Grade) gradeObj;

        Optional<Integer> answerId = RequestDataExecutor.getIntegerByName(RequestParameterName.ANSWER, req);
        Optional<Integer> questionId = RequestDataExecutor.getIntegerByName(RequestParameterName.QUESTION_ID, req);

        try {

            if ((!answerId.isPresent()) || (!questionId.isPresent())) {

                DispatchAssistant.redirectToJsp(req, resp, JspPageName.INVALID_REQUEST_PARAMETER);

            } else {

                choiceService.makeChoice(grade, answerId.get(), userId, questionId.get());

                Command nextCommandToExecute =
                        CommandProvider.getInstance().getCommand(CommandName.TAKE_NEXT_QUESTION.toString());

                nextCommandToExecute.executeTask(req, resp);

            }

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (ServletException | IOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }


    }
}
