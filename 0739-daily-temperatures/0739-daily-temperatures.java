class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
         int n = temperatures.length;
        int[] result = new int[n];
        // The stack will store the indices of the days
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            // While the stack is not empty and the current day's temperature 
            // is warmer than the temperature at the index on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                // The number of days to wait is the difference between indices
                result[prevIndex] = i - prevIndex;
            }
            // Push the current day's index onto the stack
            stack.push(i);
        }

        return result;
    }
}