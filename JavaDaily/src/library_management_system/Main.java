package library_management_system;

import library_management_system.classes.User;

import java.util.Scanner;


/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:42
 */
public class Main {
    public static void main(String[] args) throws Exception {
        while(true){
            User currentUser = User.login();
            boolean isQuit;
            do {
                currentUser.menu();
                isQuit = currentUser.input();

            } while (!isQuit);
            Scanner sc = new Scanner(System.in);
            System.out.println("1.退出");
            System.out.println("2.切换用户");
            int input = sc.nextInt();
            if (input == 1) {
                break;
            }
        }

//        System.out.println("Bye!");
    }
}
