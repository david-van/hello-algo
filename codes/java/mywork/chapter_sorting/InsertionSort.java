package mywork.chapter_sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入排序
 *
 * @author david_van
 * @date 2024/1/28 22:40
 */
public class InsertionSort {
    public static void main(String[] args) {

        int[] nums = {4, 1, 3, 1, 5, 2};
//        insertionSort(nums);
        insertionSort2(nums);
        System.out.println("排序完成后 nums = " + Arrays.toString(nums));
    }

    private static void insertionSort2(int[] nums) {
        //插入排序，将未排序的数据添加到已经排序好的区间内，
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            addCorrectPosition(nums, 0, i);
        }
    }

    private static void insertionSort(int[] nums) {
        //插入排序，将未排序的数据添加到已经排序好的区间内，
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            int base = nums[i];
            int j = i - 1;
            // 内循环：将 base 插入到已排序部分的正确位置
            //在已经排序的数组中，找到base对应的index，然后将base插入到数组中,
//            可以参照list.add(index,value)中的方式
            //此处使用while循环，也就是将[0,baseIndex] [baseIndex,i]，
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j]; // 将 nums[j] 向右移动一位
                j--;
            }
            nums[j + 1] = base;        // 将 base 赋值到正确位置
        }
        List<Integer> list = new ArrayList<>();
        list.add(2, 222);
    }

    private static void addCorrectPosition(int[] num, int start, int end) {
        //end索引位置就是需要进行赋值的位置，
        int value = num[end];
        //使用倒序循环，应该比正向循环更有优化
//        0 3 5 2

        for (; start < end; start++) {
            if (num[start] > value) {
                break;
            }
        }
        //此时 start 即为将要插入的index
//        从start-->end 进行逐个右移，
        for (int i = end - 1; i > start; i--) {
            num[end] = num[end - 1];
        }
        num[start] = value;
    }

}
