package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @date 2019-08-20 10:03
 */
public class Main {

    public static void swap( List<PokeCard> list, int i, int j){
        PokeCard tmpI = list.get(i);
        PokeCard tmpJ = list.get(j);
        list.set(i,tmpJ);
        list.set(j,tmpI);

    }

    public static void main(String[] args){
        ArrayList<PokeCard> cards = new ArrayList<>(52);
        String[] type = {"♥","♦","♠","♣"};

        /**
         * 生成纸牌
         */
        for(int i = 0; i < 4; i++){
            for(int j = 1; j <= 13; j++){
                PokeCard card = new PokeCard(j, type[i]);
                cards.add(card);
            }
        }
        System.out.println(cards);
        /**
         *
         * 洗牌
         */
        Random random = new Random(20190820);
        for(int i = 51; i > 0; i--){
            swap(cards, i,random.nextInt(i));
        }
        System.out.println(cards);



        List<PokeCard> a = new ArrayList<>(5);
        List<PokeCard> b = new ArrayList<>(5);
        List<PokeCard> c = new ArrayList<>(5);

        /**
         * 取牌
         */
        for(int  i = 0; i < 15; i++){
            PokeCard card = cards.remove(cards.size()-1);
            switch (i % 3){
                case 0:
                    a.add(card);
                    break;
                case 1:
                    b.add(card);
                    break;
                case 2:
                    c.add(card);
                    break;
            }
        }

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        PokeCard hreatA = new PokeCard(12,"♥");
//        等同于contains()方法
//        for(PokeCard p : a){
//            if(p.equals(hreatA)){
//                System.out.println("包含");
//                return;
//            }
//        }
//        System.out.println("不包含");
//
        if(a.contains(hreatA)){//要调用contains方法，必须覆写equals方法,否则判断的是两个引用是否指向同一对象
            System.out.println("包含");
        }else{
            System.out.println("不包含");
        }


    }




}
