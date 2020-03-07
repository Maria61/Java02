package design_patterns.proxypattern;

import java.lang.reflect.Proxy;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/22 10:06
 */
public class DynamicProxy {

    //动态代理
    public static void main(String[] args) {
        Java1 java1 = new Java1();

        Programmer programmerWaterArmy = (Programmer) Proxy.newProxyInstance(java1.getClass().getClassLoader(),java1.getClass().getInterfaces(),(proxy, method, args1) -> {
            if(method.getName().equals("coding")){
                method.invoke(java1,args);
                System.out.println("水军点赞！！！");
            }else{
                return method.invoke(java1,args);
            }
            return null;
        });

        programmerWaterArmy.coding();
    }
}
