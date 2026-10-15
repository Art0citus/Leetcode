class Solution {
    public int[][] merge(int[][] intervals) {
        // Edge case: if there's only 1 or 0 intervals, no merging is needed
        if (intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals by their start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> mergedList = new ArrayList<>();
        
        // Initialize our tracking interval with the first element
        int[] currentInterval = intervals[0];
        mergedList.add(currentInterval);

        // Step 2: Iterate through the remaining intervals and merge if necessary
        for (int i = 1; i < intervals.length; i++) {
            int[] nextInterval = intervals[i];

            // If the next interval's start time is <= the current interval's end time, they overlap
            if (nextInterval[0] <= currentInterval[1]) {
                // Merge them by extending the end time to the maximum of both
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
            } else {
                // No overlap, move onto the next interval and add it to our list
                currentInterval = nextInterval;
                mergedList.add(currentInterval);
            }
        }

        // Convert the List back into a 2D array for the final answer
        return mergedList.toArray(new int[mergedList.size()][]);
    }
}