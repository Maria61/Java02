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

    public Staff(String name, String address, String telephone,
                 String email, String office, int salary, MyDate employeeDate,
                 MyDate workTime, String level, String title) {
        super(name, address, telephone, email, office, salary, employeeDate);
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
                " 姓名："+getName()+" 地址："+getAddress()+" 电话："+getTelephone()+" email："+getEmail()+" 职位："+getTitle()+" 办公室："+getOffice()+"}";
    }
}
