package design_patterns.decorativepattern;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/22 10:31
 */
public class Main {
    public static void main(String[] args) {
//        Phone phone = new PhoneX();
//
//        GiveCurrentTimePhone giveCurrentTimePhone = new GiveCurrentTimePhone(phone);
//        giveCurrentTimePhone.call();
//
//        MusicPhone musicPhone = new MusicPhone(phone);
//        musicPhone.call();

        Phone phone = new MusicPhone(new GiveCurrentTimePhone(new PhoneX()));
        phone.call();


    }

}
