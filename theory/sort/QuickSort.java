/**
 * 2019-03-13-09:56  UPDATE
 * 快速排序的核心在于，每次选定一个基准数，并在本轮排序将此基准数归位
 * 所有基准数都归位了，排序也就完成了
 * 每一轮基准数可以随便选，但是通常选第一个，因为方便
 * 归位的操作是，双指针
 * 一个指向队列开头，从前往后遍历，找比基准数大的值
 * 一个指向队列结尾，从后往前遍历，找比基准数小的值
 * 找到了就交换各自的值，等到双指针碰撞的时候，那么就是基准数归位的时候了
 * 和基准数交换的那个数，必须比基准数小
 * 要满足这个条件，就得从后往前的那个指针先动，这样它就会停在一个比基准数小的位置上
 * 然后从前往后的那个指针就会碰上去（这里指的是碰撞的最后一步，不要钻牛角尖想东想西，去想什么最开始就等着碰啊这种沙雕想法）
 * 基准数一归位，其左边都是比他小的，右边都是比他大的，然后递归左右就行了
 * 递归出口就是只剩一个数的时候，此时start是大于end的，判断就退出便可，
 * 注意，3个while那里的复杂度是end-start，别沙雕的看成n * n
 * @author jsy
 * @since 2017-08-19-16:07
 **/
public class QuickSort {
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    quickSort(int[] arr, int start, int end) {
        if (start >= end) return;

        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] > arr[start]) j--;
            while (i < j && arr[i] < arr[start]) i++;
            swap(ar, i, j);
        }
        swap(arr, start, i);
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }
}
