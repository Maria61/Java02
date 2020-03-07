package design_patterns.decorativepattern;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/22 10:09
 */
public class GiveCurrentTimePhoneE extends MusicPhoneE {

    public void currentTime(){
        System.out.println("当前时间为:"+System.currentTimeMillis());
    }

    @Override
    public void call(){
        super.call();
        currentTime();
    }

}
