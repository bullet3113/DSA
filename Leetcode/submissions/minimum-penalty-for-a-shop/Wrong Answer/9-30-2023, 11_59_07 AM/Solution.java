// https://leetcode.com/problems/minimum-penalty-for-a-shop

class Solution {
    public int bestClosingTime(String c) {
        char[] ch = c.toCharArray();

        int n = ch.length;

        int min = Integer.MAX_VALUE;
        int h = 0;
        for(int i = 0; i < n; i++) {
            int temp = 0;
            for(int j = 0; j < n; j++) {
                if(j >= i && ch[j] == 'Y') temp++;
                if(i == n-1 && ch[j] == 'N') temp++;
            }

            if(min > temp) {
                min = temp;
                h = i;
            }
        }

        // closing shop at the last hour
        int temp = 0;
        for(int i = 0; i < n; i++) {
            if(ch[i] == 'N') temp++;
        }
        if(min > temp) {
                min = temp;
                h = n;
        }
        return h;
    }
}

// shop open no customer p+1
// shop close customer come p+1