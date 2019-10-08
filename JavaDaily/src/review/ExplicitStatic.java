package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/7 20:36
 */
class Parent {
    static {
        System.out.println("A");
    }
    static {
        System.out.println("B");
    }
}

public class ExplicitStatic extends Parent {
    private static int initB() {
        System.out.println(1);
        return 0;
    }

    static int a = initA();

    static {
        System.out.println(2);
    }

    static int b = initB();

    private static int initA() {
        System.out.println(3);
        return 0;
    }

    private static int initC() {
        System.out.println(5);
        return 0;
    }

    static {
        System.out.println(4);
    }

    public static void main(String[] args) {
        // 不会再触发类的加载，因为已经在内存中了
//        ExplicitStatic.a = 10;
//        System.out.println(a);
    }
}
