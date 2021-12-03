package application.exception;

public class InValidDateException extends Exception {
    public InValidDateException() {
    }

    public InValidDateException(String message) {
        super(message);
    }

    public InValidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InValidDateException(Throwable cause) {
        super(cause);
    }

    public InValidDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
