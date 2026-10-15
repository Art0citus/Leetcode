class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;

        // Move pointers inward until they meet
        while (left < right) {
            // Width is the distance between the two pointers
            int width = right - left;
            
            // Height of the container is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate the water volume and update maxWater if it's larger
            int currentWater = width * currentHeight;
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer that points to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}