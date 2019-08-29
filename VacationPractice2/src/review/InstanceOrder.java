package review;

class Parent2{
    {
        System.out.println("A");
    }
    Parent2(){
        System.out.println("B");
    }
    {
        System.out.println("C");
    }
}
public class InstanceOrder extends Parent2{
}
