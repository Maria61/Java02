package algorithm_experiment;

import java.util.Arrays;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/16 14:33
 */

public class Experiment1016 {
    private static void swap(int i,int j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void bubbleSort(int[] array){
        for(int i = 0; i < array.length - 1; i ++){
            boolean flag = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1] ){
                    swap( j,j + 1, array);
                    flag = false;
                }
            }
            if(flag == true){
                break;
            }
        }
    }

    public static void selectSort(int[] array){

        for(int i = 0;i < array.length - 1; i++){
            int max = 0;
            for(int j = 1; j < array.length - i; j++){
                if(array[max] <= array[j]){
                    max = j;
                }
            }
            swap(max,array.length - i - 1,array);
        }

    }

    public static void insertSort(int[] array){
        for(int  i = 0; i < array.length - 1; i++){
            int key = array[i+1];
            int j = 0;
            for(j = i; j >= 0 && key <= array[j] ; j--){
                array[j+1] = array[j];
            }
            array[j+1] = key;
        }
    }

    public static void shellSort(int[] array ){
        int gap = array.length;
        while(true){
            gap = gap/3 + 1;
            insertSortWithGap(array,gap);
            if(gap == 1){
                return;
            }
        }
    }

    private static void insertSortWithGap(int[] array, int gap) {
        for(int i = 0; i < array.length - gap; i++){
            int key = array[i+gap];
            int j = 0;
            for(j = i; j >= 0 && key < array[j] ; j -= gap){
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }

    public static void quickSort(int[] array){
            quickSortInternal(array,0,array.length - 1);
    }

    private static void quickSortInternal(int[] array, int left, int right) {
        if(left > right){
            return;
        }
        int priotIndex = partition(array,left,right);
        quickSortInternal(array,left,priotIndex-1);
        quickSortInternal(array,priotIndex+1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int less = left;
        int great = right;
        int priot = array[right];
        while(less < great){
            while(less < great && array[less] <= priot){
                less++;
            }
            while(less < great && array[great] >= priot){
                great--;
            }
            swap(less,great,array);
        }
        swap(right,less,array);
        return less;
    }

    public static void mergeSort(int[] array){
        mergeSortInternal(array,0,array.length);
    }

    private static void mergeSortInternal(int[] array, int low, int high) {
        if(low + 1 >= high){
            return;
        }

        int mid = (low+high)/2;
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);
        merge(array,low,mid,high);

    }

    private static void merge(int[] array, int low, int mid, int high) {
        int lengh = high - low;
        int[] extra = new int[lengh];
        int  i = 0;
        int left = low;
        int right = high;

    }


    public static void testSort(){
        int[] array = {9,8,7,6,5};
//        bubbleSort(array);
//        selectSort(array);
//        insertSort(array);
//        shellSort(array);
//        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


    public static void main(String[] args) {
        testSort();
    }

}
