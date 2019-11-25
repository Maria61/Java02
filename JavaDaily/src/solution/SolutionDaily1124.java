package solution;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/25 21:10
 */
public class SolutionDaily1124 {
    //求出C和G在所给字符串的子串中出现的最大比例，子串的长度由用户输入
    //比例计算方法：C和G出现的次数与子串的长度的比
    public static String lengthestString(String s, int n) {
        String re = new String();
        for (int i = 0; i <= s.length() - n; i++) {
            String s1 = s.substring(i, i + n);
            double f = proportion(s1);
            if (f > proportion(re)) {
                re = s1;
            }
        }
        return re;
    }

    private static double proportion(String re) {
        if (re.length() == 0) {
            return 0;
        }
        char[] c = re.toCharArray();
        int count = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] == 'C' || c[i] == 'G') {
                count++;
            }
        }
        return ((double) count) / c.length;
    }

    //富翁每天给陌生人10万元，陌生人第一天给夫翁1分钱，第二天给富翁2分钱，第三天4分钱，
    //问30天后，富翁给出了多少钱（万元），陌生人给出多少钱（分）？
    public static void richmanAndStranger() {
        long rich = 0;
        long stranger = 0;
        for (int i = 0; i < 30; i++) {
            rich += 10;
            stranger += Math.pow(2, i);
        }
        System.out.print(rich + " ");
        System.out.println(stranger);

    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String s = sc.nextLine();
//        int n = sc.nextInt();
//        System.out.println(lengthestString(s,n));

        richmanAndStranger();

    }
}
