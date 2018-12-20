package by.etc.karamach.controller.command.impl;

import by.etc.karamach.bean.Test;
import by.etc.karamach.controller.JspPageName;
import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.service.ServiceException;
import by.etc.karamach.service.ServiceFactory;
import by.etc.karamach.service.TestService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetTest implements Command {

    private TestService testService = ServiceFactory.getInstance().getTestService();

    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        List<Test> tests;

        try {
            tests = testService.getAllTests();
        } catch (ServiceException e) {
            //TODO: Log !
            throw new CommandException(e);
        }
        //TODO: Extract
        req.setAttribute("tests", tests);

        RequestDispatcher dispatcher = req.getRequestDispatcher(JspPageName.TESTS_PAGE);

        try {
            dispatcher.forward(req, resp);

        } catch (ServletException | IOException e) {
            //TODO: LOG!
            throw new CommandException("Something goes wrong", e);
        }

        return null;
    }
}
