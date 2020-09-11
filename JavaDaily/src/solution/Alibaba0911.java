package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/11 8:59
 */
public class Alibaba0911 {
    /**
     * 在s中统计包含mi中字符串的子串个数
     * @param s
     * @param mi
     * @return
     */
    private static int method1(String s, String[] mi) {
        int re = 0;
        for(int i = 0; i < mi.length; i++){
            int l = mi[i].length();
            for(int j = 0; j <= s.length() - l; j++){
                String sub = s.substring(j,j+l);
                if(mi[i].equals(sub)){
                    re++;
                }
            }
        }
        return re;
    }

    public static int method(String s,String[] mi){
        int re = 0;
        ArrayList<String> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for(int  i = 0; i < mi.length; i++){
            list.add(mi[i]);
            set.add(mi[i].length());
        }
        for(Integer e : set){
            for(int i = 0; i <= s.length() - e; i++){
                String s1 = s.substring(i,i+e);
                if(list.contains(s1)){
                    re++;
                }
            }
        }
        return re;
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        String s1 = sc.nextLine();
        String[] mi = new String[m];
        for(int i = 0; i < m; i++){
            mi[i] = sc.nextLine();
        }
        int re = method(s1,mi);
        System.out.println(re);

    }

    /**
     * 恢复图片像素块
     * 像素块为-1的部分为需要恢复的部分，恢复方式为取周围一圈的非-1像素块的平均值
     * 如果有两个连续的像素块都为-1，则周围一圈像素块不包括-1，并向外延申一个
     * @param arr
     * @param n
     * @param m
     * @return
     */
    private static int[][] method2(int[][] arr,int n,int m) {
        int[][] re = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int sum = 0;
                int count = 0;
                if(arr[i][j] == -1){
                    int k = i - 1;
                    while(k >= 0){
                        if(arr[k][j] != -1){
                            sum += arr[k][j];
                            count++;
                            break;
                        }else{
                            k--;
                        }
                    }
                    int g = i + 1;
                    while(g < n){
                        if(arr[g][j] != -1){
                            sum += arr[g][j];
                            count++;
                            break;
                        }else{
                            g++;
                        }
                    }
                    int h = j - 1;
                    while(h >= 0){
                        if(arr[i][h] != -1){
                            sum += arr[i][h];
                            count++;
                            break;
                        }else{
                            h--;
                        }
                    }
                    int l = j + 1;
                    while(l < m){
                        if(arr[i][l] != -1){
                            sum += arr[i][l];
                            count++;
                            break;
                        }else{
                            l++;
                        }
                    }
                    re[i][j] = sum/count;
                }else {
                    re[i][j] = arr[i][j];
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[][] re = method2(arr,n,m);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                System.out.print(re[i][j]+" ");
            }
            System.out.println();
        }

    }
}
