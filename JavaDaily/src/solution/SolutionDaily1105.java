package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/5 21:15
 */
public class SolutionDaily1105 {
    /**
     * 判断是否为回文数
     *
     * @param s
     * @return
     */
    public static boolean judge(String s) {
        String s1 = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.charAt(i);
        }
        return s1.equals(s);
    }

    /**
     * 统计字符串b插入到字符串a后的新字符串是回文数的个数
     *
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= a.length(); i++) {
            String re = new String();
            re += a.substring(0, i);
            re += b;
            re += a.substring(i);
            if (judge(re)) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 求第k大的数
     */
    public static int findKth1(int[] a, int n, int K) {
        Arrays.sort(a);
        return a[n - K];
    }

    /**
     * 基于快排思路的求第K大的数K
     *
     * @param a
     * @param n
     * @param
     * @return
     */
    public static int findKth2(int[] a, int n, int K) {
        return 0;
    }


    /**
     * 快速排序
     */
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
            while (less < great && array[less] <= p) {
                less++;
            }
            while (less < great && array[great] >= p) {
                great--;
            }
            swap(array, less, great);
        }
        swap(array, right, less);//此处less所指的数一定是比right位置的数大的数，所以交换合理
        /**
         * 原因：执行到这里说明less==great
         * 情景一：less++,直到遇到great,
         * great始终指向大于right位置（当它遇到小的数时，会立即跳出内循环进行交换，最后great还是指向了大的数）的数或者right位置本身（即great未移动过）
         * 情景二：great--,直到遇到less,
         * 此时，less移动过了遇到了大的数被迫停止或者less一开始就指向了大的数（即未移动），所以less现在所指的数一定是大数
         */
        return less;
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 8, 5, 6, 1, 9, 4, 2};
//        System.out.println(findKth1(array, array.length, 6));
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
