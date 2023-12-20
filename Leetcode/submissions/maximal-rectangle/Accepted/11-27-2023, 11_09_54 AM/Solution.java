// https://leetcode.com/problems/maximal-rectangle

class Solution {
    public int maximalRectangle(char[][] matrix) {
        
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '1') arr[i][j] = 1;
            }
        }

        int result = Integer.MIN_VALUE;

        int[] consolidated = new int[m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] != 0) {
                    consolidated[j] += arr[i][j];
                } else {
                    consolidated[j] = 0;
                }
            }

            // System.out.println(Arrays.toString(consolidated));
            int[] nextSmaller = nse(consolidated);
            int[] prevSmaller = pse(consolidated);
            // System.out.println(Arrays.toString(nextSmaller));
            // System.out.println(Arrays.toString(prevSmaller));
            for(int j = 0; j < m; j++) {
                // int h = Math.min(consolidated[nextSmaller[j]], consolidated[prevSmaller[j]]);
                int currAns = (nextSmaller[j] - prevSmaller[j] - 1) * consolidated[j];
                // System.out.println(h + " " + currAns);
                result = Math.max(result, currAns);
            }
        }
        
        
        return result;
    }


    int[] pse(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            int temp = arr[i];
            while(!stack.isEmpty() && temp <= arr[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
    
     int[] nse(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            int temp = arr[i];
            while(!stack.isEmpty() && temp <= arr[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}