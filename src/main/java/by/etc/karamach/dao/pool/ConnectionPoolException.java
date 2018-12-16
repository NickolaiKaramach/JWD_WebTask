package by.etc.karamach.dao.pool;

public class ConnectionPoolException extends Exception {
    private static final long serialVersionUID = 6413463092533634864L;

    public ConnectionPoolException() {
        super();
    }

    public ConnectionPoolException(String message) {
        super(message);
    }

    public ConnectionPoolException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolException(Throwable cause) {
        super(cause);
    }
}
