package algorithms;

/**
 * 插入排序，其思路来自于打牌，比如你斗地主，你清理牌的之后，其实用的就是插入排序
 * 将后面抽到的牌插入到前面已经排好序的一部分里面，就是插入排序的精髓
 * 插入排序特别适合局部有序的和相对有序的输入，效率比选择排序高多了
 *
 * @author jsy
 * @since 2017-08-19-20:23
 **/
public class InsertSort {
    /**
     * 外层指针：-------------------->
     * 内层指针：---->
     * 这是追击型的插入排序，外层指针从前往后-->
     * 内层指针也是从前往后--->不过是从开始处向外层指针所在处追击
     * 若发生外层指针指向的数比内层指针指向的数小，则交换，内层指针继续追击，直至两指针相邻为止
     *
     * @param a
     */
    void rearInsertSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[j] > a[i]) {
                    swap(a, i, j);
                }
            }
        }

    }

    /**
     * 外层指针：        --------->
     * 内层指针：<-------
     * 这是回溯型的插入排序，外层指针总体来看是往后走的------>，而内层指针则是从外层指针所在处为开始
     * 然后向数组开始处走<----------，两者是移动方向是背离的，所以我称之为回溯型
     *
     * @param a
     */
    void backInsertSort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    swap(a, j - 1, j);
                }
            }
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
