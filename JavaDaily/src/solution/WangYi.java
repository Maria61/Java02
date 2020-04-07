package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/7 18:52
 */
class Moster implements Comparable {
    int d;
    int k;

    public Moster(int d, int k) {
        this.d = d;
        this.k = k;
    }

    @Override
    public int compareTo(Object o) {
        return this.d - ((Moster) o).d;
    }
}
public class WangYi {

    /**
     * 牛牛的等差数列
     * @param n
     * @param s
     * @return
     */
    private static int method1(int n, String s) {
        int[] array = new int[n - 1];
        String[] ss = s.split(" ");
        for(int i = 0; i < ss.length - 1; i++){
            array[i] = Math.abs(Integer.parseInt(ss[i]) - Integer.parseInt(ss[i+1]));
        }
        Arrays.sort(array);
        int re = array[0];
        int i = 1;
        for(; i < array.length && re != 0; i++){
            if(array[i] % re != 0){
                re--;
                i = 1;
            }
        }
        if(i == array.length){
            return re;
        }
        return -1;
    }

    public static void main1(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int re = method1(n,s);
            System.out.println(re);
        }
    }



    /**
     * 魔塔
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    private static int method(String s1, String s2, String s3) {
        String[] ss1 = s1.split(" ");
        String[] ss2 = s2.split(" ");
        String[] ss3 = s3.split(" ");
        int d = Integer.parseInt(ss1[1]);
        int k = 0;
        ArrayList<Moster> list = new ArrayList<>();
        for(int i = 0; i < ss2.length; i++){
            Moster m = new Moster(Integer.parseInt(ss2[i]),Integer.parseInt(ss3[i]));
            list.add(m);
        }
        Collections.sort(list);
        int index = findMid(list,d);
        for(int i = 0; i < index; i++){
            if(list.get(i).d >= d){
                k += list.get(i).k;
            }
            d += 1;
            index = findMid(list,d);
        }
        for(int i = list.size() - 1; i >= index; i--){
            if(list.get(i).d >= d){
                k += Integer.parseInt(ss3[i]);
            }
            d += 1;
            index = findMid(list,d);
        }
        return k;
    }

    private static int findMid(ArrayList<Moster> list,int d){
        int index = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).d >= d){
                index = i;
                break;
            }
        }
        return index;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            int re = method(s1,s2,s3);
            System.out.println(re);
        }
    }
}
