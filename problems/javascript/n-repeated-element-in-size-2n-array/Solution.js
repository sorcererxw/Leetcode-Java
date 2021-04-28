/**
 * 看作是一个环，如果有1/2的元素相同，那么必然有相同的元素的间隔<=2
 * @param {number[]} A
 * @return {number}
 */
const repeatedNTimes = function (A) {
    for (let i = 0; i < A.length; i++) {
        const it = A[i];
        const last = i >= 1 ? A[i - 1] : A[A.length - (1 - i)];
        const llast = i >= 2 ? A[i - 2] : A[A.length - (2 - i)];
        if (it === last || it === llast) return A[i]
    }
    return undefined
};