package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/2 20:36
 */
public class SolutionDaily0302 {

    /**
     * 如果你是哈利·波特迷，你会知道魔法世界有它自己的货币系统 ——
     * 就如海格告诉哈利的：“十七个银西可(Sickle)兑一个加隆(Galleon)，
     * 二十九个纳特(Knut)兑一个西可，很容易。”
     * 现在，给定哈利应付的价钱P和他实付的钱A，你的任务是写一个程序来计算他应该被找的零钱。
     * @param pa 输入在1行中分别给出P和A，格式为“Galleon.Sickle.Knut”，其间用1个空格分隔。
     *           这里Galleon是[0, 107]]区间内的整数，Sickle是[0,17)区间内的整数，Knut是[0, 29)区间内的整数。
     * @return 在一行中用与输入同样的格式输出哈利应该被找的零钱。
     *         如果他没带够钱，那么输出的应该是负数。
     */
    public static String judge(String pa) {
        String[] give = pa.split(" ");
        String[] p = give[0].split("\\.");
        String[] a = give[1].split("\\.");
        int p1 = (Integer.parseInt(p[0])) * 17 * 29 + (Integer.parseInt(p[1])) * 29 + (Integer.parseInt(p[2]));
        int a1 = (Integer.parseInt(a[0])) * 17 * 29 + (Integer.parseInt(a[1])) * 29 + (Integer.parseInt(a[2]));
        int re = a1 - p1;
        String result = null;
        boolean flag = false;
        if(re < 0){
            flag = true;
        }
        re = Math.abs(re);
        result = String.valueOf(re / 29 / 17) + "." + String.valueOf((re / 29) % 17) + "." + String.valueOf(re % 29);
        if (flag == true) {
            result = "-" + result;
        }
        return result;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pa = sc.nextLine();
        System.out.println(judge(pa));
    }

    /**
     * 请编写一个方法，输出0到n(包括n)中数字2出现了几次。
     * 给定一个正整数n，请返回0到n的数字中2出现了几次。
     */
    public static int countNumberOf2s(int n) {
        int re = 0;
        for(int i = n; i > 1; i--){
            int j = i;
            while(j != 0){
                if(j % 10 == 2){
                    re ++;
                }
                j /= 10;
            }
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(countNumberOf2s(100));
    }
}
