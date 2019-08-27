package heap;

import java.util.Arrays;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-27 10:06
 */
public class Heaps {


    private static void swap(int[] array,int index1,int index2){
        int t = array[index2];
        array[index2] = array[index1];
        array[index1] = t;
    }
    /**
     * 堆的向下调整(大顶堆)
     * @param array 存放堆得数组
     * @param size  数组的大小
     * @param index 要调整的位置的下标
     * 时间复杂度：O(log(n))
     */
    public static void heapify(int[] array,int size,int index){
        while(true){
            int left = index * 2 + 1;
            if(left >= size){
                return;
            }

            int max = left;
            if(left + 1 < size){
                if(array[left + 1] > array[left] ){
                    max = left + 1;
                }
            }

            if(array[max] < array[index]){
                return;
            }
            swap(array,index,max);
            index = max;
        }
    }

    public static void heapifyMin(int[] array,int size,int index){
        while(true){
            int left = index * 2 + 1;
            if(left >= size){
                return;
            }

            int min = left;
            if(left + 1 < size){
                if(array[left + 1] < array[left] ){
                    min = left + 1;
                }
            }

            if(array[index] <= array[min]){
                return;
            }
            swap(array,index,min);
            index = min;
        }
    }

    /**
     *
     * 建堆：任意数组转成堆
     *
     * 从最后一个非叶子结点开始，进行向下调整
     * 向下调整的范围  [ 最后一个非叶子结点 , 0]
     * 最后一个非叶子结点的下标: (size - 2)/2
     *
     * 时间复杂度:预估：O(n*log(n)) 精准计算：O(n)
     */

    public static void createHeap(int[] array,int size){
        int parent = (size - 2)/2;

        while(parent >= 0){
            heapify(array,size,parent);
            parent--;
        }
    }

    public static void createHeapMin(int[] array,int size){
        int parent = (size - 2)/2;

        while(parent >= 0){
            heapifyMin(array,size,parent);
            parent--;
        }
    }

    /**
     * 堆的向上调整
     * 时间复杂度：O(log(n))
     * @param array
     * @param index
     */
    public static void adjustUp(int[] array,int index){
        while(index > 0){
            int parent = (index - 1)/2;
            if(array[parent] >= array[index]){
                break;
            }
            swap(array,index,parent);
            index = parent;
        }
    }

    public static void main(String[] args) {
//        int[] array = { -1, 8, 4, 6, 7, 2, 3, 1, 0 };
//        heapify(array, array.length, 0);
//        System.out.println(Arrays.toString(array));
//        heapify(array, array.length, 0);
//        System.out.println(Arrays.toString(array));
        int[] array = { 3, 5, 2, 4, 9, 0, 1, 9, 8, 4, 7, 2, 3, 8, 6, 3 };
        createHeap(array, array.length);
        System.out.println(Arrays.toString(array));

    }



}
