package solution;

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

    public static void main(String[] args) {
    }
}
