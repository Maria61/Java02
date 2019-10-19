package addressbook;

import addressbook.action.Action;
import addressbook.exception.NoPersonException;
import addressbook.exception.NoTelephoneException;

import java.util.List;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/19 9:51
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("*欢迎使用通讯录          ");
            System.out.println("0.退出                  ");
            System.out.println("1.通过姓名查询联系人     ");
            System.out.println("2.添加联系人            ");
            System.out.println("3.删除联系人            ");
            System.out.println("4.删除联系人的电话号码   ");
            input = sc.nextInt();
            sc.nextLine();
            switch (input) {
                case 0:
                    break;
                case 1:
                    System.out.println("请输入姓名:");
                    String name = sc.nextLine();
                    List addresses = null;
                    try {
                        addresses = Action.select(name);
                        System.out.println(name + ":");
                        System.out.println(addresses.toString());
                        break;
                    } catch (NoTelephoneException e) {
                        System.out.println("此人无电话号码");
                    } catch (NoPersonException e) {
                        System.out.println("查无此人");
                    }

            }
        } while (input != 0);

    }
}
