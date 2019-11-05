package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/5 21:15
 */
public class SolutionDaily1105 {
    /**
     * 判断是否为回文数
     *
     * @param s
     * @return
     */
    public static boolean judge(String s) {
        String s1 = new String();
        for (int i = s.length() - 1; i >= 0; i--) {
            s1 += s.charAt(i);
        }
        return s1.equals(s);
    }

    /**
     * 统计字符串b插入到字符串a后的新字符串是回文数的个数
     *
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int count = 0;
        for (int i = 0; i <= a.length(); i++) {
            String re = new String();
            re += a.substring(0, i);
            re += b;
            re += a.substring(i);
            if (judge(re)) {
                count++;
            }
        }
        System.out.println(count);
    }

    /**
     * 求第k大的数
     */
    public static int findKth(int[] a, int n, int K) {
        Arrays.sort(a);
        return a[n - K];
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 8, 5, 6, 1, 9, 4, 2};
        System.out.println(findKth(array, array.length, 6));
        System.out.println(Arrays.toString(array));
    }
}
