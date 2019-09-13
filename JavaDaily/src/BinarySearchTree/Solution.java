package BinarySearchTree;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/11 15:44
 */
public class Solution {
    //LeetCode 1002题

    /**
     * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
     * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
     * 例如：
     * 输入：["bella","label","roller"]
     * 输出：["e","l","l"]
     */
    public static List<String> commonChars(String[] A) {

        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String s : A) {
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int c = m.getOrDefault(s.charAt(i), 0);
                m.put(s.charAt(i), c + 1);
            }
            list.add(m);
        }

        List<String> result = new ArrayList<>();
        Set<Character> set = list.get(0).keySet();

        for (Character c : set) {
            boolean exist = true;
            int v = 10000;
            for (Map<Character, Integer> m1 : list) {
                if (m1.containsKey(c)) {
                    v = min(v, m1.get(c));
                } else {
                    exist = false;
                    break;
                }
            }
            while (v != 0 && exist) {
                result.add(c.toString());
                v--;
            }

        }

        return result;

    }

    private static int min(int v, int n) {
        if (v > n) {
            return n;
        } else {
            return v;
        }
    }

    public static void main(String[] args) {
        String[] A = {"bella", "label", "roller"};
        List<String> l = commonChars(A);
        System.out.println(l);
    }


}
