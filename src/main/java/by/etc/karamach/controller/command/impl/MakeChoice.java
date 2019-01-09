package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.command.CommandName;
import by.etc.karamach.controller.command.CommandProvider;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.ChoiceService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MakeChoice implements Command {
    private static final ChoiceService choiceService = ServiceFactory.getInstance().getChoiceService();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Object gradeObj = existingSession.getAttribute(SessionAttributeName.GRADE);
        if (gradeObj == null) {
            throw new CommandException("Illegal request!");
        }

        Grade grade = (Grade) gradeObj;

        int answerId = Integer.valueOf(req.getParameter(RequestParameterName.ANSWER));
        int questionId = Integer.valueOf(req.getParameter(RequestParameterName.QUESTION_ID));

        try {

            choiceService.makeChoice(grade, answerId, userId, questionId);

            Command nextCommandToExecute =
                    CommandProvider.getInstance().getCommand(CommandName.GET_NEXT_QUESTION.toString());

            nextCommandToExecute.executeTask(req, resp);

        } catch (ServiceException e) {

            throw new CommandException(e);

        }


    }

    @Override
    public String getErrorJspPage() {
        return null;
    }
}
