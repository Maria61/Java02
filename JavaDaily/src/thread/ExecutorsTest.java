package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/28 19:58
 */
//线程池
public class ExecutorsTest {
    private static final ExecutorService EXE
            = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            final int j = i;
            EXE.submit(new Runnable() {
                @Override
                public void run() {
//                    System.out.println("ABC");
                    while (true) {
                        System.out.println(j);
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        EXE.shutdown();
    }


}
