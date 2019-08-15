public class Dijkstra{
  public static void main(String... args) {
    int[][] matrix = {
	    { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
            { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
            { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
            { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
            { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
            { 0, 0, 4, 0, 10, 0, 2, 0, 0 }, 
            { 0, 0, 0, 14, 0, 2, 0, 1, 6 }, 
            { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
            { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
    }; 

    int start = 0;

    int[] dis = new int[9];

    int inf = Integer.MAX_VALUE;
    boolean[] visited = new boolean[9];
    int[] path = new int[9];

    for (int i = 0; i < dis.length; i++) {
      dis[i] = inf; 
    }
    
    dis[1] = 4;
    dis[7] = 8;

    for (int i = 1; i < dis.length; i++) {
      // find min
      int min = inf;
      int tar = start;
      for (int j = 0; j < dis.length; j++) {
        if (dis[j] < min && !visited[j]) {
	  min = dis[j];
	  tar = j;
	} 
      }
 
      visited[tar] = true;
      for (int k = 0; k < dis.length; k++) {
        if (matrix[tar][k] != 0 && dis[tar] + matrix[tar][k] < dis[k]) {
	  path[k] = tar;
	  dis[k] = dis[tar] + matrix[tar][k];
	}
      }
    }

    System.out.printf("%-10s%-10s%-10s", "target", "distance", "path(reversed)");
    System.out.println();

    for (int i = 0; i < dis.length; i++) {
      if (i == start) continue;

      System.out.printf("%-10d%-10d", i, dis[i]);

      int p = path[i];
      System.out.print(i + "->");

      while (p != 0) {
	System.out.print(p + "->");
        p = path[p];
      }

      System.out.println(0);
    }
  }
}
