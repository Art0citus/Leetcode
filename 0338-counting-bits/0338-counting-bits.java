class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            // State transition: The 1s in 'i' equal the 1s in 'i / 2' 
            // plus 1 if the last digit of 'i' is odd.
            ans[i] = ans[i >> 1] + (i & 1);
        }
        
        return ans;
    }
}