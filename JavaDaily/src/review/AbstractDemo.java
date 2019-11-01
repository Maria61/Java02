package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/11 23:13
 */
abstract class Test02 {

    public abstract void method();

    public void method2() {
        this.method();//此处的this代表的是继承该类的类，而不是该类本身
        System.out.println("抽象类内部可以有普通方法");
    }
}

public class AbstractDemo extends Test02 {

    @Override
    public void method() {
        System.out.println("实现抽象类的抽象方法");
    }
    public static void main(String[] args) {
        Test02 test02 = new AbstractDemo();
        test02.method();
        System.out.println("===========");
        test02.method2();
    }

}

