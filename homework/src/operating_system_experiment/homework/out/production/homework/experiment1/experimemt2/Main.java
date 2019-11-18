package operating_system_experiment.homework.out.production.homework.experiment1.experimemt2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Banker banker = new Banker();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入系统的资源个数：");
        int resourceNum = sc.nextInt();
        int[] systemResources = new int[resourceNum];
        System.out.println("请输入每个系统资源的数目（以空格分割）");
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        for(int i = 0; i < resourceNum; i++){
            systemResources[i] = Integer.parseInt(s1[i]);
        }
        banker.setAvailable(systemResources);

        System.out.println("请输入需要创建的进程总数：");
        int psNum = sc.nextInt();
        int[] ps = new int[psNum];
        banker.setPs(ps);


        int[][] max = new int[psNum][resourceNum];
        for(int j = 0; j < psNum; j++){
            System.out.println("请输入第"+(j+1)+"个进程对各类资源的最大需求数（以空格分隔）");
            String s2 = sc.nextLine();
            String[] s3 = s2.split(" ");
            for(int k = 0; k < resourceNum; k++){
                max[j][k] = Integer.parseInt(s3[k]);
            }
        }
        banker.setMax(max);
        banker.setNeed(max);

        System.out.println("请输入要执行的进程编号:");
        int p = sc.nextInt();
        int[] request = new int[resourceNum];
        System.out.println("请输入该进程对各类资源的请求数（以空格分隔）：");
        String s4 = sc.nextLine();
        String[] s5 = s4.split("" );
        for(int j = 0; j < resourceNum; j++){
            request[j] = Integer.parseInt(s5[j]);
        }
        int[][] allocation = new int[psNum][resourceNum];
        banker.setAllocation(allocation);

        banker.bankerMethod(request,p);


    }
}
