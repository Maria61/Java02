package sort;

import heap.Heaps;

import java.util.Arrays;
import java.util.Random;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @program: VacationPractice2
 * @date 2019-08-28 9:57
 */
public class Sorts {
    public static void insertSortV1(int[] array){
        for(int i = 0; i < array.length; i++){
            int key = array[i+1];
            int j = 0;
            for(j = i; j >= 0; j--){
                if(key >= array[j]){
                    break;
                }
            }
            for(int k = i; k > j; k--){
                array[k+1] = array[k];
            }

        }

    }
    public static void insertSortV2(int[] array){
        /**
         * 默认下标为0的位置已经有序
         * 有序区间为[0,i]
         * 无序区间为[i+1,array.length-1]
         *
         * 每次取无序区间的第一个数key 与 有序区间的最后一个数 array[i] 比较
         *      1）如果 key >= array[i],即已经有序，无序交换位置
         *      2）否则 将比较的有序期间向后搬移一位，key 继续和 有序区间倒序比较，
         *      3）跳出条件：1）key > 有序区间的某一个数，记住下标
         *                 2）有序区间已经被遍历完了，下标为 -1，key依然 < 有序区间的数，
         *      4）最后将key插入到该下标的下一个位置
         *
         */

        for(int i = 0; i < array.length-1; i++){
            int key = array[i+1];
            int j = 0;
            for(j = i; j >= 0 && key < array[j]; j--){
              array[j+1] = array[j];
            }
            array[j+1] = key;
        }

    }

    private static void insertSortWithGap(int[] array,int gap){
        /**
         * 分组之后，每组的第i个数互相比较
         *
         * 从第二组的第i个数 key 开始和第一组的第i个数进行比较 ，
         *      1)如果 key小，则交换，
         *      2)否则不交换，继续第二组的第 i+1 个数和第一组的第 i+1 个数进行比较
         * 第二组比较完之后，用下一组的第 i 个数和第二组的第 i 个数比较，再和第一组的第 i 个数进行比较
         *
         */
        for(int i = 0; i < array.length - gap; i++){
            int key = array[i + gap];
            int j;
            for(j = i; j >= 0 && key < array[j]; j -= gap){
                array[j+gap] = array[j];
            }
            array[j+gap] = key;
        }
    }

    public static void shellSort(int[] array){
        int gap = array.length;
        while(true){
            gap = gap/3 + 1;
            insertSortWithGap(array, gap);
            if(gap == 1){
                return;
            }
        }
    }

    public static void selectSort(int[] array){
        /**
         * 每次选最大的数换到数组的后面
         *
         * 无序区间：[0,array.length - i)
         * 有序区间：[array.length - i,array.length)
         */
        for(int i = 0;i < array.length - 1 ; i++){
            int max = 0;
            for(int j = 1; j < array.length - i; j++){
                if(array[max] <= array[j]){
                    max = j;
                }
            }
            swap(array,max,array.length-i-1);
        }


    }

    private static void swap(int[] array,int i,int j){
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void heapSort(int[] array){
        /**
         *堆排序
         */
        Heaps.createHeap(array,array.length-1);
        for(int i = 0; i < array.length - 1; i++){
            swap(array,0,array.length - i - 1);
            Heaps.heapify(array,array.length,0);
        }
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            boolean sorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    swap(array,j,j + 1);
                    sorted = false;
                }

            }

            if(sorted == true){
                break;
            }
        }

    }

    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);
    }

    private static void quickSortInternal(int [] array,int left,int right){
        if(left >= right){
            return;
        }

        int priotIndex = partition1(array,left,right);

        quickSortInternal(array,left,priotIndex-1);
        quickSortInternal(array,priotIndex+1,right);
    }

    private static int partition1(int[] array,int left,int right){
//        int p = array[right];
//        int less = left;
//        int great = right;
//        while(less < great){
//            while(array[less] < p && less < great){
//                less++;
//            }
//            while(array[great] > p && great > less){
//                great--;
//            }
//            swap(array,array[less],array[right]);
//        }
//        array[less] = p;
//        return less;
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) {
                less++;
            }
            while (less < great && array[great] >= pivot) {
                great--;
            }
            swap(array, less, great);
        }
        swap(array, right, less);
        return less;
    }

    private static int partition2(int[] array,int left,int right){
        int p = array[right];
        int less = left;
        int great = right;
        while(less < great){
            while(array[less] < p && less < great){
                less++;
            }
            array[great] = array[less];
            while(array[great] > p && great > less){
                great--;
            }
            array[less] = array[great];
        }
        array[less] = p;
        return less;
    }

    private static int partition3(int[] array,int left,int right){
        int p = array[right];
        int less = left;//蓝色箭头
        for(int i = left; i < right; i++){//红色箭头
            if(array[i] < p){
                swap(array,i,less);
                less++;
            }
        }
        swap(array,less,right);
        return less;
    }

    private static int[] partition4(int[] array,int left,int right){
        return null;
    }

    private static int[] buildSortedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }

        return array;
    }

    private static int[] buildReversedSortedArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n - i;
        }

        return array;
    }

    private static int[] buildRandomArray(int n) {
        Random random = new Random(20190828);
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(n);
        }

        return array;
    }

    private static int[] buildEqualsArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = n;
        }

        return array;
    }


//    public static void main(String[] args) {
//        // 有序 | 无序 | 随机值 | 完全相等的
//        int[] array;
//
//        //array = buildReversedSortedArray(1000000);
//        //array = buildSortedArray(1000000);
//        array = buildRandomArray(10);
//        //array = buildEqualsArray(10);
//        System.out.println(Arrays.toString(array));
////        long begin = System.nanoTime();	// 纳秒
//        //insertSort(array);
//        //shellSort(array);
//        //selectSort(array);
//        //selectSortVersion2(array);
//        //heapSort(array);
//        quickSort(array);
////        long end = System.nanoTime();	// 纳秒
////        System.out.println(end - begin);
//        System.out.println(Arrays.toString(array));
//    }
    public static void main(String[] args) {
        // 有序 | 无序 | 随机值 | 完全相等的
        int[] array;

        array = buildRandomArray(10);
        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
