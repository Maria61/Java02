package addressbook.exception;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/19 12:10
 */
public class NoTelephoneException extends Exception {
    public NoTelephoneException() {
    }

    public NoTelephoneException(String message) {
        super(message);
    }

    public NoTelephoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoTelephoneException(Throwable cause) {
        super(cause);
    }

    public NoTelephoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
