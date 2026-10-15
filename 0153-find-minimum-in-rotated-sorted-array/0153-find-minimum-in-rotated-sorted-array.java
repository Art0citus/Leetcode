class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Loop finishes when left == right, pointing directly to the minimum
        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid element is greater than right element, min is in the right half
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } 
            // Otherwise, min is at mid or in the left half
            else {
                right = mid;
            }
        }

        // left and right converge to the index of the minimum element
        return nums[left];
    }
}