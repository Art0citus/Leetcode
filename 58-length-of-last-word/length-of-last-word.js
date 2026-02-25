/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function(s) {
    let length = 0;
    let i = s.length - 1;

    // Phase 1: Skip trailing spaces
    while (i >= 0 && s[i] === ' ') {
        i--;
    }

    // Phase 2: Count last word length
    while (i >= 0 && s[i] !== ' ') {
        length++;
        i--;
    }

    return length;
};