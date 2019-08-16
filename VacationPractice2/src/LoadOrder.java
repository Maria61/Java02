class Parent{
    static {
        System.out.println("A");
    }

    static {
        System.out.println("B");
    }
}
public class LoadOrder extends  Parent{
    public static void init(){

    }
}
