package solution;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/13 9:57
 */
public class MeiTuan20200913 {
    /**
     * 小团有一个n×m的矩阵A， 他知道这是小美用一种特殊的方法生成的，具体规则如下:
     * 小美首先写下一个n'×m的矩阵，然后小美每一次将这个矩阵上下翻转后接到原矩阵的下方。
     * 小美重复这个过程若干次（甚至可能是0次，也就是没有进行过这一操作），然后将操作后的矩阵交给小团。
     * 小团想知道，小美一开始写下的矩阵是什么。
     * 因为小美可能有多种一开始的矩阵，小团想得到最小的矩阵（这里的最小指矩阵即n'×m的面积最小）(最少行)。
     * 输入描述
         * 输入包含两个整数n,m，表示小团矩阵的大小。
         * 接下来n行，每行m个正整数，第 i 行第 j 列表示矩阵第 i 行第 j 列的数。
         * 1≤n≤100000,1≤m≤5,矩阵内的数小于等于10
     * 输出描述
        * 输出包含一个矩阵，一共n'行m列，表示小美一开始最小的矩阵。
     * @param s
     * @return
     */
    private static String[] method1(String[] s) {
        if(s.length%2 == 1){
            return s;
        }
        String[] re;
        int length = 0;
        for(int i = 1; i < s.length; i += 2){
            if(s[0].equals(s[i])){
                length = (i + 1)/2;
                break;
            }
        }
        if(length == 0){
            return s;
        }
        re = new String[length];
        for(int j = 0; j < length; j++){
            re[j] = s[j];
        }
        return re;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];
        for(int i = 0; i < n; i++){
            s[i] = sc.nextLine();
        }
        String[] re = method1(s);
        for(int i = 0; i < re.length; i++){
            System.out.println(re[i]);
        }
    }

    /**
     * 小团需要购买m样装饰物。商店出售n种装饰物，按照从小到大的顺序从左到右摆了一排。对于每一个装饰物，小团都给予了一个美丽值ai。
     * 小团希望购买的装饰物有着相似的大小，所以他要求购买的装饰物在商店中摆放的位置是连续的一段。小团还认为，一个装饰物的美丽值不能低于k，否则会不好看。
     * 现在，请你计算小团有多少种不同的购买方案。
     * 输入描述
         * 输入第一行包含三个数n,m,k
         * 接下来一行n个整数ai ( 1≤ i ≤n )，空格隔开，表示商店从左到右摆放的每个装饰物的美丽值。
         * n , m≤100000
         * 1≤ai ,k≤10^9
     * 输出描述
         * 输出一个数，表示小团购买的方案数。
     * 样例输入
     * 8 2 5
     * 5 5 5 4 5 5 5 5
     * 样例输出
     * 5
     */

    private static int method2(int[] arr, int m, int k) {
        int re = 0;
        for(int i = 0; i <= arr.length - m; i++){
            if(arr[i] >= k){
                boolean flag = false;
                int j;
                for(j = i; j < (i+m) && j < arr.length; j++){
                    if(arr[j] < k){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    re++;
                }
            }

        }
        return re;
    }
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int re = method2(arr,m,k);
        System.out.println(re);
    }

    /**
     * 齿轮旋转
     * @param n
     * @param s
     * @return
     */
    public static int method(int n, String s){
        int re = 0;
        HashSet<String> set = new HashSet<>();
        set.add(s);
        for(int i = 0; i < n; i++){
            if(i == 0){
                s.replace(s.charAt(0),(char)(s.charAt(0) + 1));
                s.replace(s.charAt(1),(char)(s.charAt(1) - 1));
                set.add(s);
            }else if(i == (n - 1)){
                s.replace(s.charAt(n - 1),(char)(s.charAt(n - 1) + 1));
                s.replace(s.charAt(n - 2),(char)(s.charAt(n - 2) - 1));
                set.add(s);
            }else{
                s.replace(s.charAt(i),(char)(s.charAt(i) + 1));
                s.replace(s.charAt(i+1),(char)(s.charAt(i+1) - 1));
                set.add(s);
            }

        }
        re = set.size();
        return 3;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(method(n,s));
        }
    }
}
