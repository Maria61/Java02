package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/21 22:51
 */
public class SolutionDaily1121 {
    public static void main(String[] args) {
        double a = 'A' + 1.0 + 2;
        System.out.println(a);
    }

    public static int addAB(int A, int B) {
        if (B == 0) {
            return A;
        }
        return addAB(A ^ B, A & B << 1);
    }
}
