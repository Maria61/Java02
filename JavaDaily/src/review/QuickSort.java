package review;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/26 18:07
 */
public class QuickSort {
    public static void quickSort(int[] array) {
        quickSortIntenel(array, 0, array.length - 1);
    }

    private static void quickSortIntenel(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        quickSortIntenel(array, left, p - 1);
        quickSortIntenel(array, p + 1, right);
    }

    private static int partition(int[] array, int left, int right) {
        int less = left;
        int great = right;
        int p = array[right];
        while (less < great) {
            while (less < great && array[less] <= p) {
                less++;
            }
            while (less < great && array[great] >= p) {
                great--;
            }
            if(less < great){
                int t = array[less];
                array[less] = array[great];
                array[great] = t;
            }
        }
        int t = array[right];
        array[right] = array[great];
        array[great] = t;

        return less;
    }



    public static void main(String[] args) {
        int[] array = {3, 4, 2, 6, 5, 1, 8, 3};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
