package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Question;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.QuestionService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class EditQuestion implements Command {

    private static final QuestionService questionService = ServiceFactory.getInstance().getQuestionService();
    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        int questionId = Integer.valueOf(req.getParameter(RequestParameterName.QUESTION_ID));

        try {
            Question question = questionService.getQuestionById(questionId, userId);

            req.setAttribute(RequestAttributeName.QUESTION, question);
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.QUESTION_PAGE);

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }


    }
}
