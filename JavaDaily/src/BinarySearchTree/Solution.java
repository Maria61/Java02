package BinarySearchTree;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/11 15:44
 */
public class Solution {
    //LeetCode 1002题
    public List<String> commonChars(String[] A) {

        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String s : A) {
            Map<Character, Integer> m = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                int c = m.getOrDefault(s.charAt(i), 0);
                m.put(s.charAt(i), c++);
            }
            list.add(m);
        }

        List<String> result = new ArrayList<>();
        boolean exist = true;
        Set<Character> set = list.get(0).keySet();
        int v = 10000;
        for (Character c : set) {
            for (Map<Character, Integer> m1 : list) {
                if (m1.containsKey(c)) {
                    v = min(v, m1.get(c));
                } else {
                    break;
                }
            }
            while (v != 0) {
                result.add(c.toString());
                v--;
            }

        }

        return result;

    }

    private int min(int v, int n) {
        if (v > n) {
            return n;
        } else {
            return v;
        }
    }

}
