package design_patterns.proxypattern;

/**
 * @author Maria
 * @program design_patterns
 * @date 2019/9/20 23:46
 */

/**
 * 静态代理的代理类
 */
public class ProgrammerBigV implements Programmer {
    private Java1 java1;

    public ProgrammerBigV(Java1 java1){
        this.java1 = java1;
    }

    //透明代理
    public ProgrammerBigV(){
        this.java1 = new Java1();
    }

    public void upvote(){
        System.out.println("点赞转发评论收藏！！！");
    }

    //代理类自定义方法
    public void addMoney(){
        System.out.println("付费100");
    }

    @Override
    public void coding() {
        java1.coding();
        upvote();
        addMoney();
    }
}
