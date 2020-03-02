package operating_system_experiment.ex4;

//进程访问磁盘的磁道号
public class Requst {
    private int Number;  //访问的磁道号

    public Requst(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

}
