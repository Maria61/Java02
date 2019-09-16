package BinarySearchTree;

import java.util.TreeMap;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/16 19:25
 */
public class TreeMapDemo {
    public static void main(String[] args) {
        MaJiang m1 = new MaJiang("万", "一");
        MaJiang m2 = new MaJiang("万", "一");
        TreeMap<MaJiang, String> map = new TreeMap<>();
        map.put(m1, "胡了");
        System.out.println(map.get(m2));
    }
}
