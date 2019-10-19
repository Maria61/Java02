package addressbook.exception;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/19 11:24
 */
public class NoPersonException extends Exception {
    public NoPersonException() {
    }

    public NoPersonException(String message) {
        super(message);
    }

    public NoPersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPersonException(Throwable cause) {
        super(cause);
    }

    public NoPersonException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
