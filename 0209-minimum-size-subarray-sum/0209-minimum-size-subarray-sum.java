class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;
        int left = 0;

        // Expand the window using the 'right' pointer
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // Shrink the window from the left as long as the condition is met
            while (currentSum >= target) {
                // Track the minimal length found so far
                minLength = Math.min(minLength, right - left + 1);
                
                // Subtract the element leaving the window and move left forward
                currentSum -= nums[left];
                left++;
            }
        }

        // If minLength was never updated, it means no valid subarray exists
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}