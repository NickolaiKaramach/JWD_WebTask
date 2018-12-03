package by.etc.karamach.controller.command.impl;

import by.etc.karamach.controller.command.Command;
import by.etc.karamach.controller.command.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WrongRequest implements Command {
    @Override
    public String executeTask(HttpServletRequest req, HttpServletResponse resp) throws CommandException {
        throw new CommandException("No such command!");
    }

}
