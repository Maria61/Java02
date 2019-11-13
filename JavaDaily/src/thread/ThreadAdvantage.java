package thread;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/10 9:28
 */
public class ThreadAdvantage {
    public static List<String> randomList() {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        List<String> list = new LinkedList<>();
        for (int i = 0; i < 100000; i++) {
            String s = new String();
            for (int j = 0; j < 3; j++) {
                int random = new Random().nextInt(chars.length);
                char c = chars[random];
                s += c;
            }
            list.add(s);
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        List<String> list = randomList();
        long start = System.currentTimeMillis();//时间戳
//        long start = new Date().getTime();//效果同上
        for (int i = 0; i < 10; i++) {
            final int k = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
//                        System.out.println(k);
                        list.get(k * 10000 + j);
                    }
                }
            }, "我的线程" + k);
            threads[i].start();
            System.out.println(threads[i].getName());
        }
        //线程让步  ?被再次调度到怎么办？
        //如果再次被调度到，仍然会进到while循环，判断当前线程数是否大于1
//        while(Thread.activeCount() > 1){
//            Thread.yield();//当前活跃线程数大于1时，main线程让步，重新回到就绪状态，
//        }
        //线程join   ?顺序遍历？
        //顺序遍历，但这些线程都是在之前同时start()的，顺序遍历时，当遍历到某线程时，有可能该线程已经结束
        for (Thread thread : threads) {
            thread.join();//该线程加入到JavaMain线程中，JavaMain线程阻塞
        }
        long end = System.currentTimeMillis();//main线程的时间
        System.out.println(end - start);
    }
}
