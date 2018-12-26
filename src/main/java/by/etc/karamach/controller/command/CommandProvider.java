package by.etc.karamach.controller.command;

import by.etc.karamach.controller.command.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {

    private static final Logger logger = LogManager.getLogger();


    private static final CommandProvider instance = new CommandProvider();
    private final Map<CommandName, Command> repository = new HashMap<>();

    private final NoSuchCommand noSuchCommand = new NoSuchCommand();

    private CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.GET_TESTS, new GetTest());
        repository.put(CommandName.GET_MY_TESTS, new GetMyTest());
        repository.put(CommandName.CREATE_TEST, new CreateTest());
        repository.put(CommandName.LOGOUT, new Logout());
        repository.put(CommandName.DELETE_TEST, new DeleteTest());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String name) {
        CommandName commandName;
        Command command;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {

            logger.warn("No such command: " + name);

            command = noSuchCommand;
        }

        return command;
    }
}
