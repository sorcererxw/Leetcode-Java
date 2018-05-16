import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Author: Sorcerer
 * Date: 2018/4/17
 * Description:
 */
public class _344_Reverse_String {
    public String reverseString(String s) {
       return new StringBuilder(s).reverse().toString();
    }
}
