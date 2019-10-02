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


    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
}
