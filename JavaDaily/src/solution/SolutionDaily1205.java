package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/6 16:13
 */
public class SolutionDaily1205 {
    //找X
    public static void main1(String[] args) {
        int re = -1;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            int x = sc.nextInt();
            for (int i = 0; i < n; i++) {
                if (array[i] == x) {
                    re = i;
                    break;
                }
            }
            System.out.println(re);
        }
    }

    //整数与IP地址之间的转换
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] c = s.toCharArray();
            for (int i = 0; i < c.length; i++) {
                if (c[i] == '.') {

                }
            }
        }
    }
}
