package by.etc.karamach.dao;

public class DAOException extends Exception {
    private static final long serialVersionUID = -4949127857564044040L;

    private String message;


    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
        this.message = message;
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
        this.message = message;
    }

    public DAOException(Throwable cause) {
        super(cause);
        this.message = cause.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }
}
