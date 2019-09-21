package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/21 11:51
 */
public class Solution13 {
    /**
     * 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     *
     * @param s 罗马数字
     * @return 阿拉伯数字
     */
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        Map<Character, List<Character>> special = new HashMap<>();
        special.put('I', Arrays.asList('V', 'X'));
        special.put('X', Arrays.asList('L', 'C'));
        special.put('C', Arrays.asList('D', 'M'));
        int re = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i < s.length() - 1) {
                char next = s.charAt(i + 1);
                if (special.containsKey(c)) {
                    if (special.get(c).contains(next)) {
                        int nextInt = map.get(next);
                        int curInt = map.get(c);
                        re += (nextInt - curInt);
                        i++;
                        continue;
                    }
                }
            }
            int curInt = map.get(c);
            re += curInt;
        }
        return re;
    }
}
