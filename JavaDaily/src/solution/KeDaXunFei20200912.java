package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/12 19:30
 */
public class KeDaXunFei20200912 {
    /**
     * 存储空间，将连续相等的字符用数字+字符代替
     * eg：aaabbs-->3a2bs
     * @param s
     * @return
     */
    public static String method(String s){
        String re = "";
        for(int i = 0,j = 1; i < s.length() && j < s.length();){
            int count = 1;
            if(s.charAt(i) == s.charAt(j)){
                while(j < s.length() && s.charAt(i) == s.charAt(j)){
                    count++;
                    j++;
                }
                re += count;
                re += s.charAt(i);
                i = j;
                j = j + 1;
            }else{
                re += s.charAt(i);
                i++;
                j = i + 1;
            }
            if(j == s.length()){
                re += s.charAt(i);
                break;
            }
        }
        return re;
    }
    public static void main2(String[] args) {
        System.out.println(method("aaaaa"));
    }

    /**
     * 蜗牛从旗杆上滑落
     * 每天滑落当前距离的1/2后，再滑落当前天数的3的斐波那契数
     * 已知滑落天数，求旗杆高度
     * @param n
     * @return
     */
    public static int fabi(int n){
        if(n == 1){
            return 3;
        }
        if(n == 2){
            return 3;
        }

        return fabi(n - 1)+fabi(n - 2);
    }

    public static int method1(int n){
        int re = 0;
        re += fabi(n);
        for(int i = 0; i < n; i++){
//            re
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(method1(n));
    }
}
