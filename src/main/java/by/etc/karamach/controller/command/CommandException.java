package by.etc.karamach.controller.command;

public class CommandException extends Exception {
    private static final long serialVersionUID = -4689934436032875236L;

    private String message;

    public CommandException() {
        super();
    }

    public CommandException(String message) {
        super(message);
        this.message = message;
    }

    public CommandException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public CommandException(Throwable cause) {
        super(cause);
        message = cause.getMessage();

    }

    @Override
    public String getMessage() {
        return message;
    }
}
