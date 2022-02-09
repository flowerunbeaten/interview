package org.flower.unbeaten.interview.sort.selection;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description 选择排序
 * @author Ryan Wang
 * @date 2022-01-25 16:09:42
 * @version 1.0
 */
@Slf4j
public class Selection {

    /**
     * 选择排序：
     * 1.将数组分为两个子集，排序的和未排序的，每一轮从未排序的子集中选出最小的元素，放入排序子集。
     * 2.重复以上步骤，直到整个数组有序。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 45, 32, 5, 48, 17, 3, 89, 189};
        log.info("选择排序结果为:" + Arrays.toString(selectionSortV1(array)));
    }

    /**
     * 选择排序优化版本
     * @param array
     * @return
     */
    public static int[] selectionSortV1(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            // i代表每轮选择最小元素要交换到的目标索引
            // minIndex代表最小元素的索引
            int minIndex = i;
            for (int j = minIndex + 1; j < array.length; j++) {
                // 找到最小的数
                if (array[minIndex] > array[j]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            // 选择排序优化
            if (minIndex != i) {
                int t = array[minIndex];
                array[minIndex] = array[i];
                array[i] = t;
            }
        }
        return array;
    }

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] selectionSortV2(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            // i代表每轮选择最小元素要交换到的目标索引
            // minIndex代表最小元素的索引
            int minIndex = i;
            for (int j = minIndex + 1; j < array.length; j++) {
                // 找到最小的数
                if (array[minIndex] > array[j]) {
                    // 将最小数的索引保存
                    minIndex = j;
                }
            }
            int t = array[minIndex];
            array[minIndex] = array[i];
            array[i] = t;
        }
        return array;
    }

}
