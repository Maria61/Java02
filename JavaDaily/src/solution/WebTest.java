package solution;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/25 14:37
 */
public class WebTest {
    /**
     * 找出数组中出现次数为奇数个的两个数
     * @param n
     * @param s
     * @return
     */
    public static String count(int n,String s){
        HashMap<Integer,Integer> map = new HashMap<>();
        String re = new String();
        Integer[] arr = new Integer[n];
        String[] ss = s.split(" ");
        for(int i = 0; i < ss.length; i++){
            arr[i] = Integer.valueOf(ss[i]);
        }
        for(int i = 0; i < arr.length; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int[] res = new int[2];
        boolean falg = false;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() % 2 != 0){
                if(falg == false){
                    falg = true;
                    res[0] = entry.getKey();
                }else{
                    res[1] = entry.getKey();
                    break;
                }
            }
        }
        if(res[0] > res[1]){
            re += String.valueOf(res[1])+" "+String.valueOf(res[0]);
        }else{
            re += String.valueOf(res[0])+" "+String.valueOf(res[1]);
        }
        return re;
    }

    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println(count(n,s));

    }

    /**
     * 找出数组中每一个数左面离得最近的小于该数的数的下标，右面离得最近的小于该数的数的下标
     * @param n
     * @param s
     */
    public static void find(int n,String s){
        int[] arr = new int[n];
        String[] ss = s.split(" ");
        for(int i = 0; i < ss.length; i++){
            arr[i] = Integer.valueOf(ss[i]);
        }
        for(int i = 0; i < arr.length; i++){
            int left = -1;
            int right = -1;
            for(int j = i; j < arr.length; j++){
                if(arr[j] < arr[i]){
                    right = j;
                    break;
                }
            }
            for(int k = i; k >= 0; k--){
                if(arr[k] < arr[i]){
                    left = k;
                    break;
                }
            }
            System.out.println(left + " " + right);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        find(n,s);
    }


}
