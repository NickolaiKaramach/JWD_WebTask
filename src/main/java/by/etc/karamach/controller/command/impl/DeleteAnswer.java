package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.AnswerService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.Controller.SERVER_PATH;

public class DeleteAnswer implements Command {
    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final String QUESTION_PAGE_URL = SERVER_PATH + "/controller?command=edit_question&question_id=";

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        int answerId = Integer.valueOf(req.getParameter(RequestParameterName.ANSWER_ID));

        int questionId = Integer.valueOf(req.getParameter(RequestParameterName.QUESTION_ID));

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        try {

            answerService.deleteAnswer(answerId, userId);

            resp.sendRedirect(QUESTION_PAGE_URL + questionId);

        } catch (ServiceException | IOException e) {

            throw new CommandException(e);

        }
    }
}
