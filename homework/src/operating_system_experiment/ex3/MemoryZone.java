package operating_system_experiment.ex3;

import java.util.Comparator;

public class MemoryZone implements Comparable<MemoryZone> {
    private int start;
    private int size;
    private boolean status;
    private int workNum;

    public MemoryZone(int start, int size, int workNum) {
        this.start = start;
        this.size = size;
        this.status = true;
        this.workNum = workNum;
    }

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

    @Override
    public String toString() {
        return "MemoryZone{" +
                "start=" + start +
                ", size=" + size +
                ", status=" + status +
                ", workNum=" + workNum +
                '}';
    }




    @Override
    public int compareTo(MemoryZone o) {
        return this.getStart() - o.getStart();
    }
}
