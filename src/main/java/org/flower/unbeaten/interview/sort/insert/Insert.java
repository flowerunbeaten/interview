package org.flower.unbeaten.interview.sort.insert;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description 插入排序
 * @author Ryan Wang
 * @date 2022-01-25 17:08:36
 * @version 1.0
 */
@Slf4j
public class Insert {

    /**
     * 插入排序：
     * 1.将数组分为两个区域，排序区域和未排序区域，每一轮从未排序区域中取出第一个元素，插入到排序区域（需要保证顺序）。
     * 2.重复以上步骤，直到整个数组有序。
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {12, 45, 10, 22, 556, 31, 89, 56, 111};
        insert(array);
    }

    public static void insert(int[] array) {
        // i代表待插入元素的索引
        for (int i = 1; i < array.length; i++) {
            // 代表插入的元素值
            int t = array[i];
            // 代表已排序区域的元素索引
            int j = i - 1;
            while (j >= 0) {
                if (t < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    // 退出循环，减少比较次数
                    break;
                }
                j--;
            }
            array[j + 1] = t;
            log.info(Arrays.toString(array));
        }
    }

}
