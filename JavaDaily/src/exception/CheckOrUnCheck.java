package exception;

import java.io.IOException;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/21 23:07
 */
public class CheckOrUnCheck {
    public static void methodA() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void methodB() throws IOException {
        throw new IOException();
    }
}
