package solution;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/18 18:37
 */
public class Solution1053 {
    //LeetCode 1053
    public static int[] prevPermOpt1(int[] A) {
        int i;
        int c = 0;
        int d = 0;
        int max = -1;
        for (i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                c = i;
                break;
            }
        }
        if (i == -1) {
            return A;
        }
        for (int j = c + 1; j < A.length; j++) {
            if (A[j] < A[c]) {
                if (A[j] > max) {
                    max = A[j];
                    d = j;
                }

            }
        }

        int t = 0;
        t = A[c];
        A[c] = A[d];
        A[d] = t;

        return A;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 5};
        System.out.println(Arrays.toString(prevPermOpt1(a)));
    }
}
