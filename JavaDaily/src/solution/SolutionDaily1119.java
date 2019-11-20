package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/19 22:52
 */
public class SolutionDaily1119 {

    public static void main1(String[] args) {
        int i = 0;
//        for( i == 0;true;true){//不是语句，执行不了！！！
//
//        }
    }

    public static void printSquare(int a, char c) {
        if (a < 3 || a > 20) {
            return;
        }
        for (int i = 0; i < a; i++) {
            System.out.print(c);
        }
        System.out.println();
        int j = (a % 2 == 0) ? a / 2 : (a / 2 + 1);
        for (int i = 0; i < j - 2; i++) {
            System.out.print(c);
            for (int k = 0; k < a - 2; k++) {
                System.out.print(" ");
            }
            System.out.println(c);
        }

        for (int i = 0; i < a; i++) {
            System.out.print(c);
        }

    }

    public static String addLongInteger(String addend, String augend) {
        if (addend.length() < augend.length()) {
            String t = addend;
            addend = augend;
            augend = t;
        }
        char[] s1 = addend.toCharArray();
        char[] s2 = augend.toCharArray();
        if (!judge(s1)) {
            return null;
        }
        if (!judge(s2)) {
            return null;
        }
        char[] re = new char[addend.length() + 1];
        for (int i = 0; i < re.length; i++) {
            re[i] = '0';
        }
        s1 = reverse(s1);
        s2 = reverse(s2);
        int i = 0;
        int sum = 0;
        for (; i < re.length - 1; i++) {
            if (i < s1.length && i < s2.length) {
                sum = s1[i] - '0' + s2[i] - '0';
            } else if (i < s1.length && i >= s2.length) {
                sum = s1[i] - '0';
            } else if (i < s2.length && i >= s1.length) {
                sum = s2[i] - '0';
            }
            re[i] = (char) (sum % 10 + '0');//必须转化为相应的ASCII值再进行强转
            re[i + 1] = (char) (sum / 10 + '0');
        }
        if (re[i] == '0') {
            char[] re1 = Arrays.copyOf(re, re.length - 1);
            re = reverse(re1);
        } else {
            re = reverse(re);
        }
        String s = String.valueOf(re);
        return s;
    }

    private static boolean judge(char[] s1) {
        boolean re = true;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] > '9' || s1[i] < '0') {
                re = false;
                break;
            }
        }
        return re;
    }

    private static char[] reverse(char[] s1) {
        char[] s = new char[s1.length];
        for (int i = 0, j = s1.length - 1; i < s.length; i++, j--) {
            s[i] = s1[j];
        }
        return s;

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        String s1[] = s.split(" ");
//        int a = Integer.parseInt(s1[0]);
//        char c = s1[1].charAt(0);
//
//        printSquare(a,c);

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(addLongInteger(s1, s2));
    }
}

