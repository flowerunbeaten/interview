package org.flower.unbeaten.interview.sort.bubble;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description 冒泡排序
 * @author Ryan Wang
 * @date 2022-01-25 10:57:50
 * @version 1.0
 */
@Slf4j
public class Bubble {

    /**
     * 冒泡排序：
     * 1.一次比较数组中相邻两个元素的大小，若a[i]>a[i+1]，则交换两个元素，两两都比较一遍称为一轮冒泡，结果是让最大的元素排至最后。
     * 2.重复以上步骤，直到整个数组有序
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {10, 564, 354, 23, 9, 29, 48};
        int[] bubbleSort = bubbleSortV2(array);
        log.info("冒泡排序结果为:" + Arrays.toString(bubbleSort));
    }

    /**
     * 冒泡排序基础优化
     * @param array
     * @return
     */
    public static int[] bubbleSortV1(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return array;
    }

    /**
     * 冒泡排序最终优化
     * @param array
     * @return
     */
    public static int[] bubbleSortV2(int[] array) {
        int n = array.length - 1;
        while (true) {
            int last = 0;
            for (int i = 0; i < n; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                    last = i;
                }
            }
            n = last;
            if (n == 0) {
                break;
            }
        }
        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
