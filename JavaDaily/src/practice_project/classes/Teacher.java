package practice_project.classes;

import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:43
 */
public class Teacher extends User {

    public Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    public void menu() {

        System.out.println("**老师，请选择**");
        System.out.println("**0.退出**");
        System.out.println("**1.上架书籍**");
        System.out.println("**2.查询书籍**");
        System.out.println("**3.查看借阅记录**");


    }

    @Override
    public boolean input() {

        Scanner s = new Scanner(System.in);
        int choose = s.nextInt();
        switch (choose) {
            case 0:
                return true;
            case 1:
                System.out.println("上架");
                break;
            case 2:
                System.out.println("查询");
                break;
            case 3:
                System.out.println("查看借阅记录");
                break;
        }
        return false;
    }
}
