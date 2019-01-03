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

public class UpdateAnswer implements Command {
    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final String QUESTION_PAGE_URL = SERVER_PATH + "/controller?command=edit_question&question_id=1";
    private static final String IS_CHECKED_STATUS = "on";

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {


        int answerId = Integer.valueOf(req.getParameter(RequestParameterName.ANSWER_ID));

        String description = req.getParameter(RequestParameterName.DESCRIPTION);

        boolean isRight;

        String checkBox = req.getParameter(RequestParameterName.IS_RIGHT);

        isRight = (checkBox != null) && (checkBox.equals(IS_CHECKED_STATUS));


        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        boolean isSuccessful;

        try {

            isSuccessful = answerService.updateAnswer(answerId, description, isRight, userId);

            if (isSuccessful) {
                resp.sendRedirect(QUESTION_PAGE_URL);
            } else {
                //TODO: Show Error to user!
            }

        } catch (ServiceException | IOException e) {

            throw new CommandException(e);

        }

    }
}
