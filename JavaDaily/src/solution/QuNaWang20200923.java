package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/23 18:47
 */
public class QuNaWang20200923 {
    /**
     * 跳台阶基础版递归版（时间超限）
     * @param n
     * @return
     */
    public static int method(int n){
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return method(n - 1) + method(n - 2);
    }

    /**
     * 跳台阶基础版非递归解法
     * 思路：将每次的结果都保存到数组中
     * @param n
     * @return
     */
    public static int method2(int n){
        int[] re = new int[n+1];
        re[0] = re[1] = 1;
        for(int i = 2; i <= n; i++){
            re[i] = re[i - 1] + re[i - 2];
        }
        return re[n];
    }

    /**
     * 基础跳台阶（非递归优化版）
     * @param n
     * @return
     */
    public static int method3(int n){
        if(n == 0 || n == 1){
            return n;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for(int i = 2; i <= n; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }

    /**
     * 跳台阶进阶版递归版
     * @param n
     * @return
     */
    public static int method1(int n){
        if(n == 1){
            return 1;
        }
        return 2*method1(n - 1);
    }

    /**
     * 跳台阶进阶非递归版
     * @param n
     * @return
     */
    public static int method4(int n){
        if(n == 0 || n == 1){
            return n;
        }
        return (int)Math.pow(2,n-1);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(method2(n));
    }
}
