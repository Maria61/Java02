package task;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

    /**
     * 扫描文件
     * @param path
     */
    public void scan(String path) {
        doScan(new File(path));
    }

    private void doScan(File dir){
        pool.execute(new Runnable() {
            @Override
            public void run() {
                File[] children = dir.listFiles();//dir的下一级目录
                if(children != null){
                    for(File child : children){
                        if(child.isDirectory()){
                            System.out.println("文件夹："+child.getPath());
                            doScan(child);
                        }else{
                            System.out.println("文件："+child);
                        }
                    }
                }
            }
        });

    }

    /**
     * 等待扫描结束
     */
    public void waitFinish(){

    }
}
