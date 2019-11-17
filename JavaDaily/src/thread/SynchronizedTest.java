package thread;


/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/17 20:01
 */

class MyObj {
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }
}

public class SynchronizedTest {
    public synchronized static void method1() {
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }

    public synchronized static void method2() {
        System.out.println(Thread.currentThread().getName());
        while (true) {

        }
    }


    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                method1();
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                method2();
//            }
//        }).start();
        MyObj object1 = new MyObj();
        MyObj object2 = new MyObj();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                object1.method1();
                //上下两种写法效果相同
//                synchronized (object1){
//                    System.out.println(Thread.currentThread().getName());
//                    while(true){
//
//                    }
//                }
                method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                object2.method2();
//                synchronized (object2){
//                    System.out.println(Thread.currentThread().getName());
//                    while(true){
//
//                    }
//                }
                method2();
            }
        }).start();

    }
}
