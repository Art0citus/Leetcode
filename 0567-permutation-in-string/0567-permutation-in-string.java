class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] frequency = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            frequency[s1.charAt(i) - 'a']++;
            frequency[s2.charAt(i) - 'a']--;
        }

        // Check the first window
        if (allZero(frequency)) return true;

        // Slide the window
        for (int right = s1.length(); right < s2.length(); right++) {
            frequency[s2.charAt(right) - 'a']--;
            frequency[s2.charAt(right - s1.length()) - 'a']++;

            if (allZero(frequency)) return true;
        }

        return false;
    }

    private boolean allZero(int[] frequency) {
        for (int count : frequency) {
            if (count != 0) return false;
        }
        return true;
    }
}