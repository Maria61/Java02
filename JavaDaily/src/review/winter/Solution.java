package review.winter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/2/12 10:14
 */
public class Solution {

    public static String longestNums(String s){
        String re = new String();
        int l = -1;
        int r = -1;
        int max = 0;

        int[] num = new int[2];
        num[0] = l;
        num[1] = r;
        boolean flag = false;

        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            if(c[i] >= '0' && c[i] <= '9' && flag == false ){
                l = i;
                flag = true;
            }
            if((c[i] < '0' || c[i] > '9' || (c[i] >= '0' && c[i] <= '9' && i == (c.length - 1))) && flag == true){
                r = i;
                flag = false;
                if(max <= (r - l)){
                    max = r - l;
                    num[0] = l;
                    num[1] = r;
                    if(c[i] >= '0' && c[i] <= '9' && r == c.length - 1){
                        num[1] = r + 1;
                    }
                }

            }
        }
        if(l != -1 && r != -1){
            re = s.substring(num[0],num[1]);
        }
        return re;
    }

    public static String longestNums1(String s) {
        int tempMax = 0;
        int max = 0;
        String result = "";
        char[] ch = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (Character.isDigit(ch[i])) {//isDigit 判断该字符是否是数字
                sb.append(ch[i]);
                tempMax++;
            } else {
                tempMax = 0;
                sb.delete(0, sb.length());
            }
            if (max < tempMax) {
                max = tempMax;
                result = sb.toString();
            }

        }
        return result;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> re = new ArrayList<>();
        sort(input,k);
        for(int i = 0; i < k; i++){
            re.add(input[i]);
        }
        return re;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        if (k > input.length) {
            return null;
        }
        ArrayList<Integer> re = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] < input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
            re.add(input[input.length - i - 1]);
        }
        return re;
    }

    private void sort(int[] input,int k){
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input.length - 1 - i; j++) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }


//    public static void main(String[] args) {
////        String s = "asdfg";
//        Solution solution = new Solution();
////        System.out.println(solution.longestNums(s));
//
//        int[] array = {9, 8, 7, 6, 5};
//        System.out.println(solution.GetLeastNumbers_Solution1(array,3));
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            System.out.println(longestNums(str));
        }
    }
}
