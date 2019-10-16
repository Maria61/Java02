package practice_project.exception;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/16 13:27
 */
public class YetBorrowedException extends Exception{
    public YetBorrowedException() {
    }

    public YetBorrowedException(String message) {
        super(message);
    }

    public YetBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public YetBorrowedException(Throwable cause) {
        super(cause);
    }

    public YetBorrowedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
