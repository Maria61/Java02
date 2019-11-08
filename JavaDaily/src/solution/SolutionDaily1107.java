package solution;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/7 23:52
 */

class Person {
    private String name = "person";
    int age = 0;
}

class Child extends Person {
    public String grade;
}

class Son extends Child {

}
public class SolutionDaily1107 {
    /**
     * 查找字符串的最大数字串
     *
     * @param s
     * @return
     */
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
        String max = new String();
        boolean flag = false;
        for (int i = 0; i < c.length; i++) {
            if (set.contains(c[i])) {
                re += c[i];
            } else {
                flag = true;
                max = (re.length() >= max.length()) ? re : max;
                re = new String();
                continue;
            }
        }
        if (flag == false) {
            max = re;
        }
        return max;
    }

    /**
     * 判断有效括号
     */
    public static boolean judge(String A, int n) {

        if (A == null || A.length() == 0 || A.length() != n) {
            return false;
        }
        boolean re = true;
        if ((n % 2 != 0) || (A.charAt(0) == ')') || (A.charAt(n - 1) == '(')) {
            re = false;
            return re;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            char a = A.charAt(i);
            if ((A.charAt(i) != '(') && (A.charAt(i) != ')')) {
                re = false;
                break;
            }
            if (A.charAt(i) == '(') {
                stack.push(A.charAt(i));
            }
            if (A.charAt(i) == ')') {
                stack.pop();
            }
        }
        if (stack.empty() != true) {
            re = false;
        }
        return re;
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        System.out.println(longestNumString(s));
//        System.out.println(judge("()()",4));
//        Person p = new Child();
//        String s1 = "hello";
//        String s2 = "he"+new String("llo");
//        System.out.println(s1 == s2);

        Person p1 = new Person();
        Person p2 = new Child();
        Person p3 = new Son();

    }
}
