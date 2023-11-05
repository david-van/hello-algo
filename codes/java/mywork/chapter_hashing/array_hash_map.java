/**
 * File: array_hash_map.java
 * Created Time: 2022-12-04
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_hashing;

import java.util.ArrayList;
import java.util.List;

/* 键值对 */
class Pair {
    public int key;
    public String val;

    public Pair(int key, String val) {
        this.key = key;
        this.val = val;
    }
}

/* 基于数组简易实现的哈希表 */
class ArrayHashMap {
    private List<Pair> buckets;

    public ArrayHashMap() {
        // 初始化数组，包含 100 个桶
        buckets = new ArrayList<>();
        //用于后续添加对象，同时和哈希函数得到的值
        for (int i = 0; i < 100; i++) {
            buckets.add(null);
        }
    }

    /* 哈希函数 */
    private int hashFunc(int key) {
        return key % 100;
    }

    /* 查询操作 */
    public String get(int key) {
        int hashFunc = hashFunc(key);
        Pair pair = buckets.get(hashFunc);
        if (null == pair) {
            return null;
        } else {
            return pair.val;
        }
    }

    /* 添加操作 */
    public void put(int key, String val) {
        int hashFunc = hashFunc(key);
        Pair pair = new Pair(hashFunc, val);
        buckets.add(hashFunc, pair);
    }

    /* 删除操作 */
    public void remove(int key) {
        int hashFunc = hashFunc(key);
        buckets.remove(hashFunc);
    }

    /* 获取所有键值对 */
    public List<Pair> pairSet() {
        List<Pair> result = new ArrayList<>();
        for (Pair pair : buckets) {
            if (null == pair) {
                continue;
            }
            result.add(pair);
        }
        return result;
    }

    /* 获取所有键 */
    public List<Integer> keySet() {
        List<Integer> result = new ArrayList<>();
        for (Pair pair : buckets) {
            if (null == pair) {
                continue;
            }
            result.add(pair.key);
        }
        return result;
    }

    /* 获取所有值 */
    public List<String> valueSet() {
        List<String> result = new ArrayList<>();
        for (Pair pair : buckets) {
            if (null == pair) {
                continue;
            }
            result.add(pair.val);
        }
        return result;
    }

    /* 打印哈希表 */
    public void print() {
        for (Pair kv : pairSet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
    }
}

public class array_hash_map {
    public static void main(String[] args) {
        /* 初始化哈希表 */
        ArrayHashMap map = new ArrayHashMap();

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
        String name = map.get(15937);
        System.out.println("\n输入学号 15937 ，查询到姓名 " + name);

        /* 删除操作 */
        // 在哈希表中删除键值对 (key, value)
        map.remove(10583);
        System.out.println("\n删除 10583 后，哈希表为\nKey -> Value");
        map.print();

        /* 遍历哈希表 */
        System.out.println("\n遍历键值对 Key->Value");
        for (Pair kv : map.pairSet()) {
            System.out.println(kv.key + " -> " + kv.val);
        }
        System.out.println("\n单独遍历键 Key");
        for (int key : map.keySet()) {
            System.out.println(key);
        }
        System.out.println("\n单独遍历值 Value");
        for (String val : map.valueSet()) {
            System.out.println(val);
        }
    }
}
