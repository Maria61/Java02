package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/17 19:27
 */
public class JingDong20200917 {
    /**
     * 找出文章中可能出现的年份：1000~3999之间
     * @param s
     * @return
     */
    private static String method1(String s) {
        String[] arr = s.split(" ");
        String re = "";
        for(int i = 0; i < arr.length; i++){
            String ss = "";
            for(int j = 0; j < arr[i].length(); j++){
                char c = arr[i].charAt(j);
                if(c >= '0' && c <= '9'){
                    ss += c;
                }
            }
            if(ss.length() == 4){
                int n = Integer.valueOf(ss);
                if(n >= 1000 && n <= 3999){
                    re += n+" ";
                }
            }
        }
        return re.trim();
    }
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(method1(s));
    }

    /**
     * 一只虫子掉到枯井里，它每天白天都会向上爬n厘米，但是晚上休息时会下降若干厘米。
     * 通过分析发现，第1天晚上虫子会下降n/2厘米，第2天晚上虫子会下降(n/2+n/4)厘米，
     * 第3天晚上虫子会下降(n/2+n/4+n/8)厘米，......，以此类推。
     * 如果井的深度为m米，请问这只努力的虫子第几天能够爬出枯井？
     * @param n
     * @param m
     * @return
     */
    private static int method2(int n, int m) {
        int re = 0;
        m = m*100;
        int sum = 0;
        int x = n/2;
        int y = x;
        while(true){
            sum += n;
            re++;
            if(sum >= m){
                break;
            }
            sum -= y;
            x = x/2;
            y += x;
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(method2(n,m));
    }
}
