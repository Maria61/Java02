package heap;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-27 15:58
 */
public class MyPriorityQueue {
    //暂不考虑数组容量不足问题
    private int[] array = new int[100];
    private int size = 0;

    public void add(int element){
        array[size++] = element;
        Heaps.adjustUp(array,size - 1);
    }

    public int poll(){
        int e = array[0];
        array[0] = array[--size];
        Heaps.heapify(array, size, 0);
        return e;
    }

    public int peek(){
        return array[0];
    }
}
