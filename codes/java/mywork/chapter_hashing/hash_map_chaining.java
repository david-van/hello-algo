/**
 * File: hash_map_chaining.java
 * Created Time: 2023-06-13
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_hashing;

import java.util.ArrayList;
import java.util.List;

/* 链式地址哈希表 */
class HashMapChaining {
    int size; // 键值对数量
    int capacity; // 哈希表容量
    double loadThres; // 触发扩容的负载因子阈值
    int extendRatio; // 扩容倍数
    List<List<Pair>> buckets; // 桶数组

    /* 构造方法 */
    public HashMapChaining() {
        size = 0;
        capacity = 4;
        loadThres = 0.75;
        extendRatio = 2;
        buckets = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    /* 哈希函数 */
    int hashFunc(int key) {
        return key % capacity;
    }

    /* 负载因子 */
    double loadFactor() {
        return (double) size / capacity;
    }

    /* 查询操作 */
    String get(int key) {
        int hashFunc = hashFunc(key);
        List<Pair> pairs = buckets.get(hashFunc);
        for (Pair pair : pairs) {
            if (pair.key == key) {
                return pair.val;
            }
        }
        return null;
    }

    /* 添加操作 */
    void put(int key, String val) {
        //判断是否需要扩容
        if (loadFactor() > loadThres) {
            extend();
        }
        int hashFunc = hashFunc(key);
        List<Pair> pairs = buckets.get(hashFunc);
        for (Pair pair : pairs) {
            if (pair.key == key) {
                pair.val = val;
                return;
            }
        }
        pairs.add(new Pair(key, val));
        size++;
    }

    /* 删除操作 */
    void remove(int key) {
        int hashFunc = hashFunc(key);
        List<Pair> pairs = buckets.get(hashFunc);
        for (int i = 0; i < pairs.size(); i++) {
            Pair pair = pairs.get(i);
            if (pair.key == key) {
                //只执行一次删除，不会出现并发异常
                pairs.remove(i);
                size--;
                return;
            }
        }
    }

    /* 扩容哈希表 */
    void extend() {
        capacity = capacity * extendRatio;
        List<List<Pair>> tempList = buckets;

        buckets = new ArrayList<>(capacity);
        for (int hashFunc = 0; hashFunc < capacity; hashFunc++) {
            buckets.add(new ArrayList<>());
        }

        for (List<Pair> pairs : tempList) {
            for (Pair pair : pairs) {
                put(pair.key, pair.val);
            }
        }


    }

    /* 打印哈希表 */
    void print() {
        for (List<Pair> bucket : buckets) {
            List<String> res = new ArrayList<>();
            for (Pair pair : bucket) {
                res.add(pair.key + " -> " + pair.val);
            }
            System.out.println(res);
        }
    }
}

public class hash_map_chaining {
    public static void main(String[] args) {
        /* 初始化哈希表 */
        HashMapChaining map = new HashMapChaining();

        /* 添加操作 */
        // 在哈希表中添加键值对 (key, value)
        map.put(12836, "小哈");
        map.put(15937, "小啰");
        map.put(16750, "小算");
        map.put(13276, "小法");
        map.put(10583, "小鸭");
        System.out.println("\n添加完成后，哈希表为\nKey -> Value");
        map.print();

        /* 查询操作 */
        // 向哈希表输入键 key ，得到值 value
        String name = map.get(13276);
        System.out.println("\n输入学号 13276 ，查询到姓名 " + name);

        /* 删除操作 */
        // 在哈希表中删除键值对 (key, value)
        map.remove(12836);
        System.out.println("\n删除 12836 后，哈希表为\nKey -> Value");
        map.print();
    }
}
