public class Hanoi {
    public static void main(String... args) {
        hanoi(3, 'a', 'b', 'c');
    }

    // hanoi的意思是将1到n共n个盘子从source移到target, 不是将第n号盘子从source移动到target
    static void hanoi(int n, char source, char temp, char target) {
        if (n == 1) {
            move(1, source, target);
            return;
        }

        hanoi(n - 1, source, target, temp); // 将1到n-1总共n-1个盘子从source移到temp
        move(n, source, target); // 亲自将第n个盘子从source移到target
        hanoi(n - 1, temp, source, target); // 将1到n-1总共n-1个盘子从temp移动到target
        /* 两次调用hanoi参数的顺序是不一样的，第一次是要把前n-1个盘子移到temp柱子上 */
        /* 第二次是把temp柱子上的移动到target柱子上，中间手工接了一次移动盘子的操作 */
    }

    static void move(int n, char source, char target) {
        System.out.println("move plate " + n + " " + source + " ===> " + target);
    }
}
