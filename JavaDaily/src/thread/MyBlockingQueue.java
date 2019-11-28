package thread;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/28 19:26
 */
public class MyBlockingQueue<E> {
    private Object[] elements;
    private int addIndex;
    private int takeIndex;
    private int size;

    public MyBlockingQueue(int capacity) {
        elements = new Object[capacity];
    }

    public synchronized E poll() {
        E e = null;
        try {
            while (size == 0) {
                wait();
            }
            e = (E) elements[takeIndex];
            takeIndex = (takeIndex + 1) % elements.length;
            size--;
            notifyAll();
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
        return e;
    }

    public synchronized void offer() {

    }
}
