package design_patterns.decorativepattern;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/22 10:25
 */
public class MusicPhone extends PhoneDecorate{
    public MusicPhone(Phone phone) {
        super(phone);
    }

    public void listenMusic(){
        System.out.println("巨星永远有人气");
    }

    @Override
    public void call(){
        listenMusic();
        super.call();
    }
}
