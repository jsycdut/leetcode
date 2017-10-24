package algorithms;

/**
 * 快速排序算法，在排序算法里面很常用
 * 三个while，一外两内，保持前后不交叉
 * 然后递归，就是快速排序了
 *
 * @author jsy
 * @since 2017-08-19-16:07
 **/
public class QuickSort {
    /*
     *这是我看了啊哈磊的c语言排序算法后改写为java的
     *把所有的调用都放到了一个方法内，但是算法导论上
     *是分为两个方法，我打算明天把那个算法加上·jsy
     */
    void quickSort(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int flag = a[lo];
        int left = lo;
        int right = hi;
        while (left != right) {

            while (left < right && flag >= a[right]) {
                right--;
            }
            while (left < right && flag <= a[left]) {
                left++;
            }

            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }

        }

        a[lo] = a[left];
        a[left] = flag;

        quickSort(a, lo, left - 1);
        quickSort(a, left + 1, hi);
    }

}
