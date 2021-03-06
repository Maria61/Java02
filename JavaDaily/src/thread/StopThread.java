package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/10 11:34
 */
public class StopThread {
    /**
     * 是否被中断，默认没有中断
     */
    private static volatile boolean myInterrupted = true;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!myInterrupted) {
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(5000);
        myInterrupted = true;
    }
}
