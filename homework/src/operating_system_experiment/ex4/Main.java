package operating_system_experiment.ex4;
import java.util.Scanner;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/29 18:21
 */
//主程序入口
public class Main {
    private static Scanner scanner =new Scanner(System.in);
    public static void main(String args[]) {
        System.out.print("请输入起始磁道号:");
        int start=scanner.nextInt();
        System.out.print("请输入终止磁道号：");
        int end=scanner.nextInt();
        System.out.println("请输入磁盘请求数大小（当前磁头在100）");
        int num=scanner.nextInt();
        Shedule shedule=new Shedule(start,end,num);
        System.out.println("生成的随机磁道请求号为：");
        shedule.setRandomRequests();
        float avglen=shedule.realSCAN();
        System.out.println("平均寻道长度:"+avglen);
    }
}



