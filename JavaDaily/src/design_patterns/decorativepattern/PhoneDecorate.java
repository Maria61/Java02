package design_patterns.decorativepattern;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/22 10:20
 */
public abstract class PhoneDecorate implements Phone{
    private Phone phone;

    public PhoneDecorate(Phone phone){
        this.phone = phone;
    }

    @Override
    public void call(){
        phone.call();
    }
}
