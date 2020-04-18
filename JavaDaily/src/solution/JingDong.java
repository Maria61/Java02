package solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/4/18 19:01
 */
public class JingDong {

    /**
     * 制造纸箱：
     * 一个长方体纸箱由六个面构成。现在给出六块纸板的长和宽，请你判断能否用这六块纸板构成一个长方体纸箱。
     * @param ss
     * @return
     */
    private static String box(String[] ss) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < ss.length; i++){
            String[] s = ss[i].split(" ");
            set.add(Integer.valueOf(s[0]));
            set.add(Integer.valueOf(s[1]));
        }
        if(set.size() > 3){
            return "IMPOSSIBLE";
        }
        int[][] array = new int[3][];
        HashMap<HashMap<Integer,Integer>,Integer> maps = new HashMap<>();
        for(int i = 0; i < ss.length; i++){
            String[] s = ss[i].split(" ");
            int a = Integer.valueOf(s[0]);
            int b = Integer.valueOf(s[1]);
            HashMap<Integer,Integer> map = new HashMap<>();
            map.put(Math.min(a,b),Math.max(a,b));
            maps.put(map,maps.getOrDefault(map,0)+1);
        }
        if(maps.size() > 3){
            return "IMPOSSIBLE";
        }else if(maps.size() == 2){
            if(!maps.values().toArray()[0].equals(2) && !maps.values().toArray()[0].equals(4)){
                return "IMPOSSIBLE";
            }
        }
        return "POSSIBLE";


    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        while(sc.hasNext()){
            String[] ss = new String[6];
            for(int i = 0; i < 6; i++){
                ss[i] = sc.nextLine();
            }
            String res = box(ss);
            System.out.println(res);
        }

    }


}
