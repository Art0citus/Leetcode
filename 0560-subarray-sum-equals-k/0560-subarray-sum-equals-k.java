class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        
        // Base case: a prefix sum of 0 has occurred 1 time (before elements start)
        prefixMap.put(0, 1);
        
        int currentSum = 0;
        int totalSubarrays = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            // If (currentSum - k) exists, it means a valid subarray ends here
            if (prefixMap.containsKey(currentSum - k)) {
                totalSubarrays += prefixMap.get(currentSum - k);
            }
            
            // Record the current prefix sum into the map
            prefixMap.put(currentSum, prefixMap.getOrDefault(currentSum, 0) + 1);
        }
        
        return totalSubarrays;
    }
}