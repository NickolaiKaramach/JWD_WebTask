package by.etc.karamach.controller.command;

import by.etc.karamach.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
    private static final CommandProvider instance = new CommandProvider();
    private final Map<CommandName, Command> repository = new HashMap<>();

    private CommandProvider() {
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Registration());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
        repository.put(CommandName.GET_TESTS, new GetTest());
        repository.put(CommandName.GET_MY_TESTS, new GetMyTest());
        repository.put(CommandName.CREATE_TEST, new CreateTest());
    }

    public static CommandProvider getInstance() {
        return instance;
    }

    public Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            //TODO: Log !
            command = repository.get(CommandName.WRONG_REQUEST);
        }

        return command;
    }
}
