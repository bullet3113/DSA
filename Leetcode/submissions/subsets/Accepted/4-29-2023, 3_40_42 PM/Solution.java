// https://leetcode.com/problems/subsets

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> list = new ArrayList<>();
        helper(list, nums, 0, new ArrayList<>());
        return list;
    }

    void helper(List<List<Integer>> list, int[] nums, int i, ArrayList<Integer> ans) {
       
        if(i >= nums.length) {
            list.add(new ArrayList<>(ans));
            // ans.clear();
            return;
        }

        
        // //exclude case
        // ArrayList<Integer> exclude_case = helper(nums, i+1, ans);

        // //include case
        // ArrayList<Integer> include_case = helper(nums, i+1, ans);
        ans.add(nums[i]);
         helper(list, nums, i+1, ans);
        //  if(ans.size()  > 0)
        ans.remove(ans.size()-1);
        helper(list, nums, i+1, ans);
    }

//     public List<List<Integer>> subsets(int[] nums) {
//     List<List<Integer>> list = new ArrayList<>();
//     // Arrays.sort(nums);
//     backtrack(list, new ArrayList<>(), nums, 0);
//     return list;
// }

// private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
//     list.add(new ArrayList<>(tempList));
//     for(int i = start; i < nums.length; i++){
//         tempList.add(nums[i]);
//         backtrack(list, tempList, nums, i + 1);
//         tempList.remove(tempList.size() - 1);
//     }
// }
}