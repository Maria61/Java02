package solution;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/16 19:51
 */
public class MeiCai20200916 {
    /**
     * 字符串转整数
     * @param s
     * @return
     */
    public static int method(String s){
        int re = 0;
        s = s.trim();
        char c = s.charAt(0);
        if(c != '+' && c != '-' && (c < '0' || c > '9')){
            return 0;
        }
        boolean flag = false;
        if(c == '-'){
            flag = true;
        }
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                continue;
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                re = re * 10 +(s.charAt(i) - '0');
            }else{
                break;
            }
        }
        if(flag == true){
            return -re;
        }
        int max = (int)Math.pow(2,31) - 1;
        int min = -(max + 1);
        if(re > max){
            return max;
        }else if(re < min){
            return min;
        }
        return re;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(method(s));
//        System.out.println(" asd ".trim());
    }
}
