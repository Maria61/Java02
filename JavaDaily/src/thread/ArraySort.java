package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/19 18:42
 */
public class ArraySort implements Runnable {
    private int num;

    public ArraySort(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(this.num);
            System.out.println(this.num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int[] num = {10, 2, 8, 3, 5};
        for (int i = 0; i < num.length; i++) {
            new Thread(new ArraySort(num[i])).start();
        }
    }
}
