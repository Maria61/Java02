package operating_system_experiment.ex3;

/**
 * 内存块对象
 */
public class MemoryZone implements Comparable<MemoryZone> {
    //内存块开始地址
    private int start;
    //内存块大小
    private int size;
    //内存块状态：空闲为false,工作为true
    private boolean status;
    //若状态为true,则有对应的作业号（不为0），状态为false，workNum=0
    private int workNum;

    //创造作业内存分区对象，状态默认为true，需传入作业号
    public MemoryZone(int start, int size, int workNum) {
        this.start = start;
        this.size = size;
        this.status = true;
        this.workNum = workNum;
    }

    //创造空闲内存分区对象，状态默认为false
    public MemoryZone(int start, int size) {
        this.start = start;
        this.size = size;
        this.status = false;
    }

    public int getWorkNum() {
        return workNum;
    }

    public void setWorkNum(int workNum) {
        this.workNum = workNum;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    //覆写comparaTo方法，使内存分配表按照内存分区开始地址排序
    @Override
    public int compareTo(MemoryZone o) {
        return this.getStart() - o.getStart();
    }
}
