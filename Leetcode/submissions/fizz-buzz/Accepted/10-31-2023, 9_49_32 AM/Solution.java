// https://leetcode.com/problems/fizz-buzz

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<>();

        helper(1, n, list);

        return list;
    }

    void helper(int i, int n, List<String> list) {
        if(i > n) return;

        if(i % 3 == 0 && i % 5 == 0) list.add("FizzBuzz");
        else if(i % 3 == 0) list.add("Fizz");
        else if(i % 5 == 0) list.add("Buzz");
        else list.add(String.valueOf(i));

        helper(i+1, n, list);
    }
}