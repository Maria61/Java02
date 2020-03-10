package exception;

/**
 * @author Maria
 * @program servletblog
 * @date 2020/3/10 11:17
 */
public class SystemException extends BaseException {
    public SystemException(String code, String message) {
        super(code, message);
    }

    public SystemException( String code, String message,Throwable cause) {
        super(code, message,cause);
    }
}
