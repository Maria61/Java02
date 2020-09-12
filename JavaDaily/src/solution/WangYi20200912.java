package solution;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/12 14:41
 */
public class WangYi20200912 {
    /**
     * 特征排列组合
     * 给出n组特征，每组特征值m个，每组m不同，求全排列
     */
    public static void method1(String[] arr){
        for(int i = 0; i < arr.length; i++){
            String[] ss = arr[i].split(" ");
            for(int j = 0; j < ss.length; j++){

            }
        }
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }
        method1(arr);
    }

    private static boolean isHuiWei1(String s) {
        String re = "";
        for(int i = s.length() - 1; i >= 0; i--){
            re += s.charAt(i);
        }
        if(re.equals(s)){
            return true;
        }
        return false;
    }
    private static boolean isHuiWei(String s) {
        int i = 0;
        int j = s.length() - 1;
        while(i <= j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    /**
     * 最多的回文
     */
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int re = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = i + 2; j <= s.length(); j++){
                if(isHuiWei(s.substring(i,j))){
                    re++;
                }
            }
        }
        System.out.println(re);
    }

    private static int method3(String s1, String s2, String s3) {
        int re = 0;
        HashSet<String> set = new HashSet<>();
        String[] ss1 = s1.split(" ");
        for(int i = 0; i < ss1.length; i++){
            set.add(ss1[i]);
        }
        String[] ss3 = s3.split(" ");
        for(int i = 0; i < ss3.length; i++){
            int n = s2.indexOf(ss3[i]);
            if(n == -1){
                if(!set.contains(ss3[i])){
                    re++;
                }
            }
        }
        String[] ss2 = s2.split(" ");
        int flag = Math.abs(ss3.length - ss2.length);
        int flag2 = 0;
        for(int i = 0; i < ss2.length; i++){
            if(flag == flag2){
                break;
            }
            if(set.contains(ss2[i])){
                flag2++;
            }
        }
        re += flag - flag2;
        return re;
    }

    private static int method(String s1, String s2, String s3) {
        int re = 0;
        HashSet<String> set = new HashSet<>();
        String[] ss1 = s1.split(" ");
        for(int i = 0; i < ss1.length; i++){
            set.add(ss1[i]);
        }
        String[] ss3 = s3.split(" ");
        for(int i = 0; i < ss3.length; i++){
            int n = s2.indexOf(ss3[i]);
            if(n == -1){
                if(!set.contains(ss3[i])){
                    re++;
                }
            }
        }
        String[] ss2 = s2.split(" ");
//        for(int i = 0; i < ss3.length; i++){
//            if(!ss3[i].equals(ss2[i])){
//
//            }
//        }
        int flag = Math.abs(ss3.length - ss2.length);
        int flag2 = 0;
        if(ss2.length > ss3.length){
            for(int i = 0; i < ss2.length; i++){
                if(flag == flag2){
                    break;
                }
                if(set.contains(ss2[i])){
                    flag2++;
                }
            }
            re += flag - flag2;
        }else if(ss3.length > ss3.length){
            for(int i = 0; i < ss3.length; i++){
                if(flag == flag2){
                    break;
                }
                if(set.contains(ss3[i])){
                    flag2++;
                }
            }
            re += flag - flag2;
        }
        return re;
    }

    /**
     * 特殊的编辑距离
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        String s3 = sc.nextLine();
        int re = method(s1,s2,s3);
        System.out.println(re);
    }
}
