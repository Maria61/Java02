package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/14 19:09
 */
class Test1004 {
    public static Test1004 a = new Test1004();
    public static Test1004 b = new Test1004();

    {
        System.out.println("构造代码块");
    }

    static {
        System.out.println("静态代码块");
    }
}

public class StaticDemo {
    public static void main(String[] args) {
        Test1004 t = new Test1004();
    }
}
