package class_homework;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/6 22:16
 */
public class Person {
    private String IDNumber;
    private String name;
    private String gender;
    private int height;//单位为cm
    private double weight;//单位为kg


    public void eat() {
        System.out.println("吃饭");
    }

    public void sleep() {
        System.out.println("睡觉");
    }

    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        String str = checkNum(IDNumber);
        if (str.equals("")) {
            this.IDNumber = IDNumber;
        } else {
            System.out.println(str);
        }

    }

    private String checkNum(String num) {
        String result = "";
        if (num.length() != 18) {
            result = "身份证长度不是18位";
        } else {
            for (int i = 0; i < num.length() - 1; i++) {
                char ch = num.charAt(i);
                if ((i < '0') || (i > '9')) {
                    result = "身份证号前十七位中有非数字字符";
                    break;
                }
            }
        }

        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (gender.equals("男") || gender.equals("女")) {
            this.gender = gender;
        }

    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 300 && height > 0) {
            this.height = height;
        } else {
            System.out.println("身高不合理");
        }

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight < 800 && weight > 0) {
            this.weight = weight;
        } else {
            System.out.println("体重不合理");
        }

    }

    public Person(String IDNumber, String name, String gender, int height, double weight) {
        this.name = name;
        this.setGender(gender);
        this.setHeight(height);
        this.setIDNumber(IDNumber);
        this.setWeight(weight);

    }
}
