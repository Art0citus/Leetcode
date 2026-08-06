class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLen = 0;
        map.put(0, -1); // Base case for sum 0 at index -1

        for (int i = 0; i < nums.length; i++) {
            // Add 1 for 1, and -1 for 0
            sum += (nums[i] == 1) ? 1 : -1;

            if (map.containsKey(sum)) {
                // Calculate length and update maxLen
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                // Store the first occurrence of this sum
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}