package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.RequestAttributeName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import by.etc.karamach.utils.http.DispatchAssistant;
import by.etc.karamach.utils.http.DispatchException;
import by.etc.karamach.utils.http.SessionHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetMyTest implements Command {
    private TestService testService = ServiceFactory.getInstance().getTestService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        HttpSession session = SessionHelper.getExistingSession(req);

        boolean isGuest =
                (session == null) ||
                        (session.getAttribute(SessionAttributeName.ID) == null);

        if (isGuest) {

            try {
                DispatchAssistant.redirectToJsp(req, resp, JspPageName.LOGIN_PAGE);

            } catch (DispatchException e) {
                //TODO: LOG !
                throw new CommandException(e);
            }

            return null;

        }

        try {

            int userId = (int) session.getAttribute(SessionAttributeName.ID);

            tests = testService.getMyTests(userId);

            req.setAttribute(RequestAttributeName.MY_TESTS, tests);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.USER_TESTS);

        } catch (ServiceException | DispatchException e) {
            //TODO: LOG!
            throw new CommandException(e);
        }

        return null;
    }

}
