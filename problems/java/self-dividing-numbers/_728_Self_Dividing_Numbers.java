import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */
public class _728_Self_Dividing_Numbers {
    private boolean isSelfDividingNumber(int num) {
        return Arrays.stream(String.valueOf(num).split(""))
                .map(s -> s.charAt(0) - '0')
                .allMatch(integer -> integer != 0 && num % integer == 0);
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        return IntStream.range(left, right + 1)
                .boxed()
                .filter(this::isSelfDividingNumber)
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        _728_Self_Dividing_Numbers solution = new _728_Self_Dividing_Numbers();
        System.out.println(solution.selfDividingNumbers(1, 22));
    }
}
