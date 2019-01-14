package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.GradeService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FinishTest implements Command {

    private static final GradeService gradeService = ServiceFactory.getInstance().getGradeService();
    private static final Logger logger = LogManager.getLogger();
    private static final String USER_GRADES_PAGE = "controller?command=take_user_grades";

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        Object gradeObj = existingSession.getAttribute(SessionAttributeName.GRADE);
        if (gradeObj == null) {
            throw new CommandException("Illegal request!");
        }

        Grade grade = (Grade) gradeObj;

        try {

            gradeService.finishTest(grade, userId);

            resp.sendRedirect(USER_GRADES_PAGE);

        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException e) {

            logger.error(e);
            throw new RuntimeException(e);

        }

    }

    @Override
    public String getErrorPage() {
        return null;
    }
}
