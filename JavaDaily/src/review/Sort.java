package review;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/2 22:04
 */
public class Sort {
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array) {
        quickSortInternal(array, 0, array.length - 1);
    }

    private static void quickSortInternal(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        quickSortInternal(array, left, p - 1);
        quickSortInternal(array, p + 1, right);

    }

    private static int partition(int[] array, int left, int right) {
        int p = array[right];
        int less = left;
        int great = right;
        while (less < great) {
            while (less < great && array[less] < p) {
                less++;
            }
            while (less < great && array[great] > p) {
                great--;
            }

            swap(array, less, great);
        }

        return less;
    }

    private static void swap(int[] array, int less, int great) {
        int temp = array[less];
        array[less] = array[great];
        array[great] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5};
//        System.out.println(Arrays.toString(array));
//        bubbleSort(array);
//        System.out.println(Arrays.toString(array));

        System.out.println(Arrays.toString(array));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }


}
