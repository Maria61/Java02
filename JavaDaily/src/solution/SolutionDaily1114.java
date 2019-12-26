package solution;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/14 22:49
 */
public class SolutionDaily1114 {
    String str = new String("hello");
    char[] c = {'a', 'b'};

    private static void method() {
        System.out.println("-----");
    }

    public void method(String str, char c[]) {
//        str = "Test1";
        str = new String("Test1");
        c[0] = 'c';
    }

    /**
     * 选择题测试
     *
     * @param args
     */
    public static void main1(String[] args) {
//        int i = 0;
//        Integer j = new Integer(0);
//        System.out.println(i==j);
//        System.out.println(j.equals(i));

//        ((SolutionDaily1114)null).method();
//
//        String s = "fmn";
//        String x = s.toUpperCase();
//        String y = s.replace('f','F');
//        y = y + "wxy";
//        System.out.println(y);
//        System.out.println(x);

        SolutionDaily1114 solutionDaily1114 = new SolutionDaily1114();
        solutionDaily1114.method(solutionDaily1114.str, solutionDaily1114.c);
        System.out.println(solutionDaily1114.c);
        System.out.println(solutionDaily1114.str);

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 25) {
            System.out.println(countZero1(n));
        } else {
            System.out.println(countZero(n));
        }
    }

    //处理大数部分,阶乘结果大于long类型，需用BigInteger类型存储数据
    private static int countZero1(int n) {
        if (n > 1000) {
            return 0;
        }
        int count = 0;
        BigInteger re = factorial2(n);
        BigInteger num = new BigInteger("10");
        while (true) {
            BigInteger bi = re.divideAndRemainder(num)[1];
            if (bi.equals(new BigInteger("0"))) {
                count++;
            } else {
                break;
            }
            re = re.divide(num);
        }
        return count;
    }

    //大数的阶乘算法
    private static BigInteger factorial2(int n) {
        BigInteger re = new BigInteger("1");
        BigInteger i = new BigInteger("1");
        while (i.min(new BigInteger(String.valueOf(n))).equals(i)) {
            re = re.multiply(i);
            i = i.add(new BigInteger("1"));
        }
        return re;
    }

    //处理n小于等于25，阶乘在long范围内的情况
    private static int countZero(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;
        long re = factorial1(n);
        while (true) {
            if (re % 10 == 0) {
                count++;
            } else {
                break;
            }
            re /= 10;
        }
        return count;
    }

    //递归阶乘
    private static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    //非递归阶乘
    private static long factorial1(int n) {
        long re = 1;
        int i = 1;
        while (i <= n) {
            re *= i;
            i++;
        }
        return re;
    }
    //
    private static String revserNum(int n) {
        String s = new String();
        while (n != 0) {
            s += n % 10;
            n = n / 10;
        }
        return s;
    }
}
