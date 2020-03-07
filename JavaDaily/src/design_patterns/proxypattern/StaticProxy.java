package design_patterns.proxypattern;

import java.lang.reflect.Proxy;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/20 23:52
 */
public class StaticProxy {

    //静态代理
    public static void main(String[] args) {
//        Java1 java1 = new Java1();
//        Programmer programmer = new ProgrammerBigV(java1);

        Programmer programmer = new ProgrammerBigV();//透明代理
        programmer.coding();

    }


}
