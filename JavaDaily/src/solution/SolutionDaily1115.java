package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/15 23:10
 */
public class SolutionDaily1115 {
    public static int add(int a, int b) {
        try {
            return a + b;
        } catch (Exception e) {
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
        return 0;
    }

    public static void main1(String[] args) {
//        byte b1 = 1,b2 = 2,b3,b6;
//        final byte b4 = 4,b5 = 6;
//        b6 = b4 + b5;
////        b3 = (b1 + b2);
//        System.out.println(b3 + b6);

//        try {
//            int i = 100 / 0;//这一句会抛异常
//            System.out.println(i);
//        } catch (Exception e) {
//            System.out.println(1);
//            throw new RuntimeException();
//        } finally {
//            System.out.println(2);
//        }
//        System.out.println(3);

//        System.out.println("和是"+add(9,34));


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(countFab(n));
    }

    /**
     * 统计几步可以变成斐波那契数
     *
     * @param n
     * @return
     */
    private static int countFab(int n) {
        int re = 0;
        int i = 0;
        while (re < n) {
            i++;
            re = fab(i);
        }
        if (re == n) {
            return 0;
        }
        if ((re - n) < (n - fab(i - 1))) {
            return re - n;
        } else {
            return n - fab(i - 1);
        }
    }

    private static int fab(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fab(i - 1) + fab(i - 2);
    }
}
