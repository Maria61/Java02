package library_management_system.exception;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/16 19:01
 */
public class NoBorrowedException extends Exception {
    public NoBorrowedException() {
    }

    public NoBorrowedException(String message) {
        super(message);
    }

    public NoBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBorrowedException(Throwable cause) {
        super(cause);
    }

    public NoBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
