package BinarySearchTree;

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
    public int hashCode() {
        return value ^ type.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (!(o instanceof Card)) {
            return false;
        }

        Card c = (Card) o;
        return value == c.value && type.equals(c.type);
    }
}
