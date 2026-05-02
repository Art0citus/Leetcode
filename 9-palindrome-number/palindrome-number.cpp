class Solution {
public:
    bool isPalindrome(int x) {
                if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Even digits → x == reversedHalf
        // Odd digits → ignore middle digit
        return (x == reversedHalf || x == reversedHalf / 10);
    }

};