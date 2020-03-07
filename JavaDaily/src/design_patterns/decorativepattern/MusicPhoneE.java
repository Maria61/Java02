package design_patterns.decorativepattern;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/22 10:02
 */
public class MusicPhoneE extends PhoneE {
    public void listenMusic(){
        System.out.println("当城市融进了夜色里。。。");

    }
    @Override
    public void call(){
        listenMusic();
        super.call();
    }

}
