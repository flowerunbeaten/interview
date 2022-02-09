package org.flower.unbeaten.interview.sort.quick;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @description 快排（单边循环）
 * @author Ryan Wang
 * @date 2022-02-09 09:30:52
 * @version 1.0
 */
@Slf4j
public class UnilateralCirculation {

    public static void main(String[] args) {
        int[] array = {12, 45, 10, 3, 6, 98, 4};
        quick(array, 0, array.length - 1);
    }

    /**
     * 递归调用
     * @param array
     * @param l 上边界
     * @param h 下边界
     */
    public static void quick(int[] array, int l, int h) {
        if (l >= h) {
            return;
        }
        // 基准点索引值
        int p = partition(array, l, h);
        // 左分区范围确定
        quick(array, l, p - 1);
        // 右分区范围确定
        quick(array, p + 1, h);
    }

    /**
     * 单边循环快排
     * 1.选择最右元素作为基准点元素。
     * 2.j指针负责找到比基准点小的元素，一旦找到则与i进行交换。
     * 3.i指针负责维护小于基准点元素的边界，也是每次交换的目标索引。
     * 4.最后基准点与i交换，i即为分区位置。
     * @param array 数组
     * @param l 上边界
     * @param h 下边界
     * @return
     */
    public static int partition(int[] array, int l, int h) {
        // 基准点元素
        int pv = array[h];
        // 待交换元素的目标索引
        int i = l;
        for (int j = l; j < h; j++) {
            if (array[j] < pv) {
                if (i != j) {
                    swap(array, i, j);
                }
                i++;
            }
        }
        if (i != h) {
            swap(array, h, i);
        }
        log.info(Arrays.toString(array) + " i=" + i);
        // 返回值代表了基准点元素所在的正确索引，用它确定下一轮分区的边界
        return i;
    }

    public static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

}
