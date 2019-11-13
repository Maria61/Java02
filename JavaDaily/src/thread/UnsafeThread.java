package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/13 20:13
 */
public class UnsafeThread {
    public static int COUNT;

    public static void main(String[] args) {
//        for(int i = 0; i < 20; i++){
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i = 0; i < 10000; i++){
//                        COUNT++;
//                    }
//                }
//            }).start();
//
//        }
//        while(Thread.activeCount() > 1){
//            Thread.yield();
//        }
//        System.out.println(COUNT);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int k = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
//                        COUNT++;
                        list.add(k * 10000 + j);
                    }
                }
            }).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(list);
    }
}
