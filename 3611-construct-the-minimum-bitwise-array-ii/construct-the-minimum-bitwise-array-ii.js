/**
 * @param {number[]} nums
 * @return {number[]}
 */
var minBitwiseArray = function(nums) {
    const ans = [];

    for (let p of nums) {
        // p = 2 is impossible
        if (p === 2) {
            ans.push(-1);
            continue;
        }

        let count = 0;
        let temp = p;

        // count trailing 1s
        while ((temp & 1) === 1) {
            count++;
            temp >>= 1;
        }

        // minimum x
        ans.push(p - (1 << (count - 1)));
    }

    return ans;
};
