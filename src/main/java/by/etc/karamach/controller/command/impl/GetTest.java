package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.RequestAttributeName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;
import by.etc.karamach.utils.http.DispatchAssistant;
import by.etc.karamach.utils.http.DispatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class GetTest implements Command {

    private TestService testService = ServiceFactory.getInstance().getTestService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        try {
            tests = testService.getAllTests();

            req.setAttribute(RequestAttributeName.TESTS, tests);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TESTS_PAGE);

        } catch (ServiceException | DispatchException e) {
            //TODO: Log !
            throw new CommandException(e);
        }

        return null;
    }
}
