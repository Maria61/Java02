package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/22 18:50
 */
public class TenABC {
    private static String INDEX = "A";

    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (TenABC.class) {
                            while (!(INDEX == "A")) {
                                TenABC.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX = "B";
                            TenABC.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (TenABC.class) {
                            while (!(INDEX == "B")) {
                                TenABC.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX = "C";
                            TenABC.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        synchronized (TenABC.class) {
                            while (!(INDEX == "C")) {
                                TenABC.class.wait();
                            }
                            System.out.println(INDEX);
                            INDEX = "A";
                            TenABC.class.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        a.start();
        b.start();
        c.start();
    }
}
