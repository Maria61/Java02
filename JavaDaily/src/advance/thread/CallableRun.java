package advance.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

    public static void main(String[] args) throws Exception {
        test1();
    }
}
