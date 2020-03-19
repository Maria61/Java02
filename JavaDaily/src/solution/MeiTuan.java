package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/19 18:26
 */
public class MeiTuan {
    /**
     * 炸银花
     * @param s1
     * @param s2
     * @return
     */
    public static int win(String s1, String s2) {
        int re = 0;
        String[] sa1 = s1.split(" ");
        String[] sa2 = s2.split(" ");
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        for(int i = 0; i < sa1.length; i++){
            a1.add(Integer.valueOf(sa1[i]));
            a2.add(Integer.valueOf(sa2[i]));
        }
        Collections.sort(a1);
        Collections.sort(a2);
        int l1 = a1.size();
        int l2 = a2.size();
        int max1 = a1.get(l1-1)+a1.get(l1-2)+a1.get(l1-3);
        int max2 = a2.get(l2-1)+a2.get(l2-2)+a2.get(l2-3);
        re = Math.max(max1,max2);
        return re;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            System.out.println(win(s1,s2));
        }
    }


    /**
     * 最长升序字串
     * @param s
     * @return
     */
    public static int maxLength(String s) {
        int max = 0;
        int l = 0;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) <= s.charAt(i + 1)){
                l++;
            }else{
                max = Math.max(l,max);
                l = 0;
            }
        }
        max = Math.max(l,max);
        return max+1;

    }

    /**
     * 将给定区域内的0变为1，1变为0
     * @param s 原字符串
     * @param s1 操作数，eg: c 1 3
     * @return
     */
    public static String change(String s, String s1) {
        String[] sa = s1.split(" ");
        if(!sa[0].equals("c")){
            return s;
        }
        int x = Integer.parseInt(sa[1]) - 1;
        int y = Integer.parseInt(sa[2]) - 1;
        String half = new String();
        for(int i = x; i <= y; i++){
            if(s.charAt(i) == '0'){
                half += String.valueOf('1');
            }else if(s.charAt(i) == '1'){
                half += String.valueOf('0');
            }
        }
        s = s.substring(0,x) + half + s.substring(y+1);
        return s;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String nm = sc.nextLine();
            String s = sc.nextLine();
            String[] nms = nm.split(" ");
            int m = Integer.valueOf(nms[1]);
            while(m > 0){
                String s1 = sc.nextLine();
                if(s1.length() == 1 && s1.equals("q")){
                    System.out.println(maxLength(s));
                }else if(s1.length() == 5){
                    s = change(s,s1);
                    System.out.println("s="+s+";s1="+s1);
                }
                m--;
            }
        }
    }

    /**
     * 删除1个字符后该串的升序字串长度最大，求最大字串
     * @param s
     * @return
     */
    public static int bestMethod(String s) {
        String s1 = new String();
        int max = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != ' '){
                s1 += String.valueOf(s.charAt(i));
            }
        }
        for(int i = 0; i < s1.length(); i++){
            String sn = s1.substring(0,i)+s1.substring(i+1);
            l = maxLength(sn);
            max = Math.max(max,l);
        }
        max = Math.max(max,l);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            System.out.println(bestMethod(s));

        }
    }
}
