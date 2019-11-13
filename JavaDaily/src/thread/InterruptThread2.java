package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/13 19:36
 */
public class InterruptThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
//                while(!Thread.currentThread().isInterrupted()){
                while (!Thread.interrupted()) {//效果同上
                    System.out.println("运行中");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
//                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        thread.sleep(1000);
        thread.interrupt();//修改标志位为true
    }
}
