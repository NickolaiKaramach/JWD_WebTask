package by.etc.karamach.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
    String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException;
}
