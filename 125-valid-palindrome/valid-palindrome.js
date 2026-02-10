/**
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    let left = 0;
    let right = s.length - 1;

    while (left < right) {
        // Move left pointer until alphanumeric
        while (left < right && !isAlphaNum(s[left])) {
            left++;
        }

        // Move right pointer until alphanumeric
        while (left < right && !isAlphaNum(s[right])) {
            right--;
        }

        // Compare lowercase versions
        if (s[left].toLowerCase() !== s[right].toLowerCase()) {
            return false;
        }

        left++;
        right--;
    }

    return true;
};

function isAlphaNum(ch) {
    return /[a-zA-Z0-9]/.test(ch);
};