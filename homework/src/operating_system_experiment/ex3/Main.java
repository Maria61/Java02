package operating_system_experiment.ex3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private  int size;
    private  List<MemoryZone> arrayList = new ArrayList<>();

    Main(int size){
        this.size = size;
    }


    public void apply(int workNum,int size){
        if(arrayList.size() == 0){
            MemoryZone work = new MemoryZone(0,size,workNum);
            arrayList.add(work);
            sub(size);
            return;
        }
        for(int i = 0; i < arrayList.size(); i++){
            MemoryZone z = arrayList.get(i);
            if(z.getStatus() == false && z.getSize() >= size){
                MemoryZone work = new MemoryZone(z.getStart(),size,workNum);
                arrayList.add(work);
                int newStart = z.getStart()+size;
                z.setStart(newStart);
                int newSize = z.getSize() - size;
                z.setSize(newSize);
                break;
            }
        }


        Collections.sort(arrayList);
    }

    public void release(int workNum,int size){
        if(arrayList.size() == 0){
            return;
        }
        for(MemoryZone z: arrayList){
            if(z.getWorkNum() == workNum){
                z.setStatus(false);
                z.setWorkNum(0);
            }
        }
        for(int i = 0; i < arrayList.size() - 1; i++){
            MemoryZone z = arrayList.get(i);
            if(z.getStatus() == false){
                MemoryZone z1 = arrayList.get(i + 1);
                if(z1.getStatus() == false){
                    merge(z,z1);
                }
            }
        }
        MemoryZone z = arrayList.get(arrayList.size() - 2);
        MemoryZone z1 = arrayList.get(arrayList.size() - 1);
        if(z.getStatus() == false && z1.getStatus() == false){
            merge(z,z1);
        }

    }

    private void merge(MemoryZone z, MemoryZone z1) {
        int newSize = z.getSize()+z1.getSize();
        z.setSize(newSize);
        arrayList.remove(z1);
    }


    public void sub(int size){
        int newSize = this.size-size;
        this.size = newSize;
        MemoryZone free = new MemoryZone(size,this.size);
        arrayList.add(free);
    }

    public void print(){
        System.out.println("-----------------------------------");
        System.out.println("起址      长度       状态      工作号");
        for(MemoryZone z : arrayList){
            System.out.printf("%-10s",z.getStart());
            System.out.printf("%-10s",z.getSize());
            if(z.getStatus() == false){
                System.out.printf("%-10s","未分配");
            }else{
                System.out.printf("%-10s","已分配");
            }
//            System.out.printf("%-10s",z.getStatus());
            System.out.printf("%-10s",z.getWorkNum());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Main main = new Main(512);
        System.out.println("---------初始状态-----------");
        System.out.println("   起址     长度     状态");
        System.out.println("    0       512     未分配");
        main.apply(1,300);
        main.print();

        main.apply(2,100);
        main.print();

        main.release(1,300);
        main.print();

        main.apply(3,150);
        main.print();

        main.apply(4,30);
        main.print();

        main.apply(5,40);
        main.print();

        main.apply(6,60);
        main.print();

        main.release(4,30);
        main.print();

        main.release(2,100);
        main.print();
    }
}
