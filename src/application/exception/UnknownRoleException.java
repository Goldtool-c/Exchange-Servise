package application.exception;

public class UnknownRoleException extends Exception {
    public UnknownRoleException() {
    }

    public UnknownRoleException(String message) {
        super(message);
    }

    public UnknownRoleException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownRoleException(Throwable cause) {
        super(cause);
    }
}
