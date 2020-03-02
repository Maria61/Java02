package operating_system_experiment.ex4;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/29 18:27
 */
public class Shedule {
    private Requst[] requests; //磁道请求数
    private int start;  //起始磁道号
    private int end;    //终止磁道号
    private int num;    //磁道请求数
    private int curCidao=100;  //当前磁头在100磁道

    public Shedule(int start, int end, int num){
        this.start = start;
        this.end = end;
        this.num = num;
    }

    /**
     * 设置请求的磁道号（随机）
     */
    public void setRandomRequests() {
        requests=new Requst[num];
        //利用Set去重存储，TreeSet有序存储的特点创建请求集合
        Set<Integer> reqSet=new TreeSet<>();
        int n=num;
        //将随机磁道号放在reqSet中
        int randomReq = 0;
        while(n > 0)
        {
            Random random=new Random();
            //生成随机磁道号, start-end之间的随机整数
            randomReq=random.nextInt(end-start)+start;
            //如果生成的随机磁道号已经存在
            while(reqSet.contains(randomReq))
            {
                //重新生成磁道号，直到生成的磁道号不在reqSet中
                randomReq=random.nextInt(end-start)+start;
            }
            reqSet.add(randomReq);
            System.out.print(randomReq+" ");
            n--;
        }
        int i=0;
        //初始化每一个磁道请求
        for(int tmp:reqSet)
        {
            requests[i]=new Requst(tmp);
            i++;
        }
        System.out.println();
    }

    /**
     * 电梯调度算法
     * @return
     */
    public float realSCAN() {
        float sum=0;
        //存放比当前磁道号大的磁道号
        TreeSet<Integer> bigNum=new TreeSet<>();
        //存放比当前磁道号小的磁道号
        TreeSet<Integer> smallNum=new TreeSet<>();
        for(int i=0;i<num;i++) {
            if(i < num && requests[i].getNumber() >= curCidao) {
                bigNum.add(requests[i].getNumber());
            }else{
                smallNum.add(requests[i].getNumber());
            }
        }
        System.out.println("被访问的下一个磁道号  移动磁道数");
        //将要访问的磁道（离当前磁道最近且满足电梯调度算法）：bigNum的下一个数字
        for(int tmp:bigNum) {
            System.out.printf("%13s",tmp);
            System.out.printf("%13s",(tmp-curCidao));
            System.out.println();
            sum=sum+(tmp-curCidao);
            curCidao=tmp;
        }
        //根据电梯调度算法，访问完磁道号大的半边后，会逆序访问磁道小的半边，
        // 因此需要将smallNum逆序
        for(int tmp:smallNum.descendingSet())
        {
            System.out.printf("%13s",tmp);
            System.out.printf("%13s",(curCidao-tmp));
            System.out.println();
            sum=sum+(curCidao-tmp);
            curCidao=tmp;
        }
        return sum/num;
    }

}
