package BinarySearchTree;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/16 19:23
 */
public class MaJiang implements Comparable<MaJiang> {
    private String color;
    private String value;

    public MaJiang(String color, String value) {
        this.color = color;
        this.value = value;
    }

    @Override
    public int compareTo(MaJiang o) {
        return this.value.compareTo(o.value);
    }
}
