package mywork.chapter_sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * 选择排序
 *
 * @author david_van
 * @date 2024/1/28 21:39
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 1, 3, 1, 5, 2};
        selectionSort(nums);
        System.out.println("选择排序完成后 nums = " + Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        int length = nums.length;
        //选择排序 获取未排序区间的最小值，将其放到排序区间的右侧
        for (int i = 0; i < length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            //说明当前值不为最小值，进行交换
            if (minIndex != i) {
                change(nums, minIndex, i);
            }
        }
    }

    private static void change(int[] nums, int minIndex, int i) {
        int temp = nums[minIndex];
        nums[minIndex] = nums[i];
        nums[i] = temp;
    }
}
