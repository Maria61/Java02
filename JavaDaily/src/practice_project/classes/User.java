package practice_project.classes;

import practice_project.action.Action;
import practice_project.database.BookShelf;

import java.util.List;
import java.util.Scanner;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:09
 */
public abstract class User {
    private String id;
    private String name;
    private String telephone;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
    private  static User currentUser = null;//为什么要是静态属性
    public static User login() throws Exception {

        Scanner s = new Scanner(System.in);
        System.out.println("请输入id");
        String id = s.nextLine();
        System.out.println("请输入姓名");
        String name = s.nextLine();
        System.out.println("请输入角色");
        String role = s.nextLine();

//        User user;
        if (role.equals("老师")) {
            currentUser = new Teacher(id, name);
        } else if (role.equals("学生")) {
            currentUser = new Student(id, name);
        } else {
            throw new Exception("输入角色有误");
        }

        return currentUser;
    }


    protected static User getCurrentUser() {
        return currentUser;
    }

    public abstract void menu();

    public abstract boolean input();

    public void qurryBook(){
        List<Book> bookList = Action.qurryBook();
        for(Book book:bookList){
            System.out.printf("《%s》by %s 价格：%f 存量：%d 借阅次数：%d",
                    book.getName(),book.getAuthor(),book.getPrice(),book.getCount(),book.getRecords());
        }
        System.out.println("共查询到"+bookList.size()+"本书");
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}
