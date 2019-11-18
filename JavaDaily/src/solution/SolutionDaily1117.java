package solution;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/18 12:44
 */
public class SolutionDaily1117 {
    public int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] + AB[1];
        AB[1] = AB[0] - AB[1];
        AB[0] = AB[0] - AB[1];
        return AB;
    }


    public static void main(String[] args) {

    }
}
