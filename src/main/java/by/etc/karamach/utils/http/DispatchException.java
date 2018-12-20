package by.etc.karamach.utils.http;

public class DispatchException extends Exception {

    private static final long serialVersionUID = 1677661827547839010L;

    public DispatchException() {
        super();
    }

    public DispatchException(String message) {
        super(message);
    }

    public DispatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public DispatchException(Throwable cause) {
        super(cause);
    }
}
