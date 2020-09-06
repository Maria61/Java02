package solution;

import java.util.*;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/9/6 19:23
 */
class MyLinkedList{
    int value;
    MyLinkedList next;
    public MyLinkedList(int value){
        this.value = value;
        this.next = null;
    }
}
public class TengXun20200906 {
    /**
     * 链表的公共部分（公共子序列，可以不连续）
     * @param a
     * @param b
     * @return
     */
    private static String method(String a, String b) {
        MyLinkedList la = null;
        MyLinkedList lb = null;
        MyLinkedList cur = null;
        String[] aa = a.split(" ");
        String[] bb = b.split(" ");
        for(int i = 0; i < aa.length; i++){
            int v = Integer.valueOf(aa[i]);
            if(la == null){
                la = new MyLinkedList(v);
                cur = la;
            }else{
                MyLinkedList next = new MyLinkedList(v);
                cur.next = next;
                cur = next;
            }
        }
        for(int i = 0; i < bb.length; i++){
            int v = Integer.valueOf(bb[i]);
            if(lb == null){
                lb = new MyLinkedList(v);
                cur = lb;
            }else{
                MyLinkedList next = new MyLinkedList(v);
                cur.next = next;
                cur = next;
            }
        }
        MyLinkedList cur1 = null;
        if(aa.length > bb.length){
            cur = lb;
            cur1 = la;
        }else{
            cur = la;
            cur1 = lb;
        }
        String re = "";
        int i = 0;
        while(cur != null){
            if(judge(cur.value,i,cur1)){
                re += cur.value+" ";
                i++;
                cur = cur.next;
            }
        }
        return re.trim();
    }

    public static boolean judge(int value,int x,MyLinkedList l){
        MyLinkedList cur = l;
        for(int i = 0; i < x; i++){
            if(cur != null){
                cur = cur.next;
            }
        }
        while(cur != null){
            if(cur.value == value){
                return true;
            }else{
                cur = cur.next;
            }
        }
        return false;
    }

    public static String method1(String a,String b){
        String[] aa = a.split(" ");
        String[] bb = b.split(" ");
        int min = Math.min(aa.length,bb.length);
        int flag = 0;
        String re = "";
        if(aa.length < bb.length){
            for(int i = 0; i < aa.length; i++){
                int v = Integer.valueOf(aa[i]);
                for(int j = flag; j < min; j++){
                    if(v == Integer.valueOf(bb[j])){
                        flag = j+1;
                        break;
                    }
                }
                re += aa[i]+" ";
            }
        }else{
            for(int i = 0; i < bb.length; i++){
                int v = Integer.valueOf(bb[i]);
                for(int j = flag; j < min; j++){
                    if(v == Integer.valueOf(aa[j])){
                        flag = j+1;
                        break;
                    }
                }
                re += bb[i]+" ";
            }
        }

        return re.trim();
    }

    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        int y = sc.nextInt();
        sc.nextLine();
        String b = sc.nextLine();
        String re = method1(a,b);
        System.out.println(re);
//        String s = "1234 1234 234 ";
//        System.out.println(s);
//        System.out.println(s.trim());
    }

    /**
     * 通知传递
     * @param arr
     * @return
     */
    private static int method2(String[] arr) {
        ArrayList<HashSet<Integer>> arrayList = new ArrayList<>();
        String s = "";
        int re = 0;
        for(int i = 0; i < arr.length; i++){
            HashSet<Integer> set = new HashSet<>();
            String[] arr1 = arr[i].split(" ");
            for(int j = 0; j < arr1.length; j++){
                set.add(Integer.valueOf(arr1[i]));
                if(Integer.valueOf(arr1[i])==0){
                    s += "i" +" ";
                }
            }
            arrayList.add(set);
        }
        String[] ss = s.split(" ");
        for(int i = 0; i < ss.length; i++){
            int j = Integer.valueOf(ss[i]);
            HashSet<Integer> set = arrayList.get(j);
            re += set.size();
            for(Integer e : set){

            }
        }

        return re;
    }

    public static void main2(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.valueOf(ss[1]);
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }
        System.out.println(method2(arr));
    }

    /**
     * 字符串次数
     * @param arr
     * @param m
     */
    private static void method3(String[] arr, int m) {
        TreeMap<String,Integer> map = new TreeMap<>();
        for(int i = 0; i < arr.length; i++){
            map.replace(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        int max = 0;
        String s = "";
        for(Map.Entry<String,Integer> entry : map.entrySet()){
            if(entry.getValue() > max){
                s = entry.getKey();
            }else if(entry.getValue() == max){
                for(int i = 0; i < Math.min(s.length(),entry.getKey().length()); i++){
                    if(s.charAt(i) > entry.getKey().charAt(i)){
                        s = entry.getKey();
                    }else if(s.charAt(i) < entry.getKey().charAt(i)){
                        break;
                    }
                }
            }
        }
        s += " "+map.get(s);
        System.out.println(s);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] ss = s.split(" ");
        int n = Integer.valueOf(ss[0]);
        int m = Integer.valueOf(ss[1]);
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }
        method3(arr,m);
    }
}

