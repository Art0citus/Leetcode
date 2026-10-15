class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency array for characters in t (ASCII extended to 128 characters)
        int[] targetMap = new int[128];
        for (char c : t.toCharArray()) {
            targetMap[c]++;
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        
        // 'count' tracks how many unique/required characters from t are currently satisfied in the window
        int count = t.length();

        // Expand the window using the 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);

            // If this character is needed by t, decrement our overall remaining count requirement
            if (targetMap[rightChar] > 0) {
                count--;
            }
            // Decrement the character's frequency in our target map
            targetMap[rightChar]--;

            // When the window is valid (contains all characters of t)
            while (count == 0) {
                // Update the minimum window metrics if a smaller one is found
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);
                // We are about to eject 'leftChar' from the window. Increment its map count back.
                targetMap[leftChar]++;

                // If this character was a strict requirement for t and its count goes above 0,
                // our window becomes invalid.
                if (targetMap[leftChar] > 0) {
                    count++;
                }
                
                // Shrink the window
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + minLen);
    
    }
}