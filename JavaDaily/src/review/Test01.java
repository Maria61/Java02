package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/11 23:13
 */
class Test02 {
    {
        System.out.println("我是 父类 构造代码块");
    }
}

public class Test01 extends Test02 {


    {
        System.out.println("我是 子类 构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public void method() {
        {
            System.out.println("普通代码块1");
        }

        System.out.println("普通方法体");

        {
            System.out.println("普通代码块2");
        }
    }

    public static void main(String[] args) {
        new Test01();
        System.out.println("===================华丽的分割线===================");
        new Test01().method();

    }
}
