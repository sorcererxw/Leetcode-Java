/**
 * @param {string} version1
 * @param {string} version2
 * @return {number}
 */
const compareVersion = function (version1, version2) {
    let splits1 = version1.split("\.");
    let splits2 = version2.split("\.");

    const toNum = function (s) {
        if(s===undefined)return 0;
        let num=0;
        for (let i = 0; i < s.length; i++) {
            num = num * 10 + s[i] - '0'
        }
        return num
    };

    for (let i = 0; i < Math.max(splits1.length, splits2.length); i++) {
        let num1 =toNum(splits1[i]);
        let num2 =toNum(splits2[i]);
        if(num1>num2)return 1;
        if(num1<num2)return -1;
    }
    return 0
};

[
    ["0.1", "1.1"],
    ["1.0.1", "1"],
    ["7.5.2.4", "7.5.3"],
    ["1.01", "1.001"],
    ["1.0", "1.0.0"],
].forEach(it => {
    console.log(`${it[0]} ${it[1]} => ${compareVersion(it[0], it[1])}`)
});