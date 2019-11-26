package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/26 18:07
 */
public class QuickSort {
    public static void quickSort(int[] array) {
        quickSortIntenel(array, 0, array.length);
    }

    private static void quickSortIntenel(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = partition(array, left, right);
        quickSortIntenel(array, left, p - 1);
        quickSortIntenel(array, p + 1, right);
    }

//    private static int partition(int[] array, int left, int right) {
//
//
//    }



    public static void main(String[] args) {

    }
}
