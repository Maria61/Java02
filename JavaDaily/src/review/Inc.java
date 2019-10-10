package review;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/10 20:24
 */
public class Inc {
    public static void main(String[] args) {
        Inc inc = new Inc();
        int i = 0;
        inc.f(i);
        i = i++;
        //i++的表达式的结果为0，++优先级高于 = ，因此先执行++，执行之后i的值为1，
        // 但此时表达式的值是不变的，依然为0，
        // 所以在执行完++后执行 = ，是把表达式的 0 赋值给了i，i的值又从1 变作 0;


//        System.out.println(i);//0


        int a = 0;
        System.out.println(a++);
    }

    void f(int i) {
        i++;
    }
}
