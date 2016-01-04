/**
 * Created by Sorcerer on 2016/1/4 0004.
 * <p>
 * https://leetcode.com/problems/number-of-1-bits/
 */
public class _191_Number_of_1_Bits {

    public static void main(String[] args) {
//        System.out.println(hammingWeight(2147483648));
    }

    // 2147483648 (10000000000000000000000000000000)
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n = n >>> 1; //无符号右移, 高位补0
        }
        return cnt;
    }
}
