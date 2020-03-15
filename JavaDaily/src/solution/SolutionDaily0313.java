package solution;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/15 18:40
 */
public class SolutionDaily0313 {

    /**
     * 字符串加解密
     * @param s
     * @return
     */
    public static String encrypt(String s){
        String re = new String();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= '0' && chars[i] <= '8'){
                re += String.valueOf((char)(chars[i]+1));
            }else if(chars[i] == '9'){
                re += String.valueOf((char)('0'));
            }else if(chars[i] >= 'A' && chars[i] <= 'Y'){
                re += String.valueOf((char)(chars[i] + 1 + ('a' - 'A')));
            }else if(chars[i] == 'Z'){
                re += String.valueOf((char)('a'));
            }else if(chars[i] >= 'a' && chars[i] <= 'y'){
                re += String.valueOf((char)(chars[i] + 1 - ('a' - 'A')));
            }else if(chars[i] == 'z'){
                re += String.valueOf((char)('A'));
            }
        }
        return re;
    }

    public static String unEncrypt(String pa){
        String re = new String();
        char[] chars = pa.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] >= '1' && chars[i] <= '9'){
                re += String.valueOf((char)(chars[i]-1));
            }else if(chars[i] == '0'){
                re += String.valueOf((char)('9'));
            }else if(chars[i] >= 'B' && chars[i] <= 'Z'){
                re += String.valueOf((char)(chars[i] - 1 + ('a' - 'A')));
            }else if(chars[i] == 'A'){
                re += String.valueOf((char)('z'));
            }else if(chars[i] >= 'b' && chars[i] <= 'z'){
                re += String.valueOf((char)(chars[i] - 1 - ('a' - 'A')));
            }else if(chars[i] == 'a'){
                re += String.valueOf((char)('Z'));
            }
        }
        return re;
    }

    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(encrypt(s));
            String pa = sc.nextLine();
            System.out.println(unEncrypt(pa));
        }
    }

    /**
     * 日期到天数的转换
     * @param year
     * @return
     */
    public static boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        }
        if((year % 4 == 0) && (year % 100 != 0)){
            return true;
        }
        return false;
    }

    public static int getOutDay(int year,int month,int day){
        if(year <= 0 ||month > 13 || day > 31 || month <= 0 || day <= 0){
            return -1;
        }
        if(month == 2){
            if(!isLeapYear(year)){
                if(day > 28){
                    return -1;
                }
            }else{
                if(day > 29){
                    return -1;
                }
            }
        }
        int sum = 0;
        HashSet<Integer> big = new HashSet<>();
        big.add(1);
        big.add(3);
        big.add(5);
        big.add(7);
        big.add(8);
        big.add(10);
        big.add(12);
        HashSet<Integer> small = new HashSet<>();
        small.add(4);
        small.add(6);
        small.add(9);
        small.add(11);
        if(small.contains(month)){
            if(day > 30){
                return -1;
            }
        }
        for(int i = 1; i < month; i++){
            if(big.contains(i)){
                sum += 31;
            }else if(small.contains(i)){
                sum += 30;
            }else if(i == 2){
                if(isLeapYear(year)){
                    sum += 29;
                }else{
                    sum += 28;
                }
            }
        }
        return sum + day;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            System.out.println(getOutDay(year,month,day));
        }
    }
}
