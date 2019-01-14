package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Grade;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.GradeService;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TakeUserGrades implements Command {
    private static final GradeService gradeService = ServiceFactory.getInstance().getGradeService();

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession existingSession = SessionHelper.getExistingSession(req);


        Integer userId =
                (Integer) existingSession.getAttribute(SessionAttributeName.ID);

        try {
            List<Grade> gradeList;

            gradeList = gradeService.takeUserGrades(userId);

            req.setAttribute(RequestAttributeName.GRADES, gradeList);
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.USER_GRADES);
        } catch (ServiceException e) {

            throw new CommandException(e);

        } catch (IOException | ServletException e) {

            throw new RuntimeException(e);

        }

    }
}
