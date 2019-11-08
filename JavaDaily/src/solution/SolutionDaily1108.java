package solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/8 23:14
 */
public class SolutionDaily1108 {
    /**
     * 输出从第一个字符串中删除第二个字符串包含的所有字符
     *
     * @param s1
     * @param s2
     * @return
     */
    public static String deleteCharacter(String s1, String s2) {
        String re = new String();
        Set<Character> set = new HashSet<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < c2.length; i++) {
            set.add(c2[i]);
        }
        for (int i = 0; i < c1.length; i++) {
            if (!set.contains(c1[i])) {
                re += c1[i];
            }
        }
        return re;
    }

    /**
     * 小明买苹果问题：苹果只有6个装或者8个装（不可拆），小明想用最少的袋子数买到刚好个数的苹果，如果买不到返回-1
     *
     * @param n 想要买的苹果数
     * @return
     */
    public static int countMin(int n) {
        int min = 100;
        for (int i = 0; i < Math.max(n / 6, n / 8) + 1; i++) {
            for (int j = 0; j < Math.max(n / 6, n / 8) + 1; j++) {
                if (8 * i + 6 * j == n) {
                    min = (i + j) < min ? (i + j) : min;
                }
            }
        }
        if (min == 100) {
            min = -1;
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String s1 = sc.nextLine();
//        String s2 = sc.nextLine();
//        System.out.println(deleteCharacter(s1,s2));
        int n = sc.nextInt();
        System.out.println(countMin(n));
    }
}
