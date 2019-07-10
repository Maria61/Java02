import java.util.Arrays;
import java.util.Scanner;
public class JavaDaily0709 {
    /**
     * 输入输出练习
     */
    //方法一：
    /*public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的姓名：");
        String name = sc.nextLine();
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
    }*/
    //方法二：Scanner类里 next() 方法使用时，不接收空格，回车等为输入内容；
    //        而 nextLine() 方法接收回车和空格
    /*public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入你的年龄：");
        int age = sc.nextInt();
        System.out.println("请输入你的姓名：");
        String name = sc.next();//注意next()和nextLine()的区别

        System.out.println("请输入你的工资：");
        float salary = sc.nextFloat();
        System.out.println("你的信息如下：");
        System.out.println("姓名："+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
    }*/
    
    
    //斐波那契数列
   /* 设斐波那契数列的表达式为F(x) ，x为大于0的整数。且 F(0) = 1，F(1) = 1,对于所有 x > 1 ，都有 F(x) = F(x - 1) + F(x - 2)。
    你的任务是计算给定x下的F(x)。
    输入:
    第一行输入一个整数T，表示有T个测试样例( 1 <= T <= 20)。接下来T行为测试样例，每行输入一个整数x（0 <= x <= 20）。
    输出:
    每行输出一个对应x的F(x)。
*/
    public static int  fab(int a){
        int result;
        if(a == 0 || a == 1){
            result = 1;
        }else{
            result = fab(a-1)+fab(a-2);
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        int temp = n;
        for (int i=0; temp != 0; i++){
            a[i] = sc.nextInt();
            temp--;
        }
        System.out.println(Arrays.toString(a));
        int i = 0;
        temp = n;
        while (temp != 0){
            System.out.println(fab(a[i]));
            i++;
            temp--;
        }
    }
}
