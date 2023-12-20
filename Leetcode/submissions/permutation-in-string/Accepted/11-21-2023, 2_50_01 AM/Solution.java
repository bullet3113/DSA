// https://leetcode.com/problems/permutation-in-string

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        // fixed window size length of s1

        char[] chars = s1.toCharArray();
        Arrays.sort(chars);
        String sortedS1 = String.valueOf(chars);

        int len = chars.length;

        for(int i = 0; i <= s2.length() - len; i++) {

            String sample = s2.substring(i, i+len);
            chars = sample.toCharArray();
            Arrays.sort(chars);
            sample = String.valueOf(chars);
            // System.out.println(sample);
            if(sortedS1.equals(sample)) return true;
        }

        return false;
    }
}