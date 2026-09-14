class Solution {
    public int maxSubArray(int[] nums) {
        int current = 0;
        int max = nums[0];

        for (int num : nums) {

            current = Math.max(current + num, num);

            max = Math.max(max, current);
        }

        return max;
    }
}