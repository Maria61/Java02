package operating_system_experiment.homework.out.production.homework.experiment1.experiment1;

import java.util.*;

public class Experiment1 {

    //就绪队列
    private static List<PCB> readyQueue = new ArrayList<>();
    //已完成队列
    private static List<PCB> finishedQueue = new ArrayList<>();

    //进入就绪队列
    public static void ready(PCB p){
        if(p.getTime() == 0){
            finishedQueue.add(p);
            p.setStatus("E");
        }else{
            readyQueue.add(p);
            Collections.sort(readyQueue);
            for(int i = 0; i < readyQueue.size() - 1; i++){
                readyQueue.get(i).setNext(readyQueue.get(i+1));
            }
        }

    }

    //调度
    public static void run(List<PCB> readyQueue){
        if(readyQueue.size() == 0){
            return;
        }
        int pri = readyQueue.get(0).getPriority();
        int time = readyQueue.get(0).getTime();
        if(time == 0){
            readyQueue.get(0).setStatus("E");
            finishedQueue.add(readyQueue.get(0));
            readyQueue.remove(0);
            return;
        }
        readyQueue.get(0).setPriority(pri - 1);
        readyQueue.get(0).setTime(time - 1);
        Collections.sort(readyQueue);
    }

    public static void initReadyQueue(){
        Random random = new Random();
        for(int i = 0; i < 5; i++){
            PCB K1 = new PCB("P"+i,Math.abs(random.nextInt(10)),Math.abs(random.nextInt(10)),"R");
            ready(K1);
        }

    }

    public static void main(String[] args) {

        initReadyQueue();
        int i = 0;

        System.out.println("======初始就绪队列======");
        for(int j = 0; j < readyQueue.size(); j++){
            System.out.println(readyQueue.get(j));
        }
        System.out.println();

        while(readyQueue.size() != 0){
            run(readyQueue);
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
