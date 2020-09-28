package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/28 21:55
 */


/**
 * 饿汉模式
 * 缺点：会造成资源浪费
 */
class Singleton1{
    private Singleton1(){}
    //static 作用：静态的get方法中需要调用
    private static Singleton1 singleton1 = new Singleton1();
    //static 作用：为了可以通过类名调用
    public static Singleton1 getSingleton1(){
        return singleton1;
    }
}

/**
 * 懒汉模式
 * 缺点：多线程下不安全
 */
class Singleton2{
    private Singleton2(){}

    private static Singleton2 singleton2 = null;

    public static Singleton2 getSingleton2(){
        if(singleton2 == null){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }
}

/**
 * 双重校验锁
 * 缺点：存在指令重排序的缺点
 */
class Singleton3{
    private Singleton3(){}
    private static Singleton3 singleton3 = null;
    public static Singleton3 getSingleton3(){
        //第一次判断，如果singleton3不为空，直接返回，不需要去竞争获取锁资源，提高性能
        // 如果为空，才进行下一步，竞争锁资源，只有一个线程可以获取到资源，其他资源阻塞等待
        if(singleton3 == null){
            synchronized(Singleton3.class){
                //第二次判断，多线程情况下，一个线程运行完后会释放资源，其他线程获取到锁资源
                //其他线程获取到锁资源之后，判断如果对象不为空，则直接返回，如果没有这一次判断，其他线程还会继续创建对象
                if(singleton3 == null){
                    //实例化对象分为三步骤（23步骤顺序不固定）：
                    //1.分配内存空间
                    //2.初始化对象，对象不为空了
                    //3.返回地址给引用
                    //如果23步骤被JVM优化为32，将地址返回给引用，此时如果恰好有一个线程进入了第一个if判断，
                    //则会发现引用指向了一个内存地址，不为空，就会直接返回，但返回的实际是一个空的对象
                    //因此需要防止JVM对指令进行重排序，可用volatile修饰该对象
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}

/**
 * 双重校验锁（多线程安全版本）
 */
class Singleton4{
    private Singleton4(){}
    //volatile 作用：防止指令重排序
    private volatile static Singleton4 singleton4 = null;
    public static Singleton4 getSingleton4(){
        if(singleton4 == null){
            synchronized (Singleton4.class){
                if(singleton4 == null){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
public class Singleton {
    public static void main(String[] args) {
    }
}
