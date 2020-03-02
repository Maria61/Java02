package operating_system_experiment.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    //内存空间初始大小
    private  int size;
    //内存分配顺序表：内部存放 内存块对象
    private  List<MemoryZone> arrayList = new ArrayList<>();

    //对内存空间进行初始化
    Main(int size){
        this.size = size;
        //初始化时内存分配表只有一个区域且该区域状态为空闲
        MemoryZone z = new MemoryZone(0,size);
        arrayList.add(z);
    }


    /**
     * 作业申请
     * @param workNum 作业号
     * @param size 申请大小
     */
    public void apply(int workNum,int size){
        //遍历内存分配顺序表
        for(int i = 0; i < arrayList.size(); i++){
            MemoryZone z = arrayList.get(i);
            //如果内存块状态为空闲且大小合适（空闲内存块大小大于申请大小），则分配
            if(z.getStatus() == false && z.getSize() >= size){
                //分配内存
                // 1.创建新的内存块对象，传入作业号
                MemoryZone work = new MemoryZone(z.getStart(),size,workNum);
                //2.添加内存块到内存分配表
                arrayList.add(work);
                //3.更新空闲内存块
                // 空闲内存块的开始地址=原有地址+作业申请大小
                int newStart = z.getStart()+size;
                //更新空闲内存块的开始地址
                z.setStart(newStart);
                //空闲内存块的大小=原有大小+作业申请大小
                int newSize = z.getSize() - size;
                //更新空闲内存块的大小
                z.setSize(newSize);
                break;//找到合适分配区域就不再继续遍历
            }
        }
        //对内存分配表按照内存块的开始地址进行排序
        Collections.sort(arrayList);
    }

    /**
     * 作业释放
     * @param workNum  作业号
     * @param size 作业大小
     */
    public void release(int workNum,int size){
        //遍历内存分配表，找到作业号为workNum的内存对象
        for(MemoryZone z: arrayList){
            if(z.getWorkNum() == workNum){
                //找到后，修改该内存块对象的状态为false
                z.setStatus(false);
                //修改该内存块对象的作业号为0
                z.setWorkNum(0);
            }
        }
        //遍历内存分配表，合并相邻的空闲内存分区
        for(int i = 0; i < arrayList.size() - 1; i++){
            MemoryZone z = arrayList.get(i);
            if(z.getStatus() == false){
                MemoryZone z1 = arrayList.get(i + 1);
                //如果两个相邻内存空间状态均为false，则合并
                if(z1.getStatus() == false){
                    merge(z,z1);
                }
            }
        }

        //处理最后两个内存块都为空闲的情况
        MemoryZone z = arrayList.get(arrayList.size() - 2);
        MemoryZone z1 = arrayList.get(arrayList.size() - 1);
        if(z.getStatus() == false && z1.getStatus() == false){
            merge(z,z1);
        }

    }

    /**
     * 合并内存分区
     * @param z  空闲内存分区1
     * @param z1 空闲内存分区2
     */
    private void merge(MemoryZone z, MemoryZone z1) {
        //合并后的内存大小=两个内存大小之和
        int newSize = z.getSize()+z1.getSize();
        //将第一个空闲内存大小设置新的空闲内存大小
        z.setSize(newSize);
        //删除第二个空闲内存块对象
        arrayList.remove(z1);
    }

    /**
     * 打印空闲分区
     */
    public void print(){
        System.out.println("   起址      长度");
        for(MemoryZone z : arrayList){
            if(z.getStatus() == false) {
                System.out.printf("%6s", z.getStart());
                System.out.printf("%10s", z.getSize());
                System.out.println();
            }
        }
    }

    /**
     * 打印整个内存分配情况
     */
    public void print1(){
        System.out.println("-----------最终内存分配情况-----------");
        System.out.println("起址      长度       状态      工作号");
        for(MemoryZone z : arrayList){
            System.out.printf("%-10s",z.getStart());
            System.out.printf("%-10s",z.getSize());
            if(z.getStatus() == false){
                System.out.printf("%-10s","未分配");
            }else{
                System.out.printf("%-10s","已分配");
            }
            System.out.printf("%-10s",z.getWorkNum());
            System.out.println();
        }
    }

    /**
     * 主程序入口
     * @param args
     */
    public static void main(String[] args) {
        Main main = new Main(512);
        System.out.println("------初始状态-------");
        main.print();
        main.apply(1,300);
        System.out.println("------作业1申请300k------");
        main.print();

        main.apply(2,100);
        System.out.println("------作业2申请100k------");
        main.print();

        main.release(1,300);
        System.out.println("------作业1释放300k------");
        main.print();

        main.apply(3,150);
        System.out.println("------作业3申请150k------");
        main.print();

        main.apply(4,30);
        System.out.println("------作业4申请30k------");
        main.print();

        main.apply(5,40);
        System.out.println("------作业5申请40k------");
        main.print();

        main.apply(6,60);
        System.out.println("------作业6申请60k------");
        main.print();

        main.release(4,30);
        System.out.println("------作业4释放30k------");
        main.print();

        main.print1();
    }
}
