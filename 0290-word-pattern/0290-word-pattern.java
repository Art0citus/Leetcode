class Solution {
    public boolean wordPattern(String pattern, String s) {
         String[] words = s.split(" ");
        
        // If lengths don't match, bijection is impossible
        if (pattern.length() != words.length) {
            return false;
        }
        
        // Maps to track character-to-word and word-to-character translations
        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];
            
            // Check character to word mapping consistency
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) {
                    return false;
                }
            } else {
                charToWord.put(ch, word);
            }
            
            // Check word to character mapping consistency
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) {
                    return false;
                }
            } else {
                wordToChar.put(word, ch);
            }
        }
        
        return true;
    }
}