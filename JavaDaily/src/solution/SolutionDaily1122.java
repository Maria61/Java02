package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/22 23:39
 */
public class SolutionDaily1122 {
    public static void main1(String[] args) {
        int i = 0;
        int j = 0;
        if (++i > 0 || ++j > 0) {
            System.out.println(i);
            System.out.println(j);
        }

    }

    public static int[] washCard(int[] n) {
        int[] a = Arrays.copyOfRange(n, 0, n.length / 2);
        int[] b = Arrays.copyOfRange(n, n.length / 2, n.length);
        int[] re = new int[n.length];
        for (int i = 0, j = 0; i < re.length - 1 && j < a.length; i += 2, j++) {
            re[i] = a[j];
            re[i + 1] = b[j];
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int[] num = new int[s1.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(s1[i]);
        }
        int n = num[0];
        int flag = 0;
        for (int i = 0; i < n; i++) {
            int n1 = num[++flag];
            int[] array = new int[2 * n1];
            int k = num[++flag];
            for (int j = 0; j < 2 * n1; j++) {
                array[j] = num[++flag];
            }
            for (int m = 0; m < k; m++) {
                array = washCard(array);
            }
            for (int z = 0; z < array.length; z++) {
                if (z == array.length - 1 && i == (n - 1)) {
                    System.out.print(array[z]);
                } else {
                    System.out.print(array[z] + " ");
                }
            }
        }


    }
}
