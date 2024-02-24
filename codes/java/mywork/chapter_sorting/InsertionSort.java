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
            int temp = nums[i];
            //已排序的数组为[0,i-1]
            int j = i - 1;
            while (j >= 0) {
                if (nums[j] > temp) {
                    //该处的数组值进行右移
                    nums[j + 1] = nums[j];
                } else {
                    //说明此处的数组已经小于待排序的值了，也就不用再将数组的值进行右移，跳出循环
                    break;
                }
                //索引位左移
                j--;
            }
            //将待排序的值放在正确的索引位上面
            nums[j + 1] = temp;
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
            // 将 base 赋值到正确位置
            nums[j + 1] = base;
        }
    }

}
