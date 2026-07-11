class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Put all numbers into the HashSet
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        // Iterate through unique numbers
        for (int num : set) {

            // Only start counting if this is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int length = 1;

                // Extend the sequence
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                // Update the longest sequence found
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}