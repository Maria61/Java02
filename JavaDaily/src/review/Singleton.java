package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/28 21:55
 */

/**
 * 懒汉模式
 * 缺点：多线程下不安全
 */
class Singleton1{
    private Singleton1(){}
    //static 作用：静态的get方法中需要调用
    private static Singleton1 singleton1 = null;
    //static 作用：为了可以通过类名调用
    public static Singleton1 getSingleton1(){
        if(singleton1 == null){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

/**
 * 饿汉模式
 * 缺点：会造成资源浪费
 */
class Singleton2{
    private Singleton2(){}
    private static Singleton2 singleton2 = new Singleton2();
    public static Singleton2 getSingleton2(){
        return singleton2;
    }
}
class Singleton3{
    private Singleton3(){}
    private static Singleton3 singleton3;
}

public class Singleton {
    public static void main(String[] args) {
    }
}
