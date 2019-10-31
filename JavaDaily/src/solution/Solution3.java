package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/31 23:36
 */
public class Solution3 {
    //LeetCode 3

    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * eg:
     * 输入："abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     */


    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 1;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                flag = false;
                set.clear();
            }
            set.add(s.charAt(i));
            max = (set.size() > max ? set.size() : max);
        }
        if (flag == true) {
            max = set.size();
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
