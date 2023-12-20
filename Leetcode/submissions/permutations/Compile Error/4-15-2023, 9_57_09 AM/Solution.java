// https://leetcode.com/problems/permutations

// class Solution {
//     public List<List<Integer>> permute(int[] nums) {
        
//     }
// }

class Solution { void solve(int[] nums, int i, List<List<Integer>> result) { //base case if (i == nums.length) { List<Integer> al = Arrays.asList(nums); result.add(al); return; } for (int j = i; j < nums.length; j++) { int tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp; solve(nums, i + 1, result); tmp = nums[i]; nums[i] = nums[j]; nums[j] = tmp; } } public List<List<Integer>> permute(int[] nums) { List<List<Integer>> result = new ArrayList<>(); solve(nums, 0, result); return result; } }