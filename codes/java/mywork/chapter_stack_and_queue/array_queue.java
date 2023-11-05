/**
 * File: array_queue.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_stack_and_queue;

import java.util.Arrays;

/* 基于环形数组实现的队列 */
class ArrayQueue {
    private int[] nums; // 用于存储队列元素的数组
    private int front; // 队首指针，指向队首元素
    private int queSize; // 队列长度

    public ArrayQueue(int capacity) {
        nums = new int[capacity];
    }

    /* 获取队列的容量 */
    public int capacity() {
        return nums.length;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return queSize == 0;
    }

    /* 入队 */
    public void push(int num) {
        //判断容量是否足够
        if (queSize == nums.length) {
            System.out.println("队列已经满了");
            return;
        }
        //通过计算front 和 queSize 获取对应的索引
        int i = (front + queSize) % capacity();
        nums[i] = num;
        queSize++;

    }

    /* 出队 */
    public int pop() {
        int peek = peek();
        //通过计算front 和 queSize 获取对应的索引
        //说明已经到了最后一位
        if (front + 1 >= capacity()) {
            front = 0;
        } else {
            front = front + 1;
        }
        queSize--;
        return peek;
    }

    /* 访问队首元素 */
    public int peek() {
        if (isEmpty()) {
            System.out.println("队列已经空了");
            throw new IndexOutOfBoundsException();
        }
        return nums[front];
    }

    /* 返回数组 */
    public int[] toArray() {
        int[] res = new int[queSize];
        for (int i = 0, j = front; i < queSize; i++, j++) {
            res[i] = nums[j % capacity()];
        }
        return res;
    }
}

public class array_queue {
    public static void main(String[] args) {

        Object[] objects = new Object[10];
        System.out.println(objects.length);
        /* 初始化队列 */
        int capacity = 10;
        ArrayQueue queue = new ArrayQueue(capacity);

        /* 元素入队 */
        queue.push(1);
        queue.push(3);
        queue.push(2);
        queue.push(5);
        queue.push(4);
        System.out.println("队列 queue = " + Arrays.toString(queue.toArray()));

        /* 访问队首元素 */
        int peek = queue.peek();
        System.out.println("队首元素 peek = " + peek);

        /* 元素出队 */
        int pop = queue.pop();
        System.out.println("出队元素 pop = " + pop + "，出队后 queue = " + Arrays.toString(queue.toArray()));

        /* 获取队列的长度 */
        int size = queue.size();
        System.out.println("队列长度 size = " + size);

        /* 判断队列是否为空 */
        boolean isEmpty = queue.isEmpty();
        System.out.println("队列是否为空 = " + isEmpty);

        /* 测试环形数组 */
        for (int i = 0; i < 10; i++) {
            queue.push(i);
            queue.pop();
            System.out.println("第 " + i + " 轮入队 + 出队后 queue = " + Arrays.toString(queue.toArray()));
        }
    }
}
