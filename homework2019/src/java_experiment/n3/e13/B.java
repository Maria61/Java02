package java_experiment.n3.e13;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/27 21:37
 */
public class B extends A{
    void g(){
        System.out.println("实验三");
    }
    public static void main(String[] args) {
        B b =  new B();
        b.g();
        b.f();
    }
}

class A {
    void f(){
        System.out.println("abc");
    }
}
