package review;


/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/14 20:36
 */
class OverloadTest {
    public static void method(String s, int a) {
        System.out.println("方法1");
    }

    public static void method(int a, String s) {
        System.out.println("方法2");
    }

    //构造方法的重载应用较多
    OverloadTest(int v, String s) {
        System.out.println("构造方法1");
    }

    OverloadTest(String s, int v) {
        System.out.println("构造方法2");
    }
}

class OverrideTest {
    public void method() {
        System.out.println("父类的方法");
    }

    public static void method(int a) {
        System.out.println("父类的静态方法");
    }
}

class Son extends OverrideTest {
    @Override//子类重写父类方法时可以加上这个注解，自动帮你校验重写格式是否正确
    public void method() {
        System.out.println("子类重写的方法");
    }

    public static void method(int a) {
        System.out.println("子类静态方法");
    }

    protected static void methodB() {
        System.out.println("子类的方法");
    }
}

public class OverrideOrOverloadDemo {
    public static void main(String[] args) {
//        new OverrideTest().method();
//        new Son().method();
        OverrideTest ot = new Son();
//        ot.methodB();//以引用为准，引用为OverrideTest，该类中的没有方法methodB()，因此会报编译错误
        ot.method();//当子类重写了父类的方法时，调用子类的重写的方法
        //调用静态方法时，以引用类型为准
        ot.method(1);
    }
}
