// https://leetcode.com/problems/longest-common-prefix

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        String word = strs[0];
        int finalLen = word.length();

        for(int i = 1; i < n; i++) {
            String currWord = strs[i];
            int currLen = currWord.length();

            if(currLen < finalLen) {
                word = word.substring(0, currLen);
                finalLen = word.length();
            } else if(currLen > finalLen) {
                currWord = currWord.substring(0, finalLen);
                currLen = currWord.length();
            }

            // comparison
            for(int j = 0; j < finalLen; j++) {
                char finalCh = word.charAt(j);
                char currCh = currWord.charAt(j);

                if(finalCh != currCh) {
                    word = word.substring(0, j);
                    finalLen = word.length();
                    break;
                }
            }
        }

        return word;
    }
}