package binarysearchtree;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/16 19:25
 */

/**
 * 对于TreeMap和TreeSet 应用时需要该类覆写comparaTo方法，eg:Majiang
 * 或者传入一个Comparator对象，该对象要求覆写过 compare 方法  eg:Card
 */

class CardComparator implements Comparator<Card> {

    @Override
    public int compare(Card o1, Card o2) {
        return o1.value - o2.value;

    }
}
public class TreeMapDemo {


    public static void main(String[] args) {
//        MaJiang m1 = new MaJiang("万", "一");
//        MaJiang m2 = new MaJiang("万", "一");
//        TreeMap<MaJiang, String> map = new TreeMap<>();
//        map.put(m1, "胡了");
//        System.out.println(map.get(m2));
//


        Card c1 = new Card(1, "黑桃");
        Card c2 = new Card(1, "黑桃");

        CardComparator comptor = new CardComparator();

        //不传入Comparator类对象会报错,除非该泛型类覆写了comparaTo方法
        TreeSet<Card> set = new TreeSet<>(comptor);
        set.add(c1);
        System.out.println(set.contains(c2));


        TreeMap<Card, String> map = new TreeMap<Card, String>(comptor);
        map.put(c1, "黑桃A");
        System.out.println(map.get(c2));


    }
}
