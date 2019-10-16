package practice_project.classes;

import practice_project.action.Action;
import practice_project.database.Where;

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

    private static User currentUser = null;

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

    private static class Current implements Where<Book> {

        @Override
        public boolean test(Book book) {
            return book.getCurrentCount() > 0;
        }
    }

    private static class SelectBookByName implements Where<Book> {
        String name;

        public SelectBookByName(String name) {
            this.name = name;
        }

        @Override
        public boolean test(Book book) {
            return book.getName().equals(name);
        }
    }

    protected void queryBooks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择条件查询还是全查询");
        System.out.println("1.全查询");
        System.out.println("2.查询图书现存量>0的书");
        System.out.println("3.按书名查询");
        int input = sc.nextInt();
        List<Book> bookList = null;
        switch (input) {
            case 1:
                bookList = Action.queryBooks();
                break;
            case 2:
                bookList = Action.queryBooksByWhere(new Current());
                break;
            case 3:
                System.out.println("请输入书名：");
                String name = sc.nextLine();
                bookList = Action.queryBooksByName(new SelectBookByName(name));
                break;
        }

        for(Book book:bookList){
            System.out.printf(" %s 《%s》by %s 价格：%.2f 存量：%d 借阅次数：%d %n",
                    book.getISBN(), book.getName(), book.getAuthor(), book.getPrice(), book.getTotalCount(), book.getBorrowCount());
        }
        System.out.println("共查询到"+bookList.size()+"本书");
    }

    protected void queryRecords() {

        List<Record> recordList = Action.queryRecords();
        for (Record record : recordList) {
            System.out.printf("%s %s %s%n", record.getUserId(), record.getBookISBN(), record.getRecordTime());
        }
        System.out.println("共查询到" + recordList.size() + "条记录");
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
