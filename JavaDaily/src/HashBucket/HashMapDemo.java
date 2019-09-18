package HashBucket;

import BinarySearchTree.Card;
import BinarySearchTree.MaJiang;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/18 15:22
 */

/**
 * 对于HashMap和HashSet来说，应用时该类一定要覆写过hashCode 和 equals方法，否则结果不对
 */
public class HashMapDemo {
    public static void main(String[] args) {


        Card c1 = new Card(1, "♠");
        Card c2 = new Card(1, "♠");
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());

        HashSet<Card> set = new HashSet<>();
        set.add(c1);
        System.out.println(set.contains(c2));

        HashMap<Card, String> map = new HashMap<>();
        map.put(c1, "黑桃A");
        System.out.println(map.get(c2));

        MaJiang m1 = new MaJiang("万", "一");
        MaJiang m2 = new MaJiang("万", "一");
        System.out.println(m1.hashCode());
        System.out.println(m2.hashCode());

        HashSet<MaJiang> setm = new HashSet<>();
        setm.add(m1);
        System.out.println(setm.contains(m2));

        HashMap<MaJiang, String> mapm = new HashMap<>();
        mapm.put(m1, "一万");
        System.out.println(mapm.get(m2));

    }
}
