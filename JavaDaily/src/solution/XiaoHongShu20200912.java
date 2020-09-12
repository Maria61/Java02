package solution;

import java.util.HashSet;
import java.util.Stack;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/12 10:10
 */
public class XiaoHongShu20200912 {
    /**
     * 一个二叉树深度为k，节点取值为自然数,k<=5，找出不在树中的最小自然数，需要给出O(N)的算法。
     * @param tree
     * @return
     */
    static int findMin(int[] tree) {
        int re = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < tree.length; i++){
            set.add(tree[i]);
        }
        for(int i = 1; i < 33; i++){
            if(set.contains(i) == false){
                re = i;
                break;
            }
        }
        return re;

    }

    /**
     * 字符串分割:给定一个非空的字符串s ，将s切割成若干个非空子串，要求每个子串头尾是相同字符 ，给出切割的子串的数量最少的方法。
     * 输入描述:
     * 一个非空的字符串s
     * 输出描述:
     * 满足要求的切割结果的子串数量
     */
    static int solution1(String s) {
        int re = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if(set.contains(s.charAt(i)) == true){
                re++;
                set.clear();
            }else{
                set.add(s.charAt(i));
            }
        }
        if(set.isEmpty() == false){
            re += set.size();
        }
        return re;
    }
    static int solution2(String s) {
        Stack<Character> stack = new Stack<>();
        int re = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(stack.indexOf(c) == 0){
                re++;
                stack.clear();
            }else if(stack.indexOf(c) > 0){
                re += stack.indexOf(c) + 1;
                stack.clear();
            }else{
                stack.push(c);
            }
        }
        if(stack.empty() == false){
            re += stack.size();
        }
        return re;
    }
    public static int solution(String s){
        char[] chars = s.toCharArray();
        int re = 0;
        for(int i = 0; i < chars.length; i++){
            int l = s.indexOf(chars[i]);
            int r = s.lastIndexOf(chars[i]);
            if((r - l) != 0){
                re += 1;
                i += r;
                s = s.substring(r+1);
            }else{
                re++;
            }
        }
        return re;
    }
    public static void main(String[] args) {
        System.out.println(solution("Java"));


    }
}
