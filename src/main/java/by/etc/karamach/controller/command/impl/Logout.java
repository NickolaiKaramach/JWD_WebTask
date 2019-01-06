package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;
import by.etc.karamach.controller.util.DispatchAssistant;
import by.etc.karamach.controller.util.JspPageName;
import by.etc.karamach.controller.util.SessionHelper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Command {

    @Override
    public void executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        HttpSession session = SessionHelper.getExistingSession(req);

        session.invalidate();

        try {

            DispatchAssistant.redirectToJsp(req, resp, JspPageName.INDEX_JSP);

        } catch (IOException | ServletException e) {

            throw new CommandException(e);

        }

    }

    @Override
    public String getErrorJspPage() {
        return JspPageName.INDEX_JSP;
    }
}
