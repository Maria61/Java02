package algorithm_experiment;

import java.util.Scanner;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/4 14:44
 */

/**
 * 01背包问题
 */
public class Experiment1204 {
    int numOfObject;  //待装载的总物品数
    int[] weight;  //待装载的重量数组
    int[] value;  //待装载的价值数组
    int maxWeightOfKnapsack;  //背包的最大重量
    int[][] dp;  //dp背包
    int[] x;  //存储最优解的数组

    //输入信息
    public void InputInfo(){
        Scanner in = new Scanner(System.in);
        System.out.println("请输入待装载的总件数：");
        numOfObject = in.nextInt();
        System.out.println("请输入包能装载的最大重量：");
        maxWeightOfKnapsack = in.nextInt();
        System.out.println("请依次输入待装载包重量：");
        weight = new int[numOfObject];
        for (int i=0; i<numOfObject; i++){
            weight[i] = in.nextInt();
        }
        System.out.println("请依次输入待装载包价值：");
        value = new int[numOfObject];
        for (int i=0; i<numOfObject; i++){
            value[i] = in.nextInt();
        }
        x = new int [numOfObject];
        dp = new int[numOfObject+1][maxWeightOfKnapsack+1];
        in.close();
    }

    //用动态规划的方法构造dp矩阵
    public void knapsack(){
        //1、初始化dp
        for (int i=weight[1]; i<=maxWeightOfKnapsack; i++){
            dp[1][i] = value[0];
        }
        //2、构造dp
        for (int i=1; i<=numOfObject; i++){
            for (int j=1; j<=maxWeightOfKnapsack; j++){
                if (j < weight[i-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else if(j >= weight[i-1]){
                    dp[i][j] = Math.max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]);
                }
            }
        }
    }

    //打印dp
    public void printDP(){
        System.out.println("能装载的最大重量为:" + dp[numOfObject][maxWeightOfKnapsack]);

/*      //当你需要打印dp矩阵的时候，直接取消注释就可以了
 *      for (int i=0; i<=numOfObject; i++){
            for (int j=0; j<=maxWeightOfKnapsack; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
*/
        System.out.println("最优解为：");
        for (int i=0; i<numOfObject; i++){
            System.out.print(x[i] + " ");
        }
    }

    //用回溯法构造最优解
    public void traceback(){
        int temp = maxWeightOfKnapsack;
        for (int i=1; i<=numOfObject; i++){
            if(dp[i][temp] == dp[i-1][temp]){
                x[i-1] = 0;
            }else{
                x[i-1] = 1;
                temp -= weight[i-1];
            }
        }
    }

    public static void main(String[] args) {
        Experiment1204 knap = new Experiment1204();
        //录入信息
        knap.InputInfo();
        //构造dp,递归构造最优值
        knap.knapsack();
        //利用最优值回溯构造最优解
        knap.traceback();
        //打印数据
        knap.printDP();

    }
}