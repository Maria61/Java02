package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/11 23:11
 */
public class SolutionDaily1110 {
    /**
     * 输入n个整数，输出出现次数大于等于数组长度一半的数。
     * 每个测试用例包括 n 个空格分割的n个整数，n不超过100,其中有一个整数出现的次数大于等于n/2
     *
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] c = s.split(" ");
        Arrays.sort(c);
        int a = c.length / 2;
        for (int i = 0; i < c.length - a; i++) {
            if (c[i].equals(c[i + a - 1])) {
                System.out.println(c[i]);
            }
        }
    }

}
