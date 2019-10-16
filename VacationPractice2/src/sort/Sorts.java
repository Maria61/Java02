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
        Heaps.createHeap(array,array.length-2);
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

        int priotIndex = partition3(array,left,right);

        quickSortInternal(array,left,priotIndex-1);
        quickSortInternal(array,priotIndex+1,right);
    }

    private static int partition1(int[] array,int left,int right){
        /**
         *左右引用向中间靠，从左边开始遍历，遇到比基准值大的就停下来，
         * 然后从右边开始遍历，遇到比基准值小的，停下来，然后左右下标所指的值进行交换
         * 直到左边下标 >= 右边下标，遍历结束，将基准值与中间值进行交换
         */
        int pivot = array[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] <= pivot) { // 一定要加=
                less++;
            }
            while (less < great && array[great] >= pivot) {// 一定要加=
                great--;
            }
            swap(array, less, great);
        }
        swap(array, right, less);
        return less;
    }

    private static int partition2(int[] array,int left,int right){
        /**
         *填坑式：左右往中间靠，
         * 1）从左边开始，遇到比基准值大的就将其赋值给右边的引用
         * 2）右边开始遍历，遇到比基准值小的就将其赋值给左边的引用
         * 3）直到左右相遇，即遍历了整个数组，且只遍历了一遍，将基准值赋给中点
         */
        int p = array[right];
        int less = left;
        int great = right;
        while(less < great){
            while(array[less] <= p && less < great){
                less++;
            }
            array[great] = array[less];
            while(array[great] >= p && great > less){
                great--;
            }
            array[less] = array[great];
        }
        array[less] = p;
        return less;
    }

    private static int partition3(int[] array,int left,int right){
        /**
         *分别用两个引用（红色箭头，蓝色箭头）遍历
         *值小的部分：[0,蓝色箭头）
         *未知部分：[蓝色箭头，array.length-1]
         *用红色箭头进行依次遍历,
         *1）遇到比基准值小的就和蓝色箭头的值交换，交换后蓝色箭头向下走一步
         *2）遇到比基准值大的就继续走下一步，直到遇到比基准值小的和蓝色箭头交换
         *3）红色箭头遍历到最后一个就不用进行比较了，直接和蓝色箭头交换，结束！
         */
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
        /**
         * 特殊处理数组中值等于基准值的情况
         * 用less表示比基准值小的区间，[0,less)
         * 用great表示比基准值大的区间，[great,array.length-1]
         *  1)用 i 遍历，遇到与基准值相等的部分不做处理，继续遍历
         *  2)如果遇到比基准值小的，就与less指的值交换，并且i 和 less 一起下一步
         *  3)如果遇到比基准值大的,并且 i < great，
         *    great向左遍历，找到一个比基准值小的，然后和 i 交换
         *  4)直到 i 遍历完所有的数（不包括基准值），遍历结束，返回 less和 great-1 表示值相等的区间
         */

        int p = array[right];
        int less = left;
        int great = right;
        int i = left;

        while(i < right){
            if(array[i] == p){
                i++;
            }else if(array[i] < p){
                swap(array,i,less);
                i++;
                less++;
            }else{
                while(i < great && array[great] > p){
                    great--;
                }
                swap(array,i,great);
            }
        }
        return new int[]{less,great - 1};
    }

    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if(low + 1 >= high){
            return;
        }

        int mid = (low+high)/2;
        //[low,mid)
        //[mid,high)
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        /**
         * 原理类似于合并两个有序链表
         * 只是最后需要把新数组拷贝到原数组上
         */

        int length = high - low;
        int[] extra = new int[length];
        //[left,mid)
        //[mid,high)
        int i = 0;
        int left = low;
        int right = mid;
        while(left < mid && right < high){
            if(array[left] <= array[right]){
                extra [i] = array[left];
                i++;
                left++;
            }else{
                extra[i] = array[right];
                right++;
                i++;
            }
        }

        while(left < mid){
            extra[i++] = array[left++];
        }
        while(right < high){
            extra[i++] = array[right++];
        }

        for(i = 0; i < length;i++){
            array[low + i] = extra[i];
        }
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
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
