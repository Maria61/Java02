package BinarySearchTree;

import java.util.Comparator;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2019/9/9 20:15
 */
public class MyTreeMap<K, V> {
    public static class Entry<M, N> {
        private M key;
        private N value;

        private Entry<M, N> left;
        private Entry<M, N> right;
    }

    private Entry<K, V> root;
    private Comparator<K> comparator = null;



}
