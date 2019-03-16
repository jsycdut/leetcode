public class BubbleSort{

    // 冒泡的思想就是
    // 从前到后遍历，每次比较相邻的两个数，如果他们的大小顺序颠倒了，比如5，3这种
    // 就将他们的顺序调换过来，变成3,5，遍历到位置n，位置n上的数必定会是[0, n]上最大的
    // 这样从前到后走完一趟的时候，最大的数必定是在本轮所遍历过的所有数的末尾
    // 遍历第一轮，将得到最大的数，且这个数会被交换到末尾的位置，最大的数归位
    // 之后遍历的时候，就只需要走到上一轮归位的数之前即可（毕竟归位了的更大的数就不用管了
    // 遍历第二轮，将得到第二大的数，且这个数会被交换到倒数第二的位置
    // 以此类推，每遍历一轮，都会将一个数归位。总共需要归位n-1个数，因为当n个数中n-1个
    // 都正确归位了的时候，最后一个必定也是归位了的

    // 代码核心就是双重循环，外层循环代表着遍历的轮数，总共需要n-1轮
    // 内层循环代表着本轮的所有交换，用于将本轮最大的数交换应有的位置上
    // 注意在交换的时候，是arr[j]和arr[j + 1]的交换
    // 第一轮，遍历的数据是[0, len - 1]
    // 第二轮，遍历的数据是[0, len - 2]
    // 第三轮，遍历的数据是[0, len - 3]
    // 第四轮，遍历的数据是[0, len - 4]
    // .
    // .
    // .
    // 由于交换的时候，需要j + 1的存在（j从0开始, 且j + 1不能导致数组越界）
    // 所以j + 1有个最大值，即max(j + 1)，代表j + 1能触碰到的数组下标上限
    // 在第一轮的时候，max(j + 1) = len - 1(其余类似)，所以 max(j) = len - 2
    // 所以只需要j < len - 1即可，
    // 第二轮时，max(j + 1) = len - 2, max(j) = len - 3, 所以j < len - 2
    // 之后的轮次类似，所以，内层的j循环，最好就是找到一个变量，来代表当前len到底减几
    // 碰巧的是，外层的遍历的轮数刚好满足这个条件
    // 只需要外层循环代表的轮数从1开始，到len结束刚刚好len - 1轮

    // 优化
    // 其实就结果来说，只需要将本轮最大的数交换到他应有的位置上就行了
    // 没必要逢着顺序不对的就交换，只需要记录当前轮最大的值的索引
    // 最后将该索引上的值，和本轮最大值应当所在的那个索引的值做交换就行了
    // 比如 5 4 3 2 1，第一轮最大的值是5，索引为0，应当归位的那个索引为4，值为1
    // 此时，只需要将索引0和4的值对调就将本轮的最大值归位了
    // 没必要5和4对调，变成4 5 3 2 1，然后5和3对调之类的，这样反而是做了无用功
    // 只是像下面这样写代码，要省点功夫而已，不用额外的变量开销

    static void bubbleSort(int[] arr) {
        if (arr == null) return;

        int len = arr.length;

        // 注意，外层循环i从1开始，到len结束，总共len - 1轮
        // 内层的循环j从0开始，到len - i结束
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) swap(arr, j, j + 1);
            }
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String... args) {
        int[] arr = {55, 12, 192, 5, 0, 32, 5, 42, 99, 345, 5};
        bubbleSort(arr);
        for (int i : arr) System.out.print(i + " ");
    }
}
