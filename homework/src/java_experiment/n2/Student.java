package java_experiment.n2;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 14:17
 */
public class Student {
    String sn;
    Integer classId;
    String name;
    String gender;
    Integer age;

    public Student(String sn, Integer classId, String name, String gender, Integer age) {
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
}
