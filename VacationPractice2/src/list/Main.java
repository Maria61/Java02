package list;

import java.util.Arrays;

public class Main {
    private static void testList(List list){

    }

    public static void main(String[] args){
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(1,2);
        System.out.println(Arrays.toString(myArrayList.array));
    }
}
