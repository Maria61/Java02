package practice_project;

import practice_project.classes.User;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/10/9 19:42
 */
public class Main {
    public static void main(String[] args) throws Exception {
        User currentUser = User.login();
        boolean isQuit;
        do {
            currentUser.menu();
            isQuit = currentUser.input();

        } while (!isQuit);
        System.out.println("Bye!");
    }
}
