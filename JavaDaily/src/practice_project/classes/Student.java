package practice_project.classes;

import practice_project.action.Action;
import practice_project.exception.BorrowOutException;
import practice_project.exception.NoBorrowedException;
import practice_project.exception.NoSuchBookException;
import practice_project.exception.YetBorrowedException;

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
                queryBooks();
//                System.out.println("查询");
                break;
            case 2:
                  borrowBook();
//                System.out.println("借阅");
                break;
            case 3:
                returnBook();
//                System.out.println("归还");
                break;
        }
        return false;
    }


    private void borrowBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入借阅图书ISBN:");
        String ISBN = sc.nextLine();
        User currentUser = User.getCurrentUser();
        try {
            Book book = Action.borrowBook(currentUser, ISBN);
            System.out.printf("《%s》 借阅成功！%n", book.getName());
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书！");
        } catch (BorrowOutException e) {
            System.out.println("错误！该书已被借完！");
        } catch (YetBorrowedException e) {
            System.out.println("错误！该书你已经借过了！");

        }
    }

    private void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入归还图书ISBN:");
        String ISBN = sc.nextLine();
        User currentUser = User.getCurrentUser();

        Book book = null;
        try {
            book = Action.returnBook(currentUser, ISBN);
        } catch (NoSuchBookException e) {
            System.out.println("错误！没有这本书！");
        } catch (NoBorrowedException e) {
            System.out.println("错误！你没有借这本书！");
        }
        System.out.printf("《%s》 归还成功！%n", book.getName());

    }
}
