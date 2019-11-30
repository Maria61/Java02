package java_experiment.n3;

/**
 * @author Maria
 * @program homework
 * @date 2019/11/30 15:28
 */
public class Student extends Person {
    private int id;
    private String cname;
    private int score;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void display(){
        System.out.println(" 姓名："+getName()+" 性别："+getGender()+" 年龄："+
                getAge()+" 学号：" +id+" 班名："+cname+" 成绩："+score);
    }
}
