package thread;

import java.util.ArrayList;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/6 19:31
 */
public class ThreadDemo {
    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while (true) {

            }
        }
    }

    private static class MyRunner implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
            while (true) {

            }
        }
    }

    //javaMain（底层C语言）是java层面的主线程，
    // 和👇main方法是同级的
    public static void main(String[] args) throws InterruptedException {

        //创建10个线程，每个线程打印一个数字
//        int  i = 0;
//        while( i < 10){
//            final int j = i;
//            Runnable r = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(j);
//                }
//            };
//            Thread t = new Thread(r);
//            t.start();
//            i++;
//        }

        MyThread t = new MyThread();
        t.start();//(1)
        t.run();//(2)
        //注释掉(1)单独执行(2)的结果是main,
        // 因为此时只有main线程启动，打印的当前线程的名字即main,t没有启动，不会打印Thread-0
    }
}
