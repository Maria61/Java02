package heap;

import java.util.Arrays;
import java.util.Random;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-27 16:08
 */
public class TopKDemo{
    private static int[] findTopK(int[] wulin,int k){
        int [] heap = new int[k];
        for(int i = 0; i < k; i++ ){
            heap[i] = wulin[i];
        }

        Heaps.createHeapMin(heap,heap.length);

        for(int i = k; i < wulin.length; i++){
            if(wulin[i] > heap[0]){
                heap[0] = wulin[i];
                Heaps.heapifyMin(heap,heap.length,0);
            }
        }
        return heap;
    }

    public static void main(String[] args) {
        Random random = new Random(162800);
        int[] wulin = new int[100];
        for(int i = 0; i < wulin.length; i++){
            wulin[i] = random.nextInt(1000);
        }

        int[] topK = findTopK(wulin,5);
        System.out.println(Arrays.toString(topK));
        Arrays.sort(wulin);
        System.out.println(Arrays.toString(Arrays.copyOfRange(wulin,wulin.length-10,wulin.length)));

    }
}
