package review;

import java.util.concurrent.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/19 11:11
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        /**
         * Executors方式：
         */
        ExecutorService executorService1 = Executors.newCachedThreadPool();//线程数太大导致OOM
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);//请求队列太长导致OOM
        ExecutorService executorService3 = Executors.newScheduledThreadPool(3);//线程数太大导致OOM
        ExecutorService executorService4 = Executors.newSingleThreadScheduledExecutor();
        /**
         * ThreadPoolExecutor方式：
         */
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,5,60L, TimeUnit.MICROSECONDS,
                new LinkedBlockingQueue<>(),new ThreadPoolExecutor.AbortPolicy());
    }
}
