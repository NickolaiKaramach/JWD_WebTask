package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.RequestParameterName;
import by.etc.karamach.controller.SessionAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import by.etc.karamach.utils.http.SessionHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DeleteTest implements Command {

    private static final TestService testService = ServiceFactory.getInstance().getTestService();
    private static final Logger logger = LogManager.getLogger();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {

        HttpSession existingSession = SessionHelper.getExistingSession(req);

        Integer userId =
                (Integer) existingSession.getAttribute(SessionAttributeName.ID);

        if (userId == null) {
            logger.error("You must be logged in, to delete your tests!");
            throw new CommandException("You must be logged in, to delete your tests!");
        }

        int testId = Integer.valueOf(req.getParameter(RequestParameterName.TEST_ID));

        try {

            testService.deleteTest(userId, testId);

            resp.sendRedirect("http://localhost:8080/controller?command=get_my_tests");

        } catch (ServiceException | IOException e) {

            logger.error(e.getMessage(), e);
            throw new CommandException(e);
        }

        return null;
    }

}
