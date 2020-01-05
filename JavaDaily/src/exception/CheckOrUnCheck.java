package exception;

import java.io.IOException;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/21 23:07
 */
public class CheckOrUnCheck {
    public static void methodA() {
        //受查异常，不需要做额外处理
        throw new ArrayIndexOutOfBoundsException();
    }

    //非受查异常，需要进行额外处理--try-catch/throws
    public static void methodB() throws IOException {
        throw new IOException();
    }
}
