package net;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/12/17 19:38
 */
public class Test {
    public static void main(String[] args) {
        //getClassLoader() 取得该Class对象的类装载器
        //getResource(目标文件)在classpath根目录下找（不会递归查找子目录）
        System.out.println(
                Test.class.getClassLoader().getResource("login.html"));
        System.out.println(Test.class.getResource("../login.html"));
    }
}
