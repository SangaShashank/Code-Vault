class Solution {
    public int subarraySum(int[] nums, int k) {
        int l = 0;
        int sum = 0;
        int count = 0;
        for(int r=0;r<nums.length;r++){
            sum += nums[r];
            while(sum >k) {
                sum -= nums[l];
                l++;
            }
            if(sum == k) count ++;
        }
        return count;
    }
}