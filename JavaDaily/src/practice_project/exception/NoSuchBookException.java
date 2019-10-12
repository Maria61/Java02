package practice_project.exception;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 20:55
 */
public class NoSuchBookException extends Exception {
    public NoSuchBookException() {
    }

    public NoSuchBookException(String message) {
        super(message);
    }

    public NoSuchBookException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchBookException(Throwable cause) {
        super(cause);
    }

    public NoSuchBookException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
