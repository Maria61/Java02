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

    /**
     * @param A 一个正整数的数组 A（其中的元素不一定完全不同），
     * @return 返回可在 一次交换（交换两数字 A[i] 和 A[j] 的位置）后得到的:按字典序排列小于 A 的最大可能排列。
     * 如果无法这么操作，就请返回原数组。
     * eg:
     * 输入：[1,9,4,6,7]
     * 输出：[1,7,4,6,9]
     */
    public static int[] prevPermOpt1(int[] A) {
        int i;
        int c = 0;
        int d = 0;
        int max = -1;
        //逆序遍历,找出第一个降序的数的下标c
        for (i = A.length - 2; i >= 0; i--) {
            if (A[i] > A[i + 1]) {
                c = i;
                break;
            }
        }
        if (i == -1) {
            return A;
        }
        //找出比A[c]小的数里的最大的数的下标   ******有卡壳
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
