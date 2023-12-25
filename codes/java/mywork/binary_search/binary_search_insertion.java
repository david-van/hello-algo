/**
 * File: binary_search_insertion.java
 * Created Time: 2023-08-04
 * Author: Krahets (krahets@163.com)
 */

package mywork.binary_search;

class binary_search_insertion {
    /* 二分查找插入点（无重复元素） */
    static int binarySearchInsertionSimple(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        // 区间 [start,end]
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] < target) {
                //中间值小于目标值，说明在[middle+1,end]
                start = middle + 1;
            } else if (nums[middle] > target) {
                //中间值大于目标值，说明在[start,middle-1]
                end = middle - 1;
            } else {
                break;
            }
        }
        return middle + 1;

    }

    /* 二分查找插入点（存在重复元素） */
    static int binarySearchInsertion(int[] nums, int target) {
        return -1;
    }

    public static void main(String[] args) {
        // 无重复元素的数组
        int[] nums = {1, 3, 6, 8, 12, 15, 23, 26, 31, 35};
        System.out.println("\n数组 nums = " + java.util.Arrays.toString(nums));
        // 二分查找插入点
        for (int target : new int[]{6, 9}) {
            int index = binarySearchInsertionSimple(nums, target);
            System.out.println("元素 " + target + " 的插入点的索引为 " + index);
        }

        // 包含重复元素的数组
        nums = new int[]{1, 3, 6, 6, 6, 6, 6, 10, 12, 15};
        System.out.println("\n数组 nums = " + java.util.Arrays.toString(nums));
        // 二分查找插入点
        for (int target : new int[]{2, 6, 20}) {
            int index = binarySearchInsertion(nums, target);
            System.out.println("元素 " + target + " 的插入点的索引为 " + index);
        }
    }
}
