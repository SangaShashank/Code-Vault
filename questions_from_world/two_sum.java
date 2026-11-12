/*Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.

Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in any order.

Example 1:
Input: nums = [1, 6, 2, 10, 3], target = 7

Output: [0, 1]

Explanation:

nums[0] + nums[1] = 1 + 6 = 7

Example 2:
Input: nums = [1, 3, 5, -7, 6, -3], target = 0

Output: [1, 5]

Explanation:

nums[1] + nums[5] = 3 + (-3) = 0 */
//optimal 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int partner = target - nums[i];

            if (map.containsKey(partner)) {          // step 2: check first
                return new int[]{map.get(partner), i};
            }
            map.put(nums[i], i);                     // step 3: store after
        }
        return new int[]{-1, -1}; // never reached
    }
}
class Solution {
    public int[] twoSum(int[] nums, int target) {
      for(int i=0;i<nums.length-1;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target) return new int[]{i,j};
        }
      }
    return new int[]{-1,-1,};// never reaches 
    }
}
//https://claude.ai/share/510af7ac-3da7-4f99-8108-03ff183a0df2