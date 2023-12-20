// https://leetcode.com/problems/compare-version-numbers

class Solution {
    public int compareVersion(String version1, String version2) {
        int v1 = 0, v2 = 0; // for tracking the version count
        String[] v1Ans = version1.split("[.]");
        String[] v2Ans = version2.split("[.]");

        for(int i = 0; i < Math.min(v1Ans.length, v2Ans.length); i++) {

            int a = Integer.parseInt(v1Ans[i]);
            int b = Integer.parseInt(v2Ans[i]);

            // while((a % 10) == 0) a /= 10;
            // while((b % 10) == 0) b /= 10;
            v1+= a;
            v2 += b;
            if(a > b) return 1;
            else if(b > a) return -1;
        }

        if(v1Ans.length > v2Ans.length) {
            int i = v2Ans.length;
            while(i < v1Ans.length) v1 += Integer.parseInt(v1Ans[i++]);
            if(v1 > v2) return 1;
        }
        else if (v2Ans.length > v1Ans.length) {
            int i = v1Ans.length;
            while(i < v2Ans.length) v2 += Integer.parseInt(v2Ans[i++]);
            if(v2 > v1) return -1;
        }

        // System.out.println(Arrays.toString(v1Ans));
        // System.out.println(Arrays.toString(v2Ans));
        return 0;
    }

    String[] getParts(String version) {
        String v1Ans = "0";
        for(int i = 0; i < version.length(); i++) {
            char ch = version.charAt(i);

            if(v1Ans.charAt(v1Ans.length() - 1) == '.' && ch == '.' || ch == '0') 
                continue;
            
            v1Ans += ch;
        }

        String[] arr = v1Ans.split("[.]");

        return arr;
    }
}