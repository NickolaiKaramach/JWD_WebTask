package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout implements Command {
    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        //TODO:REPLACE GET SESSION

        HttpSession session = req.getSession(false);
        session.invalidate();
        //TODO: REDIRECT
        try {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            //TODO: LOG !
            throw new CommandException(e);
        }
        return null;
    }
}
