import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/14 11:12
 */
public class WaitTest {

    /**
     * 等待所有线程执行完毕：
     * 1.CountDownLatch：初始化一个数值，可以countDown()对数值进行i--操作，await()阻塞等待直到i==0
     * 2.Semaphore：release()进行一定数量许可证的颁发。acquire()阻塞并等待一定数量的许可证，达到数量后阻塞等待结束。
     *      * 相对来说，semaphore功能更强大，也更灵活一点
     * @param args
     */

    private static int COUNT = 5;
    private static CountDownLatch  LATCH = new CountDownLatch(COUNT);
    private static Semaphore  sp = new Semaphore(0);

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < COUNT; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
//                    LATCH.countDown();
                    sp.release(1);
                }
            }).start();
        }
//        LATCH.await();
        sp.acquire(5);
        System.out.println(Thread.currentThread().getName());

    }
}
