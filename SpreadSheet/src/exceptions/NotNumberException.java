package exceptions;

public class NotNumberException extends Exception{

    public NotNumberException() {
        super();
    }

    public NotNumberException(String message) {
        super(message);
    }

    public NotNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotNumberException(Throwable cause) {
        super(cause);
    }

    protected NotNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
