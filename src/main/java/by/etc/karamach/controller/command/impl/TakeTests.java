package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.RequestAttributeName;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//TODO: QUESTION: Can we use -s in name?
public class TakeTests implements Command {

    private TestService testService = ServiceFactory.getInstance().getTestService();

    private static final transient Logger logger = LogManager.getLogger();


    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        try {
            tests = testService.getAllTests();

            req.setAttribute(RequestAttributeName.TESTS, tests);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TESTS_PAGE);

        } catch (ServiceException e) {

            throw new CommandException(e);
        } catch (IOException | ServletException e) {

            logger.error(e);
            throw new RuntimeException(e);
        }

    }

    @Override
    public String getErrorPage() {
        return JspPageName.INDEX_JSP;
    }
}
