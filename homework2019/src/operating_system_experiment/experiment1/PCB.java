package operating_system_experiment.experiment1;

public class PCB implements Comparable<PCB>{
    private String name;
    private PCB next;
    private Integer time;
    private Integer priority;
    private String status;

    public PCB(String name, Integer time, Integer priority, String status) {
        this(name,null,time,priority,status);
    }

    public PCB(String name, PCB next, Integer time, Integer priority, String status) {
        this.name = name;
        this.next = next;
        this.time = time;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PCB getNext() {
        return next;
    }

    public void setNext(PCB next) {
        this.next = next;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public int compareTo(PCB o) {
        return o.getPriority() - this.getPriority();
    }

    @Override
    public String toString() {
        if(next == null){
            return "进程名:"+name+"  指针:null"+"  运行时间:"+time+"  优先数"+priority+"  状态"+status;
        }else{
            return "进程名:"+name+"  指针"+next.name+"  运行时间:"+time+"  优先数"+priority+"  状态"+status;
        }

    }
}
