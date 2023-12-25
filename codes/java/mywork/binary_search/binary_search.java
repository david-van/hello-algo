/**
 * File: binary_search.java
 * Created Time: 2022-11-25
 * Author: Krahets (krahets@163.com)
 */

package mywork.binary_search;

public class binary_search {
    /* 二分查找（双闭区间） */
    static int binarySearch(int[] nums, int target) {
        //初始化两个参数，表示开始和结束，当两者相交，则表示结束
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            //判断target和中间值的大小
            if (nums[middle] < target) {
                //中间值小，则在右区间[middle+1,end]
                start = middle + 1;
            } else if (nums[middle] > target) {
                //中间值大，在左区间 [start,middle-1]
                end = middle - 1;
            } else {
                return middle;
            }
        }
        //说明不存在该值
        return -1;
    }

    /* 二分查找（左闭右开区间） */
    static int binarySearchLCRO(int[] nums, int target) {
        //初始化两个参数，表示开始和结束，当两者相交，则表示结束
        // [start,end)
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int middle = (end - start) / 2 + start;
            //判断target和中间值的大小
            if (nums[middle] < target) {
                //中间值小，则在右区间[middle+1,end)
                start = middle + 1;
            } else if (nums[middle] > target) {
                //中间值大，在左区间 [start,middle-1)
                end = middle;
            } else {
                return middle;
            }
        }
        //说明不存在该值
        return -1;
    }

    public static void main(String[] args) {
        int target = 35;
        int[] nums = {1, 3, 6, 8, 12, 15, 23, 26, 31, 35};

        /* 二分查找（双闭区间） */
        int index = binarySearch(nums, target);
        System.out.println("目标元素 6 的索引 = " + index);

        /* 二分查找（左闭右开区间） */
        index = binarySearchLCRO(nums, target);
        System.out.println("目标元素 6 的索引 = " + index);
    }
}
