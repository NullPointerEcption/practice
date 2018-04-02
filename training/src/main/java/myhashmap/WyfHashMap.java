package myhashmap;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.hash;

/**
 * 自定义的HashMap实现自MyMap
 *
 * @param <K>
 * @param <V>
 */
public class WyfHashMap<K, V> implements MyMap<K, V> {

    /**
     * 默认的数组的长度
     */
    private static final int DEFAULT_INITAL_CAPACVITY = 1 << 4;
    /**
     * 默认的扩容比例，当当前容量占用到达75% 时 就进行扩容
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    private int tableSize;//数组的总长度
    private int currentSize;//当前数组的长度
    private float loadFactor;//扩容因子

    //容器
    private Entry<K, V>[] table = null;

    public WyfHashMap(int defaultInitSize, float defaultLoadFactor) {
        if (defaultInitSize < 0) {
            throw new IllegalArgumentException("Illegal initial capcacity:" + defaultInitSize);
        }
        if (defaultLoadFactor < 0 || Float.isNaN(defaultLoadFactor)) {
            throw new IllegalArgumentException("Illegal defaultLoadFactor:" + defaultLoadFactor);
        }
        this.tableSize = defaultInitSize;
        this.loadFactor = defaultLoadFactor;
        this.table = new Entry[this.tableSize];
    }

    public WyfHashMap() {
        this(DEFAULT_INITAL_CAPACVITY, DEFAULT_LOAD_FACTOR);
    }

    @Override
    public V put(K k, V v) {
        V oldVal = null;

        //判断当前数组的长度，是否需要扩容
        if (currentSize >= tableSize * loadFactor) {
            resize(2 * tableSize);//对数组进行扩容，变成当前长度的两倍
        }

        //得到hahs值 算出在数组中的位置
        int index = hash(k) & (tableSize - 1);

        //如果是第一次添加
        Entry<K, V> kvEntry = table[index];
        if (kvEntry == null) {
            table[index] = new Entry<K, V>(k, v, null);
            ++currentSize;//当前使用长度+1
        } else {
            //进行单链表的遍历
            //如果存在于单链表中 则直接替换并返回
            Entry<K, V> e = kvEntry;
            while (e != null) {
                if (e.getKey() == k || e.getKey().equals(k)) {
                    oldVal = e.value;
                    e.value = v;
                    return oldVal;
                }
                e = e.next;
            }
            //如果不存在于链表中 形成一个新的Entry“挤压”单链表！
            table[index] = new Entry<>(k, v, kvEntry);
            currentSize++;
        }
        return oldVal;
    }

    @Override
    public V get(K k) {
        //得到hahs值 算出在数组中的位置
        int index = hash(k) & (tableSize - 1);

        //如果是第一次添加
        Entry<K, V> e = table[index];
        if (e == null) {
            return null;
        }
        while (e != null) {
            if (e.getKey() == k || e.getKey().equals(k)) {
                return e.getValue();
            }
            e = e.next;
        }
        return null;
    }

    private int hash(K k) {
        int hashCode = k.hashCode();
        hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
        return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
    }

    private void resize(int len) {
        Entry[] newTable = new Entry[len];//改变数组大小
        tableSize = len;
        currentSize = 0;
        rehash(newTable);

        System.out.println("进行了扩容，长度为:" + tableSize + "已用容量：" + currentSize);
    }

    private void rehash(Entry[] newTable) {
        List<Entry<K, V>> entryList = new ArrayList<>();
        //把table中的所有entry取出来
        for (Entry<K, V> entry : table) {
            if (entry != null) {
                do {
                    entryList.add(entry);
                    entry = entry.next;
                } while (entry != null);
            }
        }
        if (newTable.length > 0) {
            table = newTable;
        }

        for (Entry<K, V> entry : entryList) {
            put(entry.getKey(), entry.getValue());
        }
    }


    /**
     * HashMap的Entry 链表实现
     *
     * @param <K>
     * @param <V>
     */
    class Entry<K, V> implements MyMap.Entry {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry() {
        }

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
    }
}
