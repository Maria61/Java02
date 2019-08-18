package Collection;
import java.util.*;
public class CollectionDemo {
    public static void main(String[] args){
        Collection<String> list = new ArrayList<>();
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println("====================");
        list.add("2019");
        ((ArrayList<String>) list).add("08");
        ((ArrayList<String>) list).add("18");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        Object[] array = list.toArray();
        System.out.println(Arrays.toString(array));
        for (String s:list) {
            System.out.println(s);
        }
        list.remove("08");
        Object[] array1 = list.toArray();
        System.out.println(Arrays.toString(array1));
        System.out.println(list.contains("08"));
        System.out.println(list.contains("18"));
        list.clear();
        Object[] array2 = list.toArray();
        System.out.println(Arrays.toString(array2));
        System.out.println("=======================");


    }
}
