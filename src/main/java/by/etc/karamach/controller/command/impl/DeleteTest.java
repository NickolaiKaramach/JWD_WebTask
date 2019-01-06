package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestParameterName;
import by.etc.karamach.controller.util.SessionAttributeName;
import by.etc.karamach.controller.util.SessionHelper;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.etc.karamach.controller.Controller.SERVER_PATH;

public class DeleteTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    private static final String USER_TESTS_PAGE_URL = SERVER_PATH + "/controller?command=get_my_tests";

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);

        Integer userId =
                (Integer) existingSession.getAttribute(SessionAttributeName.ID);

        if (userId == null) {
            throw new CommandException("You must be logged in, to delete your tests!");
        }

        int testId = Integer.valueOf(req.getParameter(RequestParameterName.TEST_ID));

        try {

            testService.deleteTest(userId, testId);

            resp.sendRedirect(USER_TESTS_PAGE_URL);

        } catch (ServiceException | IOException e) {

            throw new CommandException(e);
        }

    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.USER_TESTS;
    }

}
