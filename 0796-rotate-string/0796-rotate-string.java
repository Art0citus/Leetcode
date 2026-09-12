class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Check if goal is a substring of s + s
        String doubled = s + s;
        return doubled.contains(goal);
    }
}