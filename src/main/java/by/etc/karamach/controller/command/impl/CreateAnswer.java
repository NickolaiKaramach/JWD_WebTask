package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.AnswerService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CreateAnswer implements Command {

    private static final AnswerService answerService = ServiceFactory.getInstance().getAnswerService();
    private static final String IS_CHECKED_STATUS = "on";
    private static final String QUESTION_PAGE = "controller?command=edit_question&question_id=";
    private static final transient Logger logger = LogManager.getLogger();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        int questionId = Integer.valueOf(req.getParameter(RequestParameterName.QUESTION_ID));

        String description = req.getParameter(RequestParameterName.DESCRIPTION);

        boolean isRight;

        String checkBox = req.getParameter(RequestParameterName.IS_RIGHT);

        isRight = (checkBox != null) && (checkBox.equals(IS_CHECKED_STATUS));


        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);


        try {

            answerService.saveAnswer(questionId, description, isRight, userId);

            resp.sendRedirect(QUESTION_PAGE + questionId);

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }
    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.QUESTION_PAGE;
    }
}
