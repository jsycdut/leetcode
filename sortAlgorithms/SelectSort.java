package algorithms;

/**
 * 选择排序
 * 这是最简单的排序算法，思想很好懂
 * 就是两个指针，外层指针指向假想的当前位置最小值，内层指针在后面的位置搜寻真正的最小值
 * 两个指针都是往后走的
 * 找到最小的以后进行交换
 *
 * @author jsy
 * @since 2017-08-19-19:58
 **/
public class SelectSort {
    /**
     * 这是最笨的写法，每比较出一个较小值就交换，最坏情况下会有(N-1) + (N-2) + ... + 1次交换
     * 是N平方的级别
     *
     * @param a
     */
    void simpleSelectSort(int[] a) {
        if (a == null) {
            return;
        }
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                if (a[j] < a[i]) {
                    swap(a, i, j);
                }
            }
        }

    }

    /**
     * 这是改进写法，最坏情况下共N次交换，效率更高
     * 关于下面最大索引的写法，可以写作
     * for (int i = 0; i < a.length ; i++)
     * for (int j = i; j < a.length; j++)
     * 但是写作下面的代码里面的形式，可以避免少数几次的比较
     * 虽然没有啥大意义，但也算是求精吧
     *
     * @param a
     */
    void improvedSelectSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[i]) {
                    smallest = j;
                }
            }
            swap(a, i, smallest);
        }
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}
