class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;

        // Expand the window using the 'right' pointer
        for (int right = 0; right < nums.length; right++) {
            // If we encounter a 0, it costs 1 flip
            if (nums[right] == 0) {
                k--;
            }

            // If we used more than k flips, shrink the window from the left
            while (k < 0) {
                if (nums[left] == 0) {
                    k++; // Regain a flip as the 0 leaves the window
                }
                left++; // Shrink the window
            }

            // Calculate the maximum window size achieved so far
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}