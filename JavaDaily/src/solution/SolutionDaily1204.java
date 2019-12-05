package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/5 16:45
 */
public class SolutionDaily1204 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int re1 = square(n);
            int re2 = square((int) Math.pow(n, 2));
            System.out.println(re1 + " " + re2);
        }
    }

    private static int square(int n) {
        int x = n;
        int re = 0;
        while (x != 0) {
            re += x % 10;
            x = x / 10;
        }
        return re;
    }
}
