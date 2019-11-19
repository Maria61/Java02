package thread;

import javax.xml.soap.Node;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/19 19:55
 */
public class Notify {
    /**
     * 生产者与消费者模型：
     */

    private static volatile int COUNT = 0;

    public synchronized static void product() {
        COUNT += 3;
    }

    public synchronized static void consume() {
        COUNT--;
    }

    public static void main(String[] args) {

        //生产者3个
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //每天工作10小时
                    try {
                        for (int j = 0; j < 10; j++) {
                            synchronized (Notify.class) {
//                                if(COUNT + 3 >100){
                                while (COUNT + 3 > 100) {
                                    Notify.class.wait();
                                }
                                product();
                                System.out.println(Thread.currentThread().getName()
                                        + "生产，库存总量位：" + COUNT);
                                Thread.sleep(500);
                                Notify.class.notifyAll();
                            }
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        //消费者10个
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            synchronized (Notify.class) {
//                                if(COUNT == 0){
                                while (COUNT == 0) {
                                    Notify.class.wait();//释放锁,当前线程进入等待状态
                                }
                                consume();
                                System.out.println(Thread.currentThread().getName()
                                        + "消费，库存总量位：" + COUNT);
                                Thread.sleep(500);
                                Notify.class.notifyAll();
                            }
                            Thread.sleep(500);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }


}
