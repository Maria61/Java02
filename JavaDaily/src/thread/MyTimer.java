package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/28 21:14
 */
public class MyTimer {
    public void schedule(Runnable task,
                         long delay, long period) {
        long next = System.currentTimeMillis() + delay;
        while (true) {
            try {
                long current = System.currentTimeMillis();
                if (next > current) {
                    Thread.sleep(next - current);
                } else {
                    System.out.println(System.currentTimeMillis());
                    if (period > 0) {
                        next += period;
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Runnable task = null;
        new Thread(new Runnable() {
            @Override
            public void run() {
                new MyTimer().schedule(task, 1000, 100);
            }
        }).start();
    }
}
