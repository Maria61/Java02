package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/1 10:37
 */
public class SolutionDaily1128 {
    public static int getTotalCount(int monthCount) {
        if (monthCount < 3) {
            return 1;
        }

        int re = monthCount - 3;
        return getTotalCount(re);
    }

    public static void main(String[] args) {

    }
}
