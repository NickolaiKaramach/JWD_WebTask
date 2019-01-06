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

public class ChangeTestName implements Command {
    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    private static final String TEST_PAGE_URL = SERVER_PATH + "/controller?command=edit_test&test_id=";

    @Override
    public String getErrorJspPage() {
        return JspPageName.TEST_PAGE;
    }

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession existingSession = SessionHelper.getExistingSession(req);
        int userId = (int) existingSession.getAttribute(SessionAttributeName.ID);

        int testId = Integer.valueOf(req.getParameter(RequestParameterName.TEST_ID));

        String newName = req.getParameter(RequestParameterName.NAME);

        try {

            testService.updateTestName(testId, newName, userId);

            resp.sendRedirect(TEST_PAGE_URL + testId);

        } catch (ServiceException | IOException e) {

            throw new CommandException(e);

        }

    }
}
