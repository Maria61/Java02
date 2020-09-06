package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/6 11:33
 */
public class ZiJieTiaoDong20200906 {
    public static String method(String s){
        String re = new String();
        String[] ss = s.split(" ");
        int[][] arr = new int[4][2];
        for(int i = 0,j = 0,k = 0; i < ss.length; i++){
            arr[j][k] = Integer.valueOf(ss[i]);
            k++;
            if(k == 2){
                k = 0;
                j++;
            }
        }
        // 根据坐标计算平行四边形的面积
        int l = Math.abs(arr[0][1] - arr[1][1]);
        int w = Math.abs(arr[0][0] - arr[3][0]);
        int sa = l*w;
        re = String.valueOf(sa)+" ";
        //根据坐标变化判断顺时针还是逆时针变化
        re += "yes";
        return re;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = new String();
        String re = new String();
        for(int i = 0; i < n; i++){
            s = sc.nextLine();
            re = method(s);
            System.out.println(re);
        }
    }

}
