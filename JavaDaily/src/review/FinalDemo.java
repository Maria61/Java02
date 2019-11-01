package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/1 11:24
 */
final class Final {
    public void method() {
        System.out.println("普通方法");
    }

    public static final void method2() {
        System.out.println("最终方法");
    }
}

public class FinalDemo {
    public static void main(String[] args) {
        Final.method2();

    }

}
