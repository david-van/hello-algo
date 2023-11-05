/**
 * File: linkedlist_queue.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package mywork.chapter_stack_and_queue;

import utils.MyException;

import java.util.Arrays;

/* 基于链表实现的队列 */
class LinkedListQueue {
    private ListNode front, rear; // 头节点 front ，尾节点 rear
    private int queSize = 0;

    public LinkedListQueue() {
        front = null;
        rear = null;
    }

    /* 获取队列的长度 */
    public int size() {
        return queSize;
    }

    /* 判断队列是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 入队 */
    public void push(int num) {
        //判断是否为空，
        if (isEmpty()) {
            //初始化
            front = new ListNode(num);
            rear = front;
            front.next = rear;
            rear.prev = front;
        } else {
            //初始化
            ListNode node = new ListNode(num);
            rear.next = node;
            rear = node;
        }
        queSize++;

    }

    /* 出队 */
    public int pop() {
        if (isEmpty()) {
            throw new MyException("队列为空");
        }
        //将尾节点
        int result = front.val;
        front = front.next;
        queSize--;
        return result;

    }

    /* 访问队首元素 */
    public int peek() {
        return front.val;
    }

    /* 将链表转化为 Array 并返回 */
    public int[] toArray() {
        int[] result = new int[queSize];
        ListNode node = front;
        for (int i = 0; i < queSize; i++) {
            result[i] = node.val;
            node = node.next;
        }
        return result;
    }
}

public class linkedlist_queue {
    public static void main(String[] args) {
        /* 初始化队列 */
        LinkedListQueue queue = new LinkedListQueue();

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
    }
}
