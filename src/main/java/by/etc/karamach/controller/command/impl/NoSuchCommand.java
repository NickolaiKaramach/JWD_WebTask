package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class NoSuchCommand implements Command {
    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        try {
            DispatchAssistant.redirectToJsp(req, resp, JspPageName.INDEX_JSP);
        } catch (ServletException | IOException e) {
            throw new CommandException(e);
        }
    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.FATAL_ERROR_PAGE;
    }

}
