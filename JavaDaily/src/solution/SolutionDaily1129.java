package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/1 23:46
 */
public class SolutionDaily1129 {
    public static int judge(String s1, String s2) {
        int re = 0;
        char[] c2 = s2.toCharArray();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < c2.length; i++) {
            if (map2.containsKey(c2[i])) {
                int v = map2.get(c2[i]);
                map2.put(c2[i], v++);
            } else {
                map2.put(c2[i], 1);
            }
        }
        char[] c1 = s1.toCharArray();
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < c1.length; i++) {
            if (map1.containsKey(c1[i])) {
                int v = map1.get(c1[i]);
                map1.put(c1[i], v++);
            } else {
                map1.put(c1[i], 1);
            }
        }
        for (Map.Entry<Character, Integer> e : map2.entrySet()) {
            Character c = e.getKey();
            if (map1.containsKey(c)) {
                if (map1.get(c) < e.getValue()) {
                    re += e.getValue() - map1.get(c);
                }
            } else {
                re += e.getValue();
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int re = judge(s1, s2);
        if (re == 0) {
            System.out.println("Yes " + (s1.length() - s2.length()));
        } else {
            System.out.println("No " + re);
        }
    }
}
