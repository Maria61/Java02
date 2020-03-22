package advance.data_structure.hashmap;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/21 14:32
 */
public interface Map<K,V> {
    V get(K key);

    V put(K key,V value);

}
