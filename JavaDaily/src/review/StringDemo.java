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
        String s = new String("asdf");
        String s1 = "asdf";
        System.out.println(s =="asdf");//false,s是对象，“asdf”是字符串常量,不是同一对象
        System.out.println(s1 == "asdf");//true,s1引用指向了字符串常量，“asdf”也是字符串常量，对等
        System.out.println(isAdmin("Admin"));
    }
}
