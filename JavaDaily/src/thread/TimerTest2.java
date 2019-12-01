package thread;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/1 14:43
 */
public class TimerTest2 {
    public static void main(String[] args) {
        MyTimer2 timer2 = new MyTimer2();
        timer2.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来了");
            }
        }, 0, 1000);
//        timer2.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我去");
//            }
//        },0,1000);
    }
}

class MyTimer2 {

    private static final PriorityBlockingQueue<Timer2Task> QUEUE
            = new PriorityBlockingQueue<>();

    public MyTimer2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Timer2Task timer2Task = QUEUE.take();//当前队列为空时，当前线程会发生阻塞
                        long current = System.currentTimeMillis();
                        if (timer2Task.getNext() > current) {
                            QUEUE.offer(timer2Task);
                            synchronized (QUEUE) {
                                QUEUE.wait(timer2Task.getNext() - current);
                            }
                        } else {
                            timer2Task.getTask().run();
                            if (timer2Task.getPeriod() > 0) {
                                //????
                                timer2Task.setNext(timer2Task.getNext() + timer2Task.getPeriod());
                                QUEUE.offer(timer2Task);
                            } else {
                                break;
                            }
                        }

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public void schedule(Runnable task, long delay, long period) {
        QUEUE.offer(new Timer2Task(task, delay, period));
        synchronized (QUEUE) {
            QUEUE.notify();
        }
    }
}

class Timer2Task implements Comparable<Timer2Task> {

    private Runnable task;
    //下次的任务执行时间
    private long next;
    //间隔时间
    private long period;

    public Timer2Task(Runnable task, long delay, long period) {
        this.task = task;
        this.next = System.currentTimeMillis() + delay;
        this.period = period;
    }

    @Override
    public int compareTo(Timer2Task o) {
        return Long.compare(this.next, o.next);
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }

    public long getNext() {
        return next;
    }

    public void setNext(long next) {
        this.next = next;
    }

    public long getPeriod() {
        return period;
    }

    public void setPeriod(long period) {
        this.period = period;
    }
}
