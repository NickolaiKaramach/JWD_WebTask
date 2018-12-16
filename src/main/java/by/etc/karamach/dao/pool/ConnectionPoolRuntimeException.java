package by.etc.karamach.dao.pool;

public class ConnectionPoolRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 811958468376841804L;

    public ConnectionPoolRuntimeException(String message) {
        super(message);
    }

    public ConnectionPoolRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConnectionPoolRuntimeException(Throwable cause) {
        super(cause);
    }
}
