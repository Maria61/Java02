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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[4];
        for (int i = 0; i < 4; i++) {
            array[i] = sc.nextInt();
        }
        double[] array1 = new double[3];
        array1[0] = (array[0] + array[2]) / 2.0;
        array1[1] = (array[1] + array[3]) / 2.0;
        array1[2] = array1[1] - array[1];

        int A = (int) array1[0];
        int B = (int) array1[1];
        int C = (int) array1[2];
        if ((A == array1[0]) && (B == array1[1]) && (C == array1[2]) && (A >= 0) && (B >= 0) && (C >= 0)
                && (A <= 30) && (B <= 30) && (C <= 30)) {
            System.out.println(A + " " + B + " " + C);
        } else {
            System.out.println("NO");
        }
    }

}
