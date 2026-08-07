class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
          int n = nums.size();
        int[] ans = new int[n];
        
        for (int i = 0; i < n; i++) {
            int x = nums.get(i);
            
            // If x is even (such as 2), no valid answer exists
            if ((x & 1) == 0) {
                ans[i] = -1;
            } else {
                // Find the lowest unset bit (0) starting from index 1, 
                // which represents the end of the lowest continuous block of 1s.
                for (int j = 1; j < 32; j++) {
                    if (((x >> j) & 1) == 0) {
                        // Unset the bit at position (j - 1)
                        ans[i] = x ^ (1 << (j - 1));
                        break;
                    }
                }
            }
        }
        
        return ans;
    }
}