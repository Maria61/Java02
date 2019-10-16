package practice_project.exception;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/16 13:27
 */
public class BorrowOutException extends Exception {
    public BorrowOutException() {
    }

    public BorrowOutException(String message) {
        super(message);
    }

    public BorrowOutException(String message, Throwable cause) {
        super(message, cause);
    }

    public BorrowOutException(Throwable cause) {
        super(cause);
    }

    public BorrowOutException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
