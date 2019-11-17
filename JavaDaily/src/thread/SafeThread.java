package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/17 19:12
 */
public class SafeThread {
    public static int COUNT;

    //静态同步方法
    //该锁的对象是类
    public synchronized static void increment() {
        COUNT++;
    }

    public synchronized static void decrement() {
        COUNT--;
    }

    //同步代码块
    //获取类对象的锁
//    public static void increment(){
//        synchronized (SafeThread.class){
//            COUNT++;
//        }
//    }
    public static void main(String[] args) {
        Object object = new Object();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
//                        COUNT++;
                        //类对象的锁定
                        increment();
//                        decrement();
                        //实例对象的锁定
//                        synchronized (object){
//                            COUNT++;
//                        }
                    }
                }
            }).start();

        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(COUNT);

//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            int k = i;
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for (int j = 0; j < 10000; j++) {
////                        COUNT++;
//                        list.add(k * 10000 + j);
//                    }
//                }
//            }).start();
//        }
//        while (Thread.activeCount() > 1) {
//            Thread.yield();
//        }
//        System.out.println(list);
    }
}
