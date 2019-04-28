public class Permutaion {
    static int[] result = new int[4];

    static boolean[] visited = new boolean[4];

    public static void main(String... args) {
        int[] arr = {1, 2, 3, 4};
        dfs(arr, 0, arr.length);
        optimizedDFS(arr, 0, arr.length);

    }

    static void dfs(int[] arr, int step, int term) {
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

   static void optimizedDFS(int[] arr, int step, int term) {
       if (step == term) {
           for (int i : arr) {
               System.out.print(i + " ");
           }
           System.out.println();
           return;
       }

       for (int i = step; i < arr.length; i++) {
           swap(arr, step, i);
           optimizedDFS(arr, step + 1, term);
           swap(arr, step, i);
       }
   }

   static void swap(int[] arr, int i, int j) {
       int temp = arr[i];
       arr[i] = arr[j];
       arr[j] = temp;
   }
}
