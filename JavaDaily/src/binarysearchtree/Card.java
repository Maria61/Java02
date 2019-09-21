package binarysearchtree;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/16 23:49
 */
public class Card {
    public int value;
    public String type;

    public Card(int value, String type) {
        this.type = type;
        this.value = value;
    }

    @Override
    public int hashCode() {//一般覆写hashCode的方法：所有属性相^
        return value ^ type.hashCode();
    }

    @Override
    public boolean equals(Object o) {//一般覆写equals的方法：
        //1.判断两个引用是否指向同一个对象
        if (this == o) {
            return true;
        }
        //2.判断形参引用是否指向空
        if (o == null) {
            return false;
        }
        //3.判断两引用的对象是否是同一类型
        if (!(o instanceof Card)) {
            return false;
        }
        //4.判断数值是否相等
        Card c = (Card) o;
        return value == c.value && type.equals(c.type);
    }
}
