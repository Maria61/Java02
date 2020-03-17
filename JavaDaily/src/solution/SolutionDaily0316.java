package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/17 20:09
 */
public class SolutionDaily0316 {
    /**
     * 驼峰式命名法
     * @param s
     * @return
     */
    public static String changeName(String s){
        char[] chars = s.toCharArray();
        String re = new String();
        boolean flag = false;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '_'){
                flag = true;
            }else if(flag == true){
                re += String.valueOf((char)(chars[i]-('a' - 'A')));
                flag = false;
            }else{
                re += String.valueOf(chars[i]);
            }
        }
        return re;
    }
    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(changeName(s));
        }
    }

    /**
     * 中级单词倒排 90%
     * @param s
     * @return
     */
    public static String reverse(String s){
        String[] sa = s.split(" ");
        String re = new String();
        for(int i = sa.length - 1; i >= 0; i--){
            re += " "+sa[i];
        }
        return re.substring(1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(reverse(s));
        }
    }
}
