// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards

class Solution {
    public int maxScore(int[] arr, int k) {
        int sum = 0;
        int n = arr.length;

        int i = 0; // head pointer
        int j = n-1; // tail pointer

        while(i <= j && k > 0) {
            if(sum + arr[i] > sum + arr[j]) {
                sum += arr[i];
                i++;
            } else if(sum + arr[i] < sum + arr[j]) {
                sum += arr[j];
                j--;
            } else {
                int x = i, y = j;
                while(x < y && sum + arr[i] == sum + arr[j]) {
                    x++;
                    y--;
                }

                if(x < y && sum + arr[x] > sum + arr[y]) {
                    sum += arr[i];
                    i++;
                } else if(x < y && sum + arr[x] < sum + arr[y]) {
                    sum += arr[j];
                    j--;
                } else {
                    sum += arr[i];
                    i++;
                }
            }

            k--;
        }

        return sum;
    }
}