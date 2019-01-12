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
        repository.put(CommandName.TAKE_TESTS, new TakeTests());
        repository.put(CommandName.TAKE_MY_TESTS, new TakeMyTest());
        repository.put(CommandName.CREATE_TEST, new CreateTest());
        repository.put(CommandName.LOGOUT, new Logout());
        repository.put(CommandName.DELETE_TEST, new DeleteTest());
        repository.put(CommandName.EDIT_TEST, new EditTest());
        repository.put(CommandName.EDIT_QUESTION, new EditQuestion());
        repository.put(CommandName.DELETE_QUESTION, new DeleteQuestion());
        repository.put(CommandName.EDIT_ANSWER, new EditAnswer());
        repository.put(CommandName.UPDATE_ANSWER, new UpdateAnswer());
        repository.put(CommandName.CREATE_ANSWER, new CreateAnswer());
        repository.put(CommandName.DELETE_ANSWER, new DeleteAnswer());
        repository.put(CommandName.CHANGE_QUESTION_NAME, new ChangeQuestionName());
        repository.put(CommandName.CREATE_QUESTION, new CreateQuestion());
        repository.put(CommandName.CHANGE_TEST_NAME, new ChangeTestName());
        repository.put(CommandName.PUBLISH_TEST, new PublishTest());
        repository.put(CommandName.PREPARE_FOR_TEST, new PrepareForTest());
        repository.put(CommandName.START_TEST, new StartTest());
        repository.put(CommandName.MAKE_CHOICE, new MakeChoice());
        repository.put(CommandName.TAKE_NEXT_QUESTION, new TakeNextQuestion());
        repository.put(CommandName.FINISH_TEST, new FinishTest());
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
