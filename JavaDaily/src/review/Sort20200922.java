package review;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/22 9:20
 */
public class Sort20200922 {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡排序（稳定）O(n2)
     * 相邻两元素依次进行比较，将大的向后置换，直至末尾，在依次遍历剩下的部分，找出剩余部分最大的并置换至末尾。。。
     * @param arr
     */
    public static void bubbleSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            boolean flag = false;
            for(int j = 0; j <arr.length - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    flag = true;
                    swap(arr,j,j+1);
                }
            }
            if(flag == false) {
                break;
            }
        }
    }

    /**
     * 快速排序（不稳定）O(nlogn)
     * 思路：选择最右边的为基准，左右两个引用分别向中间遍历，直到相遇为止，
     * 遍历时左边引用发现了比基准大的元素即停下，右边发现比基准小的即停下，左右两个引用的元素交换，继续遍历
     * 一遍遍历完成后，将基准换至左右引用相遇的位置
     * 左右两部分分别继续从头开始遍历
     * @param arr
     */
    public static void quickSort(int[] arr){
        quickSortIntenel(arr,0,arr.length - 1);
    }

    private static void quickSortIntenel(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int key = arr[j];
        while(i < j){
            while(i < j && arr[i] <= key){
                i++;
            }
            while(i < j && arr[j] >= key){
                j--;
            }
            if(i < j){
                swap(arr,i,j);
            }
        }
        arr[right] = arr[j];//此时arr[j]一定大于key
        arr[j] = key;
        quickSortIntenel(arr,left,j - 1);
        quickSortIntenel(arr,j + 1,right);
    }

    /**
     * 选择排序（不稳定）O(n2)
     * 思路：在待排序列中找出最小的放到已派序列的末尾
     * 假定待排序列中第一个是最小的，在剩下的序列中找最小的，找到后与第一个进行对比，小则交换，否则不交换
     * @param arr
     */
    public static void selectSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            int temp = i;
            for(int j = i+1; j < arr.length; j++){
                if(min > arr[j]){
                    min = arr[j];
                    temp = j;
                }
            }
            if(min < arr[i]){
                swap(arr,i,temp);
            }
        }
    }

    /**
     * 插入排序（稳定）O(n2)
     * 取出待排序列中的第一个元素，将其与有序序列从后向前比较，
     * 如果该元素值小于有序序列元素，则将有序序列元素向后移动，
     * 直到该元素大于有序序列元素，则将该元素赋值到有序序列元素的下一个（下一个已经提前被移动到后面了）
     * @param arr
     */
    public static void insertSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int temp = arr[i];
            int j = i - 1;
            for(; j >= 0 && arr[j] > temp; j--){
                arr[j + 1] = arr[j];
            }
            arr[j+1] = temp;//经过循环此时arr[j+1]已经被提前移动到了下一个位置
        }
    }

    /**
     * 希尔排序（不稳定）O(nlogn)
     * @param arr
     */
    public static void shell(int[] arr){
        for(int grap = arr.length/2; grap > 0; grap /= 2){
            for(int i = grap; i < arr.length; i++){
                for(int j = i - grap; j >= 0; j -= grap){
                    if(arr[j] > arr[j + grap]){
                        swap(arr,j,j+grap);
                    }
                }
            }
        }
    }

    public static void mergeSort(int[] arr){

    }

    public static void main(String[] args) {
        int[] arr = {-1,-1,-2,5,4,3,5,0,2,1};
//        int[] arr = {1,2,3,4,5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
