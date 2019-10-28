package java_experiment.n2;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 14:24
 */
public class StudentB {
    String sn;
    Integer classId;
    String name;
    String gender;
    Integer age;

    public StudentB(String sn, Integer classId, String name, String gender, Integer age) {
        this.sn = sn;
        this.classId = classId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Integer getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentB{" +
                "学号：" + sn +
                ", 班号：" + classId +
                "班, 姓名：" + name +
                ", 性别：" + gender +
                ", 年龄：" + age +
                '}';
    }
}
