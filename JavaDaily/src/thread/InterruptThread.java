package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/10 11:50
 */
public class InterruptThread {
    public static void main(String[] args) {
        /**
         * 当线程处于阻塞状态时，中断方法interrupt()起作用
         */
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    /**
//                     * 调用sleep()/wait()/join()方法，使线程进入阻塞状态
//                     */
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {//抛出异常之后标志位重置为false
//                    e.printStackTrace();
//                }
//                for(int i = 0; i < 5; i++){
//                    System.out.println(Thread.currentThread().isInterrupted());
//                }
//            }
//        });
//        thread.start();
//        thread.interrupt();//可以中断执行sleep()/wait()/join()方法后正在阻塞的线程,修改标志位为true

//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//
//                }
//            }
//        });
//        thread2.start();
//        thread2.interrupt();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    boolean b = Thread.interrupted();//重置标志位为false,并返回重置之前的标志位
//                    boolean b = Thread.currentThread().isInterrupted();
                    System.out.println(b);
                }
            }
        });//线程创建后标志位为false
        thread3.start();
        thread3.interrupt();//修改标志位为true
        //当Thread对象在java层面创建好之后就可以调用相应的实例方法，
        //我们之前说的创建线程很慢，是系统层级的创建，是在完善对象涉及到的本地方法的相关初始化，
        // 在系统层级创建线程时，java层级的对象已经创建好了


//        将字符串加入到常量池也是创建了一个对象？是

    }
}
