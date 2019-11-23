package operating_system_experiment.homework.out.production.homework.experiment1.experiment1;

import java.util.*;

public class Experiment1 {

    //就绪队列
    private static List<PCB> readyQueue = new ArrayList<>();
    //已完成队列（用于打印）
    private static List<PCB> finishedQueue = new ArrayList<>();

    //进入就绪队列
    public static void ready(PCB p){
        if(p.getTime() == 0){//对时间随机数为0进行处理
            finishedQueue.add(p);//将时间数为0的进程放到已完成队列中，方便打印
            p.setStatus("E");
        }else{
            readyQueue.add(p);
            Collections.sort(readyQueue);//进程加入就绪队列后就进行排序
            for(int i = 0; i < readyQueue.size() - 1; i++){
                readyQueue.get(i).setNext(readyQueue.get(i+1));
            }
        }

    }

    //调度
    public static void run(List<PCB> readyQueue){
        if(readyQueue.size() == 0){//就绪队列长度为0，调度结束
            return;
        }
        int pri = readyQueue.get(0).getPriority();
        int time = readyQueue.get(0).getTime();
        if(time == 0){//如果时间数为0，表示该进程结束，修改进程状态
            readyQueue.get(0).setStatus("E");
            finishedQueue.add(readyQueue.get(0));
            readyQueue.remove(0);
            return;
        }
        //调度进程：进程优先数减一，运行时间减一
        readyQueue.get(0).setPriority(pri - 1);
        readyQueue.get(0).setTime(time - 1);
        //调度之后对就绪队列进行排序
        Collections.sort(readyQueue);
    }

    //初始化就绪队列
    public static void initReadyQueue(){
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            PCB K1 = new PCB("P"+i,Math.abs(random.nextInt(10)),
                    Math.abs(random.nextInt(10)),"R");
            ready(K1);
        }

    }

    public static void main(String[] args) {

        //就绪队列初始化
        initReadyQueue();
        int i = 0;

        //打印初始队列
        System.out.println("======初始就绪队列======");
        for(int j = 0; j < readyQueue.size(); j++){
            System.out.println(readyQueue.get(j));
        }
        System.out.println();

        //进入就绪队列，准别调度进程
        while(readyQueue.size() != 0){
            run(readyQueue);//调度进程的方法
            i++;
            System.out.println("======第"+i+"次调度后的就绪队列=====");
            for(int j = 0; j < readyQueue.size(); j++){
                System.out.println(readyQueue.get(j));
            }
            if(finishedQueue.size() != 0){
                System.out.println("======已完成队列=====");
                for(int j = 0; j < finishedQueue.size(); j++){
                    System.out.println(finishedQueue.get(j));
                }
            }

            System.out.println();
        }

    }
}
