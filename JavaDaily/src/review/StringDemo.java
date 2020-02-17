package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/2/15 11:31
 */
public class StringDemo {
    public static boolean isAdmin(String userId){
        String s = userId.toLowerCase();
        System.out.println(s);
        return userId.toLowerCase()=="admin";//toLowerCase()方法的返回值是String类型的对象
    }


    public static void main(String[] args) {
//        String s = new String("asdf");
//        String s1 = "asdf";
//        System.out.println(s =="asdf");//false,s是对象，“asdf”是字符串常量,不是同一对象
//        System.out.println(s1 == "asdf");//true,s1引用指向了字符串常量“asdf”,对等
//        System.out.println(isAdmin("Admin"));



        String s1 = "Hello";//常量池（方法区中）
        String s2 = "Hello";//同上，且s1和s2指向同一个字符串常量
        String s3 = "Hel" + "lo";//+操作，会自动优化为Hello，常量池中有Hello字符串常量，s3直接指向它
        String s4 = "Hel" + new String("lo");//+操作优化后，在堆区创建了新的对象“Hello”
        String s5 = new String("Hello");//在常量池中（如果没有）和堆区都创建新的对象
        //intern()方法：首先在常量池中查找是否存在一份equal相等的字符串如果有的话就返回该字符串的引用，
        // 没有的话就将它加入到字符串常量池中
        String s6 = s5.intern();//引用指向常量池中的“Hello”
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;//动态调用，通过+操作返回一个新的对象在堆区

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true



//        StringBuilder sb = new StringBuilder("asdf");
//        StringBuilder sb1 = new StringBuilder("asdf");
//        String s = "asdf";
//        System.out.println(sb.equals(sb1));//false,StringBuilder没有覆写equals方法和hashcode方法
//        System.out.println(sb == sb1);//false
//        System.out.println(s.equals(sb));//false
//        System.out.println(sb.equals(s));//false
//
//        StringBuffer sbf = new StringBuffer("asdf");
//        System.out.println(sbf.equals("asdf"));//false,原因如上

    }
}
