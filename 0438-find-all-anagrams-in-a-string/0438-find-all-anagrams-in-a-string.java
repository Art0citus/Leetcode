class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        // Edge case: if p is longer than s, it's impossible to find an anagram
        if (s.length() < p.length()) {
            return result;
        }

        int[] frequency = new int[26];

        // Step 1: Count characters in p (increment)
        for (int i = 0; i < p.length(); i++) {
            frequency[p.charAt(i) - 'a']++;
        }

        // Step 2: Build the initial window in s (decrement)
        for (int i = 0; i < p.length(); i++) {
            frequency[s.charAt(i) - 'a']--;
        }

        // Step 3: Check the very first window
        if (isMatch(frequency)) {
            result.add(0);
        }

        // Step 4: Slide the window across the rest of string s
        for (int right = p.length(); right < s.length(); right++) {
            // Add the new character entering the window from the right
            frequency[s.charAt(right) - 'a']--;

            // Remove the character leaving the window from the left
            int left = right - p.length();
            frequency[s.charAt(left) - 'a']++;

            // If all frequencies balance out to 0, we found an anagram
            if (isMatch(frequency)) {
                result.add(left + 1); // The start index of the current window
            }
        }

        return result;
    }

    // Helper method to verify if the window is a perfect anagram match
    private boolean isMatch(int[] frequency) {
        for (int count : frequency) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}