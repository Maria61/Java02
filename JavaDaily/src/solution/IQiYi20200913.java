package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/13 15:16
 */
public class IQiYi20200913 {

    /**
     * 多数元素
     * @param s
     * @return
     */
    private static String method1(String s) {
        String re = "";
        String[] ss = s.split(" ");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i = 0; i < ss.length; i++){
            if(map.containsKey(ss[i])){
                map.replace(ss[i],map.get(ss[i])+1);
            }else{
                map.put(ss[i],1);
            }
        }
        int max = 0;
        for(Map.Entry<String,Integer> e : map.entrySet()){
            if(e.getValue() > max){
                max = e.getValue();
                re = e.getKey();
            }
        }
        return re;
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(method1(s));
    }

    /**
     * 无重复字符的最长子串的长度
     * @param s
     * @return
     */
    private static int method2(String s) {
        int re = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    re = Math.max(re,set.size());
                    set.clear();
                }else{
                    set.add(s.charAt(j));
                }
            }

        }
        re = Math.max(re,set.size());
        return re;
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(method2(s));
    }

    /**
     * 三数之和：
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     * @param s
     * @return
     */
    private static ArrayList<String> method3(String s) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        String[] ss = s.split(" ");
        int[] arr = new int[ss.length];
        for(int i = 0; i < ss.length; i++){
            arr[i] = Integer.valueOf(ss[i]);
        }
        int[] num = new int[3];
        for(int i = 0; i < arr.length; i++){
            int flag = 1;
            int sum = arr[i];
            num[0] = arr[i];
            for(int j = i+1; j < arr.length; j++){
                sum += arr[j];
                flag++;
                num[flag - 1] = arr[j];
                if(flag == 3){
                    if(sum == 0) {
                        Arrays.sort(num);
                        String s1 = "";
                        s1 += num[0] + " ";
                        s1 += num[1] + " ";
                        s1 += num[2];
                        if (!set.contains(s1)) {
                            set.add(s1);
                            list.add(s1);
                        }
                    }
                    sum = arr[i];
                    flag = 1;
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ArrayList<String> re = method3(s);
        for(int i = 0; i < re.size(); i++){
            System.out.println(re.get(i));
        }
    }
}
