/**
 * @param {number[]} nums
 * @param {number} k
 * @return {boolean}
 */
var containsNearbyDuplicate = function(nums, k) {
   const map = new Map();

    for (let i = 0; i < nums.length; i++) {
        if (map.has(nums[i])) {
            const prevIndex = map.get(nums[i]);
            if (i - prevIndex <= k) {
                return true;
            }
        }
        map.set(nums[i], i);
    }

    return false;
};