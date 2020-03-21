package advance_ds.hashmap;

/**
 * @author Maria
 * @program JavaDaily
 * @date 2020/3/21 14:51
 */
public class HashMap<K,V> implements Map<K,V> {
    //链表的节点类
    private static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key,V value){
            this.key = key;
            this.value = value;
        }
    }

    //基本存储方式：数组
    private Entry<K,V>[] table = new Entry[16];
    //存储的元素的个数
    private int size = 0;
    //扩容因子
    private static final double LOAD_FACTOR_THRESHOLD = 0.75;

    @Override
    public V get(K key) {
        /**
         * 1.先计算出key对应的hash值
         * 2.对超出数组范围的hash值进行处理
         * 3.根据正确的hash值（下标值）找到所在的链表的头结点
         * 4.遍历链表，如果key值相等，返回对应的value值,否则返回null
         */
        int hash = key.hashCode();
        hash = (hash >>> 16)^hash;//java内部自做的优化，为了使hash值更加均衡
        int index = hash & (table.length - 1);
        Entry<K,V> node = table[index];
        while(node != null){
            if(node.key.equals(key)){
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        /**
         * 1.先计算出key对应的hash值
         * 2.对超出数组范围的hash值进行处理
         * 3.根据正确的hash值（下标值）找到所在的链表的头结点
         * 4.如果头结点==null，直接将新结点赋值给数组的该位置
         * 5.否则，遍历链表，找到key相等的节点，并进行value值的替换，返回旧的value值
         * 6.如果没有找到，采用尾插法（1.8）/头插法（1.7）创建新结点并插入到链表中
         * 7.将存储元素数量+1
         * 8.校验是否需要扩容(需要全部重新计算hash值，因为数组长度改变了)
         *      扩容原因：为了减少hash冲突，冲突率：插入一个新的key时，会遇到冲突的概率
         *          负载因子=所有key的数量/数组的长度
         *          冲突率和负载因子成正相关！因此为了降低冲突率，可改变数组的长度！
         *      具体操作：通过计算负载因子并与扩容因子进行比较
         */

        int hash = key.hashCode();
        hash = (hash >>> 16)^hash;//java内部自做的优化语句，为了使hash值更加均衡
        int index = hash & (table.length - 1);
        Entry<K,V> node = table[index];
        if(node == null){
            Entry<K,V> newNode = new Entry<>(key,value);
            table[index] = newNode;
        }else{
            Entry<K,V> pre = null;
            while(node != null){
                if(node.key.equals(key)){
                    V oldValue = node.value;
                    node.value = value;
                    return oldValue;
                }
                pre = node;
                node = node.next;
            }
            pre.next = new Entry<>(key,value);
        }
        size++;
        if((double) size / table.length >= LOAD_FACTOR_THRESHOLD ){
            resize();
        }
        return null;

    }

    private void resize(){
        /**
         * 1.创造新数组，长度为原数组的2倍
         * 2.遍历原数组，找到每一条链表的头节点
         * 3.遍历每一条链表，新建结点并将节点采用头插法插入到新数组中
         *
        */
        Entry<K,V>[] newTable = new Entry[table.length * 2];
        for(int i = 0; i < table.length; i++){
            Entry<K,V> node = table[i];
            while(node != null){
                Entry<K,V> newNode = new Entry<>(node.key,node.value);
                int hash = node.key.hashCode();
                hash = (hash >>> 16) ^ hash;
                int index = hash ^ (newTable.length - 1);
                //使用头插，尾插也可以
                newNode.next = newTable[index];
                newTable[index] = newNode;
                node = node.next;
            }
        }
    }
}
