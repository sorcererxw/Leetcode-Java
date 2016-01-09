import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Sorcerer on 2016/1/9 0009.
 * <p>
 * https://leetcode.com/problems/reverse-bits/
 */
public class _190_Reverse_Bits {

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int sum = 0;
        for (int i = 0; i<32; i++) {
            sum = sum << 1 | (n & 1);
            n >>>= 1;
        }
        return sum;
    }

//    public static int reverseBits(int n) {
//        int sum = 0;
//        Stack<Boolean> stack = new Stack<>();
//        while (n > 0) {
//            if ((n & 1) == 1) {
//                stack.push(true);
//            } else {
//                stack.push(false);
//            }
//            n >>>= 1;
//        }
//        int k = 1;
//        while (!stack.isEmpty()){
//            if (stack.pop()) {
//                sum += k;
//            }
//            k *= 2;
//        }
//        return sum;
//    }
}
//101
//421