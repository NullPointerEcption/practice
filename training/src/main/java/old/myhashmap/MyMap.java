package old.myhashmap;

public interface MyMap<K, V> {
    /**
     * 从map中添加一个值
     * 如果key之前就存在，则返回之前的value
     * 如果是第一次添加，则返回null
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);

    /**
     * 从map中通过key 获取一个值
     *
     * @param k
     * @return
     */
    V get(K k);

    interface Entry<K, V> {
        K getKey();
        V getValue();
    }
}
