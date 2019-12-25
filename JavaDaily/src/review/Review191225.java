package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/25 15:24
 */
abstract class C {
    public void method() {
        System.out.println("sadfsa");
    }
}

interface D {
    public void method();

    static void method1() {

    }
}

class A {
    public void method() {
        System.out.println("A中的方法");
    }

    public static void method1() {
        System.out.println("A的静态方法");
    }
}

class B extends A {
    public void method() {
        System.out.println("B中的方法");
    }

    public static void method1() {
        System.out.println("B的静态方法");
    }
}
public class Review191225 {
    public static void main(String[] args) {

        //char类型定义以及字符转换
//        char ch = (char)true;//boolean不能转化为char
//        char ch1 = 'sadfaf';//字符文字中字符太多
//        char ch3 = '\111';
//        System.out.println(ch3);
//        char ch4 = '\'';
//        System.out.println(ch4);
////        char ch5 = '';//空字符文字不可以！
//        String s = "";
//        System.out.println("sadf"+s+"dfaf");
//        char ch6 = '/';
//        System.out.println(ch6);
//        char ch7 = '\\';
//        System.out.println(ch7);
//        char ch8 = '\\\';//非法结尾

        //运算优先级
//        int i = 4;
//        int j = 2;
//        i = method(i,j);
//        System.out.println(i);

        //多态
        A a = new B();
       /*赋值以引用类型为准
       B b = a;*/
        A b = new B();
        //调用以对象类型为准
        b.method();
        /*编译通过但会抛异常
        B b = (B)new A();
        b.method();
        */
        B.method1();
        //静态方法调用以引用类型为准
        b.method1();


    }

    static public int method(int i, int j) {
        i += ++j;
        return i;
    }
}
