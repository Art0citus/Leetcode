import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;

        for (int right = 0; right < nums.length; right++) {

            // Remove indices outside the window
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                   nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);

            // Record maximum once the first window is complete
            if (right >= k - 1) {
                result[index] = nums[deque.peekFirst()];
                index++;
            }
        }

        return result;
    }
}