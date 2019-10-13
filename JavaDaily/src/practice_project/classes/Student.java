package practice_project.classes;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:43
 */
public class Student extends User {

    public Student(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {
        System.out.println("**同学，请选择**");
        System.out.println("**0.退出**");
        System.out.println("**1.查询书籍**");
        System.out.println("**2.借阅书籍**");
        System.out.println("**3.归还图书**");
        System.out.println("**4.查看借阅记录**");
    }

    @Override
    public boolean input() {
        Scanner s = new Scanner(System.in);
        int choose = s.nextInt();
        switch (choose) {
            case 0:
                return true;
            case 1:
                System.out.println("查询");
                break;
            case 2:
                System.out.println("借阅");
                break;
            case 3:
                System.out.println("归还");
                break;
            case 4:
                System.out.println("查询");
                break;
        }
        return false;
    }
}
