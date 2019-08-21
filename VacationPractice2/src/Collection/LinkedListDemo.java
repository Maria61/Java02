package Collection;

import java.util.LinkedList;
import java.util.List;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @date 2019-08-20 12:25
 */
public class LinkedListDemo {
    public static void main(String[] args){
        List<String> list = new LinkedList<>();
        list.add("hahahaha");
        list.add("hehehehe");
        list.add("huhuhuhu");
        System.out.println(((LinkedList<String>) list).pop());
        System.out.println(((LinkedList<String>) list).peek());
        System.out.println(((LinkedList<String>) list).poll());
    }
}
