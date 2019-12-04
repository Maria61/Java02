package algorithm_experiment;

import java.util.Scanner;

/**
 * @author Maria
 * @program homework
 * @date 2019/11/27 16:26
 */

/**
 * n皇后问题
 */
public class Experiment1127 {
        public static int count = 0;
        //n皇后问题中皇后摆放位置满足的限制条件，若满足则返回true，否则返回false
        public static boolean isOk(int[] result, int step) {
            for(int i = 0;i < step;i++) {
                for(int j = i + 1;j < step;j++) {
                    int left = i - j;
                    int right = j - i;
                    if(result[j] == result[i] + left || result[j] == result[i] + right)
                        return false;
                }
            }
            return true;
        }
        //交换数组A中m位置和n位置上的值
        public static void swap(int[] A, int m, int n) {
            int temp = A[m];
            A[m] = A[n];
            A[n] = temp;
        }

        public static void printResult(int[] A, int step) {
            if(step == A.length) {
                count++;
                for(int i = 0;i < A.length;i++)
                    System.out.print(A[i]+" ");
                System.out.println();
                return;
            } else {
                for(int i = step;i < A.length;i++) {
                    swap(A, i, step);   //执行回溯前的移位
                    if(isOk(A, step + 1))
                        printResult(A, step + 1);
                    swap(A, i, step);   //如果不满足条件或者已经完成一种方案，进行回溯处理
                }
            }
        }

        public static void main(String[] args) {
            Experiment1127 test = new Experiment1127();
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[] A = new int[n];
            for(int i = 0; i < n; i++){
                A[i] = (i + 1);
            }
            test.printResult(A, 0);
            System.out.println("符合n皇后排序条件的排序方式个数为："+count);
        }
    }