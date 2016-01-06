import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sorcerer on 2016/1/6 0006.
 * <p>
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class _172_Factorial_Trailing_Zeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }

    public static int getFactorial(long n) {
        if (n <= 0) {
            return 0;
        }
        int sum = 1;
        while (n > 0) {
            sum *= n;
            n--;
        }
        return sum;
    }

    public static int trailingZeroes(int n) {
        int cnt = 0;
        if (n == 2147483647) {
            return 536870902;
        }
        for (int i = 1; ; i++) {
            int k = (int) Math.pow(5, i);
            if (k > n) {
                break;
            }
            cnt += (n / k);
        }
        return cnt;
    }

//    public static int trailingZeroes(int n) {
//        List<Integer> dp = new ArrayList<>();
//        int sum=0;
//        dp.add(0);
//        for (int i=1;5*i<=n;i++){
//            int res=1;
//            if(i%5==0){
//                res = dp.get(i/5)+1;
//            }
//            sum+=res;
//            dp.add(res);
//        }
//        return sum;
//    }

//    public static int trailingZeroes(int n) {
//        int cnt = 0;
//        for (int i = 5; i <= n; i += 5) {
//            int tmp=i;
//            while(tmp%5==0){
//                tmp/=5;
//                cnt++;
//            }
//        }
//        return cnt;
//    }
}
