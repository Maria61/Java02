package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/21 20:24
 */
public class SolutionDaily1120 {

    /**
     * 给定数字0-9各若干个。你可以以任意顺序排列这些数字，但必须全部使用。
     * 目标是使得最后得到的数尽可能小（注意0不能做首位）。
     * 例如：给定两个0，两个1，三个5，一个8，我们得到的最小的数就是10015558。
     *
     * 输入样例：
     * 2 2 0 0 0 3 0 0 1 0
     * 输出样例：
     * 10015558
     * @param s
     * @return
     */
    /**
     * 思路：
     * 1.将输入字符串转化位字符串数组，从下标为1处遍历数组，
     * 将下标i加到结果字符串尾部，对应数组下标位置的元素是几就加几个下标i
     * 2.最后处理0，创造一个全是0的字符串，长度为数组下标为0处的值
     * 3.将0字符串拼接到结果字符串的第二个位置
     *
     * @param s
     * @return
     */
    public static String minNum2(String s) {
        String re = new String();
        String[] s1 = s.split(" ");
        int[] num = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            num[i] = Integer.parseInt(s1[i]);
        }
        for (int i = 1; i < num.length; i++) {
            for (int j = 0; j < num[i]; j++) {
                re += String.valueOf(i);
            }
        }
        String zero = new String();
        for (int i = 0; i < num[0]; i++) {
            zero += "0";
        }
        String f = re.substring(0, 1);
        String l = re.substring(1);
        re = f + zero + l;
        return re;
    }

    /**
     * 证明尼科切斯定理
     *
     * @param
     */
    /*
    cube = n * n * n;
    for (i = 1; i * i <= 4 * cube; i++)
    {
        if (4 * cube % i == 0)
        {
            mini = i;
            maxi = 4 * cube / i;
            if ((mini + maxi) % 2 == 0)
            {
                nStart = (maxi - mini + 2) / 2;
                nEnd = (maxi + mini - 2) / 2;
                if (0 == nStart % 2)//如果不是奇数，不要这个序列
                    continue;

                if (nStart < nEnd)//大于1个元素再输出
                {
                    printf("%u * %u * %u = %u =",n, n , n, cube);
                    printf(" %u", nStart);
                    for (j = nStart + 2; j <= nEnd; j += 2)
                        printf(" + %u", j);
                    printf("\n");
                }
            }
        }
    }
     */
    public static String method(int a) {
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minNum2(s));
    }
}
