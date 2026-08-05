class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int currentSum = numbers[left] + numbers[right];
            
            if (currentSum == target) {
                // The problem requires 1-indexed results
                return new int[]{left + 1, right + 1};
            } else if (currentSum < target) {
                // Sum is too small, move the left pointer to increase the sum
                left++;
            } else {
                // Sum is too large, move the right pointer to decrease the sum
                right--;
            }
        }
        
        // The problem guarantees exactly one solution, so this line is unreachable
        return new int[]{-1, -1};
    }
}
