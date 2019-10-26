package main.java.dataobject;

/**
 * @author Maria
 * @program jdbc-demo
 * @date 2019/10/26 10:44
 */
public class Course {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
