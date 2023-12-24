package mywork.heap;

import utils.PrintUtil;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopK {
    public static void main(String[] args) {
        int[] nums = {1, 7, 6, 3, 2, 4};
        int k = 3;
        //取小顶堆，则堆的数据即为最大的K个
        Queue<Integer> res = topKHeap(nums, k);
        System.out.println("最大的 " + k + " 个元素为");
        PrintUtil.printHeap(res);
    }

    private static Queue<Integer> topKHeap(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 < o2) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
//        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            queue.offer(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            //判断其值是否大于顶节点，如果大于，则添加，否则跳过
            if (nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        return queue;
    }
}
