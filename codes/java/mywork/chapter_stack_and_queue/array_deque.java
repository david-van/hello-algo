/**
 * File: array_deque.java
 * Created Time: 2023-02-16
 * Author: Krahets (krahets@163.com), FangYuan33 (374072213@qq.com)
 */

package mywork.chapter_stack_and_queue;

import java.util.Arrays;

/* 基于环形数组实现的双向队列 */
class ArrayDeque {
    private int[] nums; // 用于存储双向队列元素的数组
    private int front; // 队首指针，指向队首元素
    private int queSize; // 双向队列长度

    /* 构造方法 */
    public ArrayDeque(int capacity) {
        nums = new int[capacity];
        front = queSize = 0;
    }

    /* 获取双向队列的容量 */
    public int capacity() {
        return nums.length;
    }

    /* 获取双向队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断双向队列是否为空 */
    public boolean isEmpty() {
        return queSize == 0;
    }

    /* 计算环形数组索引 */
    private int index(int i) {
        //相加取余，
        // 当 i 越过数组尾部后，回到头部
        // 当 i 越过数组头部后，回到尾部
        return (capacity() + i) % capacity();
    }

    /* 队首入队 */
    public void pushFirst(int num) {
        if (queSize == capacity()) {
            throw new RuntimeException("队列已满");
        }
        front = index(front - 1);
        nums[front] = num;
        queSize++;

    }

    /* 队尾入队 */
    public void pushLast(int num) {
        if (queSize == capacity()) {
            throw new RuntimeException("队列已满");
        }
        int index = index((front + queSize));
        nums[index] = num;
        queSize++;
    }

    /* 队首出队 */
    public int popFirst() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int num = nums[front];
        front = index(front + 1);
        queSize--;
        return num;
    }

    /* 队尾出队 */
    public int popLast() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int num = peekLast();
        queSize--;
        return num;
    }

    /* 访问队首元素 */
    public int peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return nums[front];
    }

    /* 访问队尾元素 */
    public int peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return nums[index(front + queSize - 1)];
    }

    /* 返回数组用于打印 */
    public int[] toArray() {
        int[] array = new int[queSize];
        for (int i = front, j = 0; i < front + queSize; i++, j++) {
            array[j] = nums[index(i)];
        }
        return array;
    }
}

public class array_deque {
    public static void main(String[] args) {
        /* 初始化双向队列 */
        ArrayDeque deque = new ArrayDeque(10);
        deque.pushLast(3);
        deque.pushLast(2);
        deque.pushLast(5);
        System.out.println("双向队列 deque = " + Arrays.toString(deque.toArray()));

        /* 访问元素 */
        int peekFirst = deque.peekFirst();
        System.out.println("队首元素 peekFirst = " + peekFirst);
        int peekLast = deque.peekLast();
        System.out.println("队尾元素 peekLast = " + peekLast);

        /* 元素入队 */
        deque.pushLast(4);
        System.out.println("元素 4 队尾入队后 deque = " + Arrays.toString(deque.toArray()));
        deque.pushFirst(1);
        System.out.println("元素 1 队首入队后 deque = " + Arrays.toString(deque.toArray()));

        /* 元素出队 */
        int popLast = deque.popLast();
        System.out.println("队尾出队元素 = " + popLast + "，队尾出队后 deque = " + Arrays.toString(deque.toArray()));
        int popFirst = deque.popFirst();
        System.out.println("队首出队元素 = " + popFirst + "，队首出队后 deque = " + Arrays.toString(deque.toArray()));

        /* 获取双向队列的长度 */
        int size = deque.size();
        System.out.println("双向队列长度 size = " + size);

        /* 判断双向队列是否为空 */
        boolean isEmpty = deque.isEmpty();
        System.out.println("双向队列是否为空 = " + isEmpty);
    }
}
