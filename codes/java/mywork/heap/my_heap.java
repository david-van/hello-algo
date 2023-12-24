/**
 * File: my_heap.java
 * Created Time: 2023-01-07
 * Author: Krahets (krahets@163.com)
 */

package mywork.heap;

import utils.PrintUtil;

import java.util.*;

/* 大顶堆 */
class MaxHeap {
    // 使用列表而非数组，这样无须考虑扩容问题
    private List<Integer> maxHeap;

    /* 构造方法，根据输入列表建堆 */
    public MaxHeap(List<Integer> nums) {
        // 将列表元素原封不动添加进堆
        maxHeap = new ArrayList<>(nums);
        // 堆化除叶节点以外的其他所有节点
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /* 获取左子节点索引 */
    private int left(int i) {
        return 2 * i + 1;
    }

    /* 获取右子节点索引 */
    private int right(int i) {
        return 2 * i + 2;
    }

    /* 获取父节点索引 */
    private int parent(int i) {
        return (i - 1) / 2; // 向下整除
    }

    /* 交换元素 */
    private void swap(int i, int j) {
        Integer temp = maxHeap.get(i);
        maxHeap.set(i, maxHeap.get(j));
        maxHeap.set(j, temp);
    }

    /* 获取堆大小 */
    public int size() {
        return maxHeap.size();
    }

    /* 判断堆是否为空 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* 访问堆顶元素 */
    public int peek() {
        return maxHeap.get(0);
    }

    /* 元素入堆 */
    public void push(int val) {
        // 添加节点
        maxHeap.add(val);
        // 从底至顶堆化
        siftUp(size() - 1);
    }

    /* 从节点 i 开始，从底至顶堆化 */
    private void siftUp(int i) {
        while (true) {
            int parent = parent(i);
            if (parent < 0 || maxHeap.get(parent) >= i) {
                //无父节点，或者父节点大于子节点，也就是符合排序，那么也就是说符合堆化，也就不再需要继续判断
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    /* 元素出堆 */
    public int pop() {
        // 判空
        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        //数据交换、移除最后的节点，进行堆化
        swap(0, size() - 1);
        int result = maxHeap.remove(size() - 1);
        siftDown(0);
        return result;
    }

    /* 从节点 i 开始，从顶至底堆化 */
    private void siftDown(int i) {
        //从顶至底，进行堆化，如果当前节点符合，那么其子节点也是符合的堆
        while (true) {
            int right = right(i);
            int left = left(i);
            //假定最大值为当前值，也就是不需要进行堆化
            int max = i;
            if (right < size() && maxHeap.get(right) > maxHeap.get(max)) {
                max = right;
            }
            if (left < size() && maxHeap.get(left) > maxHeap.get(max)) {
                max = left;
            }

            //左右均没有越界，并且存在左右节点大于顶点，则进行堆化
            if (max == i) {
                break;
            }
            swap(i, max);
            i = max;
        }
    }

    /* 打印堆（二叉树） */
    public void print() {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        queue.addAll(maxHeap);
        PrintUtil.printHeap(queue);
    }
}

public class my_heap {
    public static void main(String[] args) {
        /* 初始化大顶堆 */
        MaxHeap maxHeap = new MaxHeap(Arrays.asList(9, 8, 6, 6, 7, 5, 2, 1, 4, 3, 6, 2));
        System.out.println("\n输入列表并建堆后");
        maxHeap.print();

        /* 获取堆顶元素 */
        int peek = maxHeap.peek();
        System.out.format("\n堆顶元素为 %d\n", peek);

        /* 元素入堆 */
        int val = 7;
        maxHeap.push(val);
        System.out.format("\n元素 %d 入堆后\n", val);
        maxHeap.print();

        /* 堆顶元素出堆 */
        peek = maxHeap.pop();
        System.out.format("\n堆顶元素 %d 出堆后\n", peek);
        maxHeap.print();

        /* 获取堆大小 */
        int size = maxHeap.size();
        System.out.format("\n堆元素数量为 %d\n", size);

        /* 判断堆是否为空 */
        boolean isEmpty = maxHeap.isEmpty();
        System.out.format("\n堆是否为空 %b\n", isEmpty);
    }
}
