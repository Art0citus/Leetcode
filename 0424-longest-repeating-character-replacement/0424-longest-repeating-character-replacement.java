class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int maxFrequency = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            frequency[s.charAt(right) - 'A']++;

            maxFrequency = Math.max(
                maxFrequency,
                frequency[s.charAt(right) - 'A']
            );

            while ((right - left + 1) - maxFrequency > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            int length = right - left + 1;
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}