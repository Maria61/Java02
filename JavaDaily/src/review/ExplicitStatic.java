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

class Parent2 {
    {
        System.out.println("父类  构造代码块1");//3
    }


    Parent2() {
        System.out.println("父类  的无参构造方法");//5
    }

    static {
        System.out.println("父类  的静态代码块1");//1
    }

    {
        System.out.println("父类  构造代码块2");//4
    }

    static {
        System.out.println("父类  的静态代码块2");//2
    }
}

public class ExplicitStatic extends Parent2 {

    static {
        System.out.println("子类  的静态代码块1");
    }

    ExplicitStatic() {
        super();
        System.out.println("子类  无参构造方法");
    }

    ExplicitStatic(int v) {
        this();
        System.out.println("子类  有参构造方法");
    }

    private int initA() {
        System.out.println("子类  的普通方法A");
        return 0;
    }

    static {
        System.out.println("子类  的静态代码块2");
    }

    private int initB() {
        System.out.println("子类  的普通方法B");
        return 0;
    }

    int a = initA();//5

    {
        System.out.println("子类  的构造代码块1");//6
    }

    int b = initB();//7

    {
        System.out.println("子类  的构造代码块2");//8
    }

    public void method() {
        {
            System.out.println("子类  的普通代码块1");
        }
        System.out.println("子类  的普通方法method");
        {
            System.out.println("子类  的普通代码块2");
        }
    }

    public static void main(String[] args) {
        new ExplicitStatic(100);
        System.out.println("=================");
        new ExplicitStatic().method();
    }


}

//public class ExplicitStatic extends Parent {
//    private static int initB() {
//        System.out.println(1);
//        return 0;
//    }
//
//    static int a = initA();
//
//    static {
//        System.out.println(2);
//    }
//
//    static int b = initB();
//
//    private static int initA() {
//        System.out.println(3);
//        return 0;
//    }
//
//    private static int initC() {
//        System.out.println(5);
//        return 0;
//    }
//
//    static {
//        System.out.println(4);
//    }

//    public static void main(String[] args) {
//        // 不会再触发类的加载，因为已经在内存中了
////        ExplicitStatic.a = 10;
////        System.out.println(a);
//    }
//}
