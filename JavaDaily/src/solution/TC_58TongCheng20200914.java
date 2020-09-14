package solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/14 18:41
 */
public class TC_58TongCheng20200914 {

    /**
     * 统计字符串中每个字符出现的次数
     * @param s
     */
    private static void method1(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.replace(c,map.get(c) + 1);
            }else{
                map.put(c,1);
            }
        }
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            System.out.print(e.getKey()+"="+e.getValue()+" ");

        }
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        method1(s);
    }

    /**
     * 查找一个字符串中连续的在[5，8]之间的最长子串
     * @param s
     * @return
     */
    private static String method2(String s) {
        String ss = "";
        String re = "";
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - '0';
            if(c >= 5 && c <= 8){
                ss += c;
            }else{
                if(max < ss.length() && ss.length() >= 2){
                    max = ss.length();
                    re = ss;
                }
                i++;
                ss = "";
            }
        }
        if(max < ss.length() && ss.length() >= 2){
            re = ss;
        }
        return re;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(method2(s));
    }

    /**
     * 给定一叠钞票，每次只能抽最上面或者最下面的，一共抽5次，求可以抽到的最大金额
     * @param s
     * @return
     */
    public static int method3(String s){
        s = s.substring(1,s.length() - 1);
        int re = 0;
        String[] ss = s.split(",");
        if(ss.length <= 5){
            for(int i = 0; i < ss.length; i++){
                re += Integer.valueOf(ss[i]);
            }
        }else{
            for(int i = 0; i < 5; i++){
                re += Integer.valueOf(ss[i]);
            }
        }
        return re;
    }

    public static void main3(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while(sc.hasNext()){
            int i = sc.nextInt();
            s += i+",";
        }
        System.out.println(method3(s));
    }
}
