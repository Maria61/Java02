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
