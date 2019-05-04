# 全排列 Permutaion

全排列，就是数学上的全排列，给你n个元素，输出这n个元素的所有排列。乍看一下用代码实现比较难受，其实掌握DFS（深度优先搜索）就很好解决。

现在，设有1、2、3、4四个数，求其全排列

## DFS

思路如下：全排列为4个数`_ _ _ _`，只需要在每一位上填1 2 3 4中的一个数即可，在每一位上遍历所有可能被填到那里的数（1 2 3 4里面的某一个），然后处理下一位即可，不过这个需要标记哪些数用过，哪些数没有用过，在每次选择数的时候，选择那些没用过的，所以需要一个boolean数组，记录使用情况，另外还需要一个数组，保存结果。

```java
void dfs(int[] arr, int step, int term) {
    if (step == term) {
        for (int i : result) {
            System.out.print(i + " " );
        }
        System.out.println();
        return;
    }

    for (int i = 0; i < arr.length; i++) {
        if (!visited[i]) {
            result[step] = arr[i];
            visited[i] = true;
            dfs(arr, step + 1, term);
            visited[i] = false;
        }
    }

}

int[] arr = {1, 2, 3, 4};

int[] result = new int[4];
boolean[] visited = new boolean[4];

dfs(arr, 0, arr.length);
```

## 优化的DFS

这个DFS的优化来源于全排列的产生过程，上面DFS产生全排列的思想比较朴素，就是枚举每个位置上所有合法的可能，复杂度为O(N^4)，N为所有参与全排列的元素个数。

但是如果将全排列的形成过程换个思路看，全排列的第一位是第一位数字同第一到第四位数字的依次交换，全排列的第二位是在确定第一位的情况下，第二位同第二到第四位的依次交换，第三和第四位同理，利用这个交换的思路，仍然是DFS，但是我们不必记录每个数字的使用情况，因为某个元素在使用之后在后面的递归用不到了，同时可以利用交换本身，就原地利用已有的装载数据的数组来记录结果，节省了空间复杂度，同时空间复杂度由于递归层层次加深，对应位置上的交换枚举数量变少，变为O(N!)。

```java
void optimizedDFS(int[] arr, int step, int term) {
    if (step == term) {
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
        return;
    }

    for (int i = step; i < arr.length; i++) {
        swap(arr, step, i);
        optimizedDFS(arr, step + 1, term);
        swap(arr, step, i);
    }
}

void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
}

int[] arr = {1, 2, 3, 4};

optimizedDFS(arr, 0, arr.length);

```

**注意**

当参与全排列的元素中有重复的元素时，全排列也会出现重复。
