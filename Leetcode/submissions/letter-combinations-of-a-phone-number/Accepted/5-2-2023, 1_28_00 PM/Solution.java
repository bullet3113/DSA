// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        helper(digits, "", list, digits.length());
        return list;
    }

    void helper(String up, String p, List<String> list, int len) {
        if(up.isEmpty()) {
            if(p.length() == len && !p.isEmpty())
            list.add(p);
            return;
        }

        int n = up.charAt(0) - '0';
        String c_map = map(n);
        for(int i = 0; i < c_map.length(); i++) {
            helper(up.substring(1), p + c_map.charAt(i), list, len);
            helper(up.substring(1), p, list, len);
        }
    }

    String map(int n) {
        String a[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return a[n-2];
    }
}