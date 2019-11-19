package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/17 20:24
 */
public class Sington {
    //分配好内存大小，对象就不为空
    //创建对象的三个步骤：
    //1.分配内存空间
    //2.对象的初始化
    //3.把变量指向这个对象

//    DCL机制 ：double check locking

    private static Sington SINDTON;
    //添加volatile关键字，建立内存屏障，禁止了指令重排序，保证可见性和有序性
    private volatile static Sington SINDTON2;

    public static Sington getInstance() {
        if (SINDTON2 == null) {
            synchronized (Sington.class) {
                if (SINDTON2 == null) {
                    SINDTON2 = new Sington();
                }
            }
        }
        return SINDTON2;
    }

}
