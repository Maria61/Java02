package solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/7 23:52
 */
public class SolutionDaily1107 {
    public static String longestNumString(String s) {
        if (s == null) {
            return null;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add((char) (i + '0'));
        }
        char[] c = s.toCharArray();
        String re = new String();
        String max = null;
        for (int i = 0; i < c.length; i++) {
            if (set.contains(c[i])) {
                re += c[i];
            } else if (re != null && max != null) {
                max = (re.length() > max.length()) ? re : max;
            } else {
                max = re;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestNumString(s));
    }
}
