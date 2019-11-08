package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/11/8 21:48
 */
public class SolutionDaily1106 {
    /**
     * 求数组中的逆序对个数
     * 逆序对：有一组数，对于任意两个数，前一个数大于后一个数，则这两个数字组成一个逆序对
     *
     * @param A 数组
     * @param n 数组长度
     * @return
     */
    public static int count(int[] A, int n) {
        int re = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (A[i] > A[j]) {
                    re++;
                }
            }
        }
        return re;
    }

    /**
     * 换瓶子问题：三个瓶子可以换一瓶饮料，当有两个瓶子时，允许借一瓶饮料，喝完后还回去。
     * 求当有n个空瓶子时最多可以喝到多少瓶饮料
     *
     * @param n
     * @return
     */
    public static int exchange1(int n) {
        int h = 0;//喝完后当前手里的瓶子数
        int y = 0;
        int re = 0;
        while (n != 0) {
            h = (n / 3) + (n % 3);
            re += (n / 3);
            if (h == 2) {
                re++;
                break;
            }
            if (h == 3) {
                re++;
                break;
            }
            if (h == 1) {
                break;
            }
            n = h;
        }
        return re;
    }

    /**
     * 思路二：两个空瓶子可以喝到一瓶饮料，计算有多少个两个瓶子即可
     *
     * @param n
     * @return
     */
    public static int exchange(int n) {
        int re = 0;
        if (n % 2 != 0) {
            n--;
        }
        re = n / 2;
        return re;
    }

    public static void main(String[] args) {
//        int[] A = {1,2,3,4,5,6,7,0};
//        System.out.println(count(A,8));
        Scanner sc = new Scanner(System.in);
        int i = 0;
        while (i < 10) {
            int n = sc.nextInt();
            i++;
            if (n == 0) {
                return;
            }
            System.out.println(exchange(n));
        }
    }

}
