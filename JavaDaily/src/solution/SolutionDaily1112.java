package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/12 22:10
 */
public class SolutionDaily1112 {
    /**
     * 计算最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    public static int minMultiple(int a, int b) {
        if (a <= 0 && b <= 0) {
            return 0;
        }
        int re = 0;
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        for (int i = 1; i <= a; i++) {
            if ((b * i) % a == 0) {
                re = b * i;
                break;
            }
        }
        return re;
    }

    /**
     * @param w
     * @param h
     * @return
     */
    public static int cakes(int w, int h) {
        int re = 0;
        int[][] box = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (box[i][j] != 1 && i < h - 2 && j < w - 2) {
                    box[i][j + 2] = 1;
                    box[i + 2][j] = 1;
                }
            }
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (box[i][j] == 0) {
                    re++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
//        System.out.println(minMultiple(a, b));
        System.out.println(cakes(a, b));
    }
}
