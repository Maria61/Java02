package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/11 18:02
 */
public class SolutionDaily0310 {

    /**
     * 二维数组打印对角线：
     * 有一个二维数组(n*n),写程序实现从右上角到左下角沿主对角线方向打印。
     * 给定一个二位数组arr及题目中的参数n，请返回结果数组。
     * @param arr [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]],4
     * @param n [4,3,8,2,7,12,1,6,11,16,5,10,15,9,14,13]
     * @return
     */
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] re = new int[n*n];
        int x = 0;
        int y = n - 1;
        int z = 0;
        while(x<n){
            int i = x;
            int j = y;
            while(j < n && i < n){
                re[z++] = arr[i++][j++];
            }
            if(y > 0){
                y--;
            }else{
                x++;
            }

        }
        return re;
    }

    /**
     * 添加一个字符串，问是否能通过添加一个字母将其变为回文串
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length()== 1 || s.length() == 2){//长度小于3的处理
            System.out.println("YES");
        }else{
            char[] chars = s.toCharArray();
            int i ;
            for(i = 1; i <= chars.length/2; i++){
                if(chars[i] != chars[chars.length - i]){
                    System.out.println("NO");
                    break;
                }
            }
            if(i > chars.length/2){
                System.out.println("YES");
            }
        }

    }
}
