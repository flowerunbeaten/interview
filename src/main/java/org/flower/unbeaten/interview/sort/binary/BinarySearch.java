package org.flower.unbeaten.interview.sort.binary;

import lombok.extern.slf4j.Slf4j;

/**
 * @description 二分查找法
 * @author Ryan Wang
 * @date 2022-01-25 10:51:30
 * @version 1.0
 */
@Slf4j
public class BinarySearch {


    /**
     * 选择题做法：
     * 奇数二分取中间
     * 偶数二分取中间靠左
     */

    /**
     * 二分查找方法：
     * 1.前提：有序排列数字A
     * 2.定义左边界L，右边界R，确定搜索范围T，循环执行二分查找
     * 3.获取中间索引 M = Floor((L+R)/2)
     * 4.中间索引的值A[M]与待搜索的值T进行比较
     *  1).A[M] == T 表示找到，返回中间索引值
     *  2).A[M] > T 中间值右侧的其他元素都大于T，无须比较，中间索引左边去找，M-1设置为右边界，重新查找。
     *  3).A[M] < T 中间值左侧的其他元素都小于T，无须比较，中间索引右边去找，M+1设置为左边界，重新查找。
     * 5.当L>R时，表示没有找到，应结束循环。
     * @param args
     */
    public static void main(String[] args) {
        // 定义一个有序数组
        int[] array = {1, 11, 15, 23, 38, 42, 55, 68, 79, 92, 112, 278};
        // 确定要进行查找的数字
        int target = 68;
        int binarySearch = binarySearch(array, target);
        log.info("索引下标为:" + binarySearch);
    }

    public static int binarySearch(int[] a, int t) {
        int l = 0, r = a.length - 1, m;
        while (l <= r) {
//            m = (l + r) / 2;
            // 解决整数溢出问题，无符号右移（只适合整数，等价于(l + r) / 2）
            m = (l + r) >>> 1;
            if (a[m] == t) {
                return m;
            } else if (a[m] > t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }

}
