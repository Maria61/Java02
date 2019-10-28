package java_experiment.n2;

/**
 * @author Maria
 * @program homework
 * @date 2019/10/28 14:34
 */
public class MyDate {
    int year;
    int month;
    int day;

    public MyDate(){
        this.year = 2018;
        this.month = 1;
        this.day = 1;
    }
    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    void showDate(){
        System.out.println(year+"年"+month+"月"+day+"日");
    }
}
