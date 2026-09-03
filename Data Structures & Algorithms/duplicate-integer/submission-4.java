class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> cache = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            int target = nums[i];
            if(cache.contains(target)){
                return true;
            }else{
                cache.add(nums[i]);
            }
        }
        return false;
    }
}