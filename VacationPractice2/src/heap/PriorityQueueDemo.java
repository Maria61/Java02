package heap;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-27 15:47
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue1 = new PriorityQueue<>();
        Queue<Integer> queue2 = new LinkedList<>();
        Random random = new Random(20190827);
        for(int i = 0; i < 10; i++){
            int n = random.nextInt(100);
            ((LinkedList<Integer>) queue2).add(n);
            queue1.add(n);
        }
        while(!queue1.isEmpty()){
            System.out.print(queue1.poll()+",");
        }
        System.out.println("\n------------------------");
        while(!queue2.isEmpty()){
            System.out.print(queue2.poll()+",");
        }

    }
}
