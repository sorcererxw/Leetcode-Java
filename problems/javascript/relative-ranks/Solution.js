/**
 * @param {number[]} nums
 * @return {string[]}
 */
const findRelativeRanks = function (nums) {
    const result = []
    nums.map((value, index) => {
        return {v: value, idx: index}
    }).sort((a, b) => {
        if (a.v === b.v) {
            return a.idx < b.idx ? -1 : 1
        } else {
            return a.v > b.v ? -1 : 1
        }
    }).forEach((value, index) => {
        if (index === 0) {
            result[value.idx] = "Gold Medal"
        } else if (index === 1) {
            result[value.idx] = "Silver Medal"
        } else if (index === 2) {
            result[value.idx] = "Bronze Medal"
        } else {
            result[value.idx] = `${index + 1}`
        }
    });
    return result
};

console.log(findRelativeRanks([5, 5, 4, 3, 2, 1]));