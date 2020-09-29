package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/29 23:37
 */
public class TwoThreadPrint {
    private static Object object = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    for(int i = 1; i <= 10; i += 2){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        object.notify();//???
                        try {
                            object.wait();//???
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    for(int i = 2; i <= 10; i += 2){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                        object.notify();//???
                        try {
                            object.wait();//???
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
