package collection;

/**
 * ʕ•ﻌ•ʔ❀ ʚɞ
 *
 * @author Maria
 * @date 2019-08-20 9:48
 */
public class PokeCard {
    private int num;
    private String type;

    public PokeCard(int num, String type) {
        this.num = num;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "{" +type +num+
                '}';
    }

    @Override
    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        //instanceof指返回obj能否被PokeCard的引用指向
        if(!(obj instanceof PokeCard)){
            return false;
        }

        PokeCard other = (PokeCard) obj;
        //凡是引用数据类型，比较两个对象是否相等用equals
        return this.num == other.num && this.type.equals(other.type);
    }
}
