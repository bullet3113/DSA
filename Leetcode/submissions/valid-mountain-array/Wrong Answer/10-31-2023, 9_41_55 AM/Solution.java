// https://leetcode.com/problems/valid-mountain-array

class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        if(n < 3) return false;

        int start = 0, end = n-1;

        while(start < end) {
            if(arr[start] < arr[start+1]) start++;
            else if(arr[start] == arr[start+1]) return false;

            if(arr[end] < arr[end-1]) end--;
            else if(arr[end] == arr[end-1]) return false;

            if(end-1 == start+1 && arr[start] > arr[start+1] && arr[end] > arr[end-1]) return false;
        }

        if(start == end) return true;

        return false;

        // bruteforce
        // iterate till increasing
        // then iterate till decreasing
        // if at any point value got greater in decreasing iteration 
        // return false
    }
}