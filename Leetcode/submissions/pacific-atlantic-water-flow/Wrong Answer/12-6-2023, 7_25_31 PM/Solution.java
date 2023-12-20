// https://leetcode.com/problems/pacific-atlantic-water-flow

class Solution {

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    List<List<Integer>> list = new ArrayList<>();
    int n = heights.length;
    int m = heights[0].length;

    if (n == 1 && n == m) {
      List<Integer> temp = new ArrayList<>();
      temp.add(0);
      temp.add(0);
      list.add(new ArrayList<>(temp));
      return list;
    }

    int[][] dir = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int sr = i, sc = j;
        int parentHeight = heights[i][j];
        for (int k = 0; k < 4; k++) {
          int cr = sr + dir[k][0];
          int cc = sc + dir[k][1];

          if (cr < n && cr >= 0 && cc < m && cc >= 0) {
            int childHeight = heights[cr][cc];
            List<Integer> temp = new ArrayList<>();
            temp.add(sr);
            temp.add(sc);

            int parentCordinates = sr + sc;
            int childCordinates = cr + cc;

            if (n != m) {
              if (parentCordinates == n - 1 && childCordinates == m - 1) {
                if (
                  childHeight <= parentHeight && !list.contains(temp)
                ) list.add(new ArrayList(temp));
              } else if (
                parentCordinates == m - 1 && childCordinates == n - 1
              ) {
                if (
                  childHeight <= parentHeight && !list.contains(temp)
                ) list.add(new ArrayList(temp));
              }
            } else {
              if (childCordinates == n - 1 || childCordinates == m - 1) {
                if (
                  childHeight <= parentHeight && !list.contains(temp)
                ) list.add(new ArrayList(temp));
              } else if (
                parentCordinates == n - 1 || parentCordinates == m - 1
              ) {
                if (
                  childHeight <= parentHeight && !list.contains(temp)
                ) list.add(new ArrayList(temp));
              }
            }
          }
        }
      }
    }

    return list;
  }
}
