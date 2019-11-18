package solution;

import java.util.Arrays;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/16 17:34
 */
public class SolutionDaily1116 {
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < B.length; i++) {
            B[i] = mul(A, i);
        }
        return B;
    }

    private int mul(int[] a, int i) {
        int re = 1;
        for (int j = 0; i < a.length; j++) {
            if (j != i) {
                re *= a[j];
            }
        }
        return re;
    }

    public static int[] multiply1(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int j = length - 2; j >= 0; j--) {
            temp *= A[j + 1];//temp始终会记录值，每次只需要乘上这行上三角没有乘进来的数就可以了。
            B[j] *= temp;
        }
        return B;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(multiply1(A)));
    }
}
