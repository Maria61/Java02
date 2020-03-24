package advance.data_structure;

import java.util.ArrayList;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/24 19:43
 */
public class Iterator {

    public static ArrayList<String> LIST = new ArrayList<>();
    static{
        LIST.add("A");
        LIST.add("B");
        LIST.add("C");
        LIST.add("C");
        LIST.add("D");
    }

    public static void test1(){
        int i = 0;
        //不被允许的！在遍历的时候不可以删除元素
        for(String s : LIST){
            if(i == 2){
                LIST.remove(2);
            }else{
                System.out.println(s);
            }
            i++;
        }
    }
    public static void test2(){
        int i = 0;
        java.util.Iterator<String> it = LIST.iterator();
        //可以使用迭代器进行操作
        while(it.hasNext()){
            String s = it.next();//1
            if(i == 2){
                it.remove();//和LIST.remove(index)的区别
            }else{
                System.out.println(s);
//                System.out.println(it.next());//如果用这一句，去掉“1”行，就无法成功删除，？
            }
            i++;
        }
    }

    public static void main(String[] args) {
//        test1();
        test2();
    }
}
