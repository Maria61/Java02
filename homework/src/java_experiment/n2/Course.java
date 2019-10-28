package java_experiment.n2;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 15:48
 */
public class Course {
    String cNumber;
    String name;
    int cuit;

    public Course(String cNumber, String name, int cuit) {
        this.cNumber = cNumber;
        this.name = name;
        this.cuit = cuit;
    }

    public void printCourseInfo(){
        System.out.println("cNumber:"+cNumber+",name:"+name+",cuit:"+cuit);
    }
}
