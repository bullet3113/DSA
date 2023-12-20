// https://leetcode.com/problems/palindrome-partitioning

class Solution {
    public List<List<String>> partition(String s) {
        
        List<List<String>> list = new ArrayList<>();
        helper(s, 0, new ArrayList<>(), list);

        return list;
    }

    void helper(String s, int index, List<String> temp, List<List<String>> list) {

            
        if(s.length() == index) {
            list.add(new ArrayList(temp));
        }

        for(int i = index; i < s.length(); i++) {
            if(palindromeChecker(s, index, i)) {
                temp.add(s.substring(index, i+1));
                helper(s, i+1, temp, list);
                temp.remove(temp.size() - 1);
            }
        }
    }

    // palindrome checker
    boolean palindromeChecker(String s, int i, int j) {
        while(i <= j) {
            char start = s.charAt(i);
            char end = s.charAt(j);

            if(start != end) return false;

            i++;
            j--;
        }

        return true;
    }
}