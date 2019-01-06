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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//TODO: QUESTION: Can we use -s in name?
public class GetTests implements Command {

    private TestService testService = ServiceFactory.getInstance().getTestService();


    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        try {
            tests = testService.getAllTests();

            req.setAttribute(RequestAttributeName.TESTS, tests);

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.TESTS_PAGE);

        } catch (ServiceException | IOException | ServletException e) {

            throw new CommandException(e);
        }

    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.INDEX_JSP;
    }
}
