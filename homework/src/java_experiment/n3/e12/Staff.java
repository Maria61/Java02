package java_experiment.n3.e12;

/**
 * @author Maria
 * @program homework
 * @date 2019/12/7 14:57
 */
public class Staff extends Employee {
    private MyDate workTime;
    private String level;
    private String title;

    public Staff(String office,int s,MyDate date,MyDate workTime, String level, String title) {
        super(office,s,date);
        this.workTime = workTime;
        this.level = level;
        this.title = title;
    }

    public MyDate getWorkTime() {
        return workTime;
    }

    public void setWorkTime(MyDate workTime) {
        this.workTime = workTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "workTime=" + workTime +
                ", level='" + level + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
