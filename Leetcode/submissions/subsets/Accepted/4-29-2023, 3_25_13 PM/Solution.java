// https://leetcode.com/problems/subsets

class Solution {
    // public List<List<Integer>> subsets(int[] nums) {
    //     return helper(nums, 0, new ArrayList<>());
    // }

    // List<List<Integer>> helper(int[] nums, int i, ArrayList<Integer> ans) {
    //     List<List<Integer>> list = new ArrayList<>();
    //     if(i == nums.length) {
    //         list.add(ans);
    //         return list;
    //     }

    //     // //exclude case
    //     // ArrayList<Integer> exclude_case = helper(nums, i+1, ans);

    //     // //include case
    //     // ArrayList<Integer> include_case = helper(nums, i+1, ans);

    //     list.add(helper(nums, i+1, ans));
    //     list.add(helper(nums, i+1, ans.add(nums[i])));

    //     return list;
        
    // }

    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    // Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, 0);
    return list;
}

private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
    list.add(new ArrayList<>(tempList));
    for(int i = start; i < nums.length; i++){
        tempList.add(nums[i]);
        backtrack(list, tempList, nums, i + 1);
        tempList.remove(tempList.size() - 1);
    }
}
}