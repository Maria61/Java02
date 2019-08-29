package review;

class Parent{
    static {
        System.out.println("A");
    }

    static {
        System.out.println("B");
    }

}

public class LoadOrder extends  Parent{
    private static int initB(){
        System.out.println(1);
        return 0;
    }

    static int a = initA();

    static{
        System.out.println(2);
    }

    private static int initA(){
        System.out.println(3);
        return 0;
    }

    private static int initC(){
        System.out.println(5);
        return 0;
    }

    static {
        System.out.println(4);
    }

    public static void main(String[] args){
        //不会再触碰类的加载，已经在内存里了；
        LoadOrder.a = 0;
    }

}
