package advance.thread;

import java.util.concurrent.*;


/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/22 22:16
 */
public class CallableRun {
    public static void test1() throws ExecutionException, InterruptedException {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName()+" :call ");
                return 1;
            }
        };
        FutureTask<Integer> task = new FutureTask<>(callable);
        new Thread(task).start();
        System.out.println(Thread.currentThread().getName()+"：子线程run before get()");
        System.out.println(Thread.currentThread().getName()+task.get());
        System.out.println(Thread.currentThread().getName()+"：子线程run after get()");
    }

    public static void test2() throws ExecutionException, InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(4);
//        ThreadPoolExecutor pool = new ThreadPoolExecutor();
        Future future = pool.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                System.out.println(Thread.currentThread().getName()+" :call ");
                return "call finish";
            }
        });
        System.out.println(Thread.currentThread().getName()+"：子线程run before get()");
        System.out.println(Thread.currentThread().getName()+future.get());
    }

    public static void main(String[] args) throws Exception {
//        test1();
        test2();
    }
}
