package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.*;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class TakeMyTest implements Command {
    private TestService testService = ServiceFactory.getInstance().getTestService();
    private static final transient Logger logger = LogManager.getLogger();


    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        HttpSession session = SessionHelper.getExistingSession(req);

        boolean isGuest =
                (session == null) ||
                        (session.getAttribute(SessionAttributeName.ID) == null);

        try {

            if (isGuest) {
                DispatchAssistant.redirectToJsp(req, resp, JspPageName.LOGIN_PAGE);
                return;
            }


            int userId = (int) session.getAttribute(SessionAttributeName.ID);

            tests = testService.getMyTests(userId);

            req.setAttribute(RequestAttributeName.MY_TESTS, tests);
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.USER_TESTS);

        } catch (ServiceException e) {

            throw new CommandException(e);
        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.USER_PAGE;
    }

}
