/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    const map = new Map();
    let sum = 0;
    let maxLen = 0;
    map.set(0, -1);

    for (let i = 0; i < nums.length; i++) {
        sum += nums[i] === 1 ? 1 : -1;

        if (map.has(sum)) {
            maxLen = Math.max(maxLen, i - map.get(sum));
        } else {
            map.set(sum, i);
        }
    }

    return maxLen;
};
