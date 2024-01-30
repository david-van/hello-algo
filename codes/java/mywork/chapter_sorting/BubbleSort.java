package mywork.chapter_sorting;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author david_van
 * @date 2024/1/28 22:08
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 1, 5, 2};
//        bubbleSort(nums);
        bubbleSortWithFlag(nums);
        System.out.println("排序完成后 nums = " + Arrays.toString(nums));

    }

    private static void bubbleSortWithFlag(int[] nums) {
        int length = nums.length;
        //冒泡排序，每次循环，如果比较的两个元素，左边>右边，则交换，一轮循环后，则最大的元素在最右侧
        //剩下的区间为：[0,m-1]，如果该区间不再需要排序，那么表明已经是有序的，直接跳出循环
        boolean breakFlag = true;
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //此处的num[j+1] 不会越界
                if (nums[j] > nums[j + 1]) {
                    change(nums, j, j + 1);
                    breakFlag = false;
                }
            }
            if (breakFlag) {
                break;
            }
        }
    }

    private static void bubbleSort(int[] nums) {
        int length = nums.length;
        //冒泡排序，每次循环，如果比较的两个元素，左边>右边，则交换，一轮循环后，则最大的元素在最右侧
        //剩下的区间为：[0,m-1]
        //i -->max(length-1)
//        for (int i = 0; i < length; i++) {
//
//        }
        for (int i = length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                //此处的num[j+1] 不会越界
                if (nums[j] > nums[j + 1]) {
                    change(nums, j, j + 1);
                }
            }
        }
    }

    private static void change(int[] nums, int minIndex, int i) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
    }
}
