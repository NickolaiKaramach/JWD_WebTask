package by.etc.karamach.service;

public class ServiceException extends Exception {
    private static final long serialVersionUID = 1705604319010526597L;

    private String message;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public ServiceException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }
}
