package java_experiment.n3.e12;


/**
 * @author Maria
 * @program homework
 * @date 2019/12/7 14:29
 */
public class Employee extends Person{
    private String office;
    private int salary;
    private MyDate employeeDate;

    public Employee(String name, String address, String telephone, String email, String office, int salary, MyDate employeeDate) {
        super(name, address, telephone, email);
        this.office = office;
        this.salary = salary;
        this.employeeDate = employeeDate;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public MyDate getEmployeeDate() {
        return employeeDate;
    }

    public void setEmployeeDate(MyDate employeeDate) {
        this.employeeDate = employeeDate;
    }
}
