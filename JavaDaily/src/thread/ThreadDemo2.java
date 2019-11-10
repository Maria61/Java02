package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/10 9:10
 */
public class ThreadDemo2 {
    public static void main(String[] args) throws InterruptedException {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("匿名类");
//            }
//        }).start();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名类");
            }
        });
        thread.start();
        thread.join();//thread线程会加入JavaMain线程，等待thread线程死亡后JavaMain再执行，此时JavaMain线程进入阻塞状态
        System.out.println("main方法的打印");//不调用join(),经常先执行，因为上面的线程在系统中创建耗时较长，而此时JavaMain线程已经创建好了开始调度了
        new Thread(() -> System.out.println("表达式")).start();

    }
}
