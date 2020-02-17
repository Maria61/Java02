package task;

import java.io.File;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Maria
 * @program everything-like
 * @date 2020/2/13 12:03
 */
public class FileScanner {

    /**
     * 1.corePoolSize：核心线程数，始终运行的线程
     * 2.maximumPoolSize：最大线程数，有新任务，并且当前运行线程数小于最大线程数，会创建新的线程来处理任务
     * 3.keepAliveTime:超过该数量时间
     * 4.3数量的时间单位，如果超过，2-1临时工线程会关闭
     * 5.工作的阻塞队列
     * 6.如果超出工作队列的长度，任务要处理的方法（4种策略）
     */
    private ThreadPoolExecutor pool = new ThreadPoolExecutor(
            3,3,0, TimeUnit.MICROSECONDS,
            new LinkedBlockingQueue<>(),new ThreadPoolExecutor.CallerRunsPolicy()
    );

    //线程安全的计数器，不传入参数默认值为0
    private volatile AtomicInteger count = new AtomicInteger();

    //线程等待的锁对象
    private Object lock = new Object();//方法1实现等待所有线程执行结束

    //方法2，设置初始值，用countDown()进行latch--,用await()等待latch直到为0
    private CountDownLatch latch = new CountDownLatch(1);
    //方法3，用release()颁发许可的方式，acquire()阻塞等待，当许可达到一定数量后阻塞等待结束
    private Semaphore semaphore = new Semaphore(0);

    private ScanCallback scanCallback;

    public FileScanner(ScanCallback scanCallback) {
        this.scanCallback = scanCallback;
    }

    /**
     * 扫描文件
     * @param path
     */
    public void scan(String path) {
        count.incrementAndGet();//++count;
        doScan(new File(path));
    }

    private void doScan(File dir){
        scanCallback.callback(dir);
        pool.execute(new Runnable() {//？？？这里为什么要用多线程
            @Override
            public void run() {
                try {
                    File[] children = dir.listFiles();//dir的下一级目录
                    if (children != null) {
                        for (File child : children) {
                            if (child.isDirectory()) {
//                                System.out.println("文件夹：" + child.getPath());
                                count.incrementAndGet();
                                doScan(child);
                            }
//                            else {
//                                System.out.println("文件：" + child);
//                            }
                        }
                    }
                }finally {
                    int r = count.decrementAndGet();//--count;
                    if (r == 0) {
//                        synchronized (lock) {
//                            lock.notify();
//                        }
//                        latch.countDown();
                        semaphore.release();
                    }
                }
            }
        });

    }

    /**
     * 等待扫描结束
     */
    public void waitFinish() throws InterruptedException {
//        synchronized (lock){
//            lock.wait();
//        }
//        latch.await();
        semaphore.acquire();
    }

    public static void main(String[] args) throws InterruptedException {
        Object obj;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (Thread.currentThread()) {
                    System.out.println(Thread.currentThread().getName());
                    Thread.currentThread().notifyAll();
                }
            }
        });
        thread.start();
        synchronized (Thread.currentThread()){
            Thread.currentThread().wait();
        }
        System.out.println(Thread.currentThread().getName());

    }
}