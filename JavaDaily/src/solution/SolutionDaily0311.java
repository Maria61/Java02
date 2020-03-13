package solution;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/12 21:05
 */
public class SolutionDaily0311 {
    /**
     * 反转字符串
     * @param sentence
     * @return
     */
    public static String reverse(String sentence){
        String[] sa = sentence.split(" ");
        String re = new String();
        for(int i = (sa.length - 1); i >= 0; i-- ){
            re += sa[i]+" ";
        }
        return re;
    }

    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        while(sc.hasNext()){
//            String s = sc.nextLine();
//            System.out.println(reverse(s));
//        }

        /**
         * 删除字符串中的相关字符-测试
         */
        String s = "asdff";
        System.out.println(s.contains("a"));
        HashSet<Character> set = new HashSet<>();
        s.replace("a","");
        System.out.println(s);
        StringBuilder sb = new StringBuilder(s);
        sb.deleteCharAt(s.indexOf("a"));
        System.out.println(sb);
        char d = 'd';
        set.contains("a");
    }
}
