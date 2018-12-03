package by.etc.karamach.dao;

public class DAOException extends Exception {
    private static final long serialVersionUID = -4949127857564044040L;

    public DAOException() {
        super();
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
}
