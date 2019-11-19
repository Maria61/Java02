package solution;

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
        String re = new String();
        if (addend.length() < augend.length()) {
            String t = addend;
            addend = augend;
            augend = t;
        }
        String[] s1 = addend.split("");
        String[] s2 = augend.split("");
        int l1 = s1.length;
        int l2 = s2.length;
        int x = 0;
        int y = 0;
        int i = l1 - 1;
        while (i > l2) {
            int sum = Integer.parseInt(s1[i]) + Integer.parseInt(s2[i]) + x;
            if (sum >= 10) {
                x = sum / 10;
                y = sum % 10;
            } else {
                y = sum;
            }
            re += String.valueOf(y);
            i--;
        }
        while (i >= 0) {
            int sum = x + Integer.parseInt(s1[i]);
            if (sum >= 10) {
                x = sum / 10;
                y = sum % 10;
            } else {
                y = sum;
            }
            re += String.valueOf(y);
            i--;
        }
        re += x;
        return re;
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
