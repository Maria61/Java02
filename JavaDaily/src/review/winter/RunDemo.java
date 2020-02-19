package review.winter;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/1/7 12:51
 */
class Cat{
    public static void sleep(){
        System.out.println("呼噜~");
    }

    public void sleep1(){
        System.out.println("huhululu");
    }
}

public class RunDemo {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sleep();
//        Cat.sleep1();


    }
}
