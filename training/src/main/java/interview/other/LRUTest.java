package interview.other;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 使用LinkedList实现LRU
 */
public class LRUTest {
    @Test
    public void test() throws Exception {
        LRULinkedHashMap<String,Integer> list=new LRULinkedHashMap<>(3);
        list.put("1",1);
        list.put("2",2);
        list.put("3",3);
    }
}
//扩展一下LinkedHashMap这个类，让他实现LRU算法
class LRULinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    //定义缓存的容量
    private int capacity;
    private static final long serialVersionUID = 1L;

    //带参数的构造器
    LRULinkedHashMap(int capacity) {
        //调用LinkedHashMap的构造器，传入以下参数
        super(16, 0.75f, true);
        // 传入指定的缓存最大容量
        this.capacity = capacity;
    }

    //实现LRU的关键方法，如果map里面的元素个数大于了缓存最大容量，则删除链表的顶端元素
    @Override
    public boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        System.out.println(eldest.getKey() + "=" + eldest.getValue());
        return size() > capacity;
    }
}