/**
 * @param {string} s
 * @return {string}
 */
const longestPalindrome = function (s) {
    let max = 0;
    let lpd = "";
    for (let i = 0; i < s.length; i++) {
        let j;
        for (j = 0; i - j >= 0 && i + j < s.length; j++) {
            if (s[i - j] !== s[i + j]) break;
        }
        const len = 2 * j - 1;
        if (len > max) lpd = s.substring(i - j + 1, i + j)
        max = Math.max(max, len);
    }
    for (let i = 0; i < s.length - 1; i++) {
        let j;
        for (j = 0; i - j >= 0 && i + j + 1 < s.length; j++) {
            if (s[i - j] !== s[i + j + 1]) break;
        }
        const len = 2 * j;
        if (len > max) lpd = s.substring(i - j + 1, i + j + 1)
        max = Math.max(max, len);
    }
    return lpd
};

console.log(longestPalindrome("babad"));
console.log(longestPalindrome("cbbd"));