package solution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/13 23:34
 */
public class SolutionDaily1113 {

    /**
     * 找出n个数里最小的k个
     * 输入：
     * 每个测试输入包括空格分隔的 n+1 个整数，最后一个整数为 k 值，n 不超过100
     * eg:3 9 6 8 -10 7 -11 19 30 12 23 5
     * 输出：
     * 输出 n 个整数里最小的 k 个数。升序输出
     * eg:-11 -10 3 6 7
     *
     * @param args
     */
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if (s != null) {
            String[] c = s.split(" ");
            int[] array = new int[c.length - 1];
            for (int i = 0; i < c.length - 1; i++) {
                array[i] = Integer.valueOf(c[i]);
            }
            if (c.length <= 1) {
                System.out.println();
            } else {
                int[] re = MinK(array, Integer.valueOf(c[c.length - 1]));
                for (int i = 0; i < re.length; i++) {
                    System.out.print(re[i] + " ");
                }
            }
        }
    }

    private static int[] MinK(int[] c, int k) {
        if (c.length == 0) {
            return null;
        }
        if (k >= c.length) {
            return null;
        }
        Arrays.sort(c);
        return Arrays.copyOf(c, k);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(delectByTwo(n));

    }

    private static int delectByTwo(int n) {
        int re = 0;
        int[] array = new int[n];
        int count = 0;
        int flag = 0;
        while (count < n) {
            for (int i = 0; i != n; i++) {
                if (array[i] == 0) {
                    flag++;
                }
                if (flag == 3) {
                    array[i] = 1;
                    flag = 0;
                    count++;
                    re = i;
                }
            }
        }
        return re;

    }

    private static int delectByTwo1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n > 1000) {
            n = 999;
        }
        int re = 0;
        int[] array = new int[n];
        //初始化数组元素全为1，只有被删除后该位置的元素为0
        for (int i = 0; i < n; i++) {
            array[i] = 1;
        }
        int j = 0;
        int count = 0;
        int flag = 0;
        while (true) {
            while (j < n && array[j] == 1) {
                flag++;
                j++;
                //判断是否隔了 2 个数（1）
                if (flag == 2) {
                    if (j == n) {
                        j = 0;
                    }
                    while (array[j] == 0) {
                        j++;
                        if (j == n) {
                            j = 0;
                        }
                    }
                    //删除：将对应下标处的值改为0
                    array[j] = 0;
                    count++;
                    j++;
                    flag = 0;
                }
            }
            if (j >= n) {
                j = 0;
            } else {
                j++;
            }
            //判断是否只剩一个数不为0
            if (count == n - 1) {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                re = i;
                break;
            }
        }
        return re;
    }
}
