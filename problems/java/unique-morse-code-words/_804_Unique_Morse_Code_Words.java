package solution._804_;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Author: Sorcerer
 * Date: 2018/4/15
 * Description:
 */


public class _804_Unique_Morse_Code_Words {
    static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            final String[] mouse =
                    new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                            "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            return (int) Arrays.stream(words)
                    .map(s -> IntStream.range(0, s.length())
                            .mapToObj(s::charAt)
                            .map(character -> mouse[character - 'a'])
                            .collect(Collectors.joining()))
                    .distinct()
                    .count();
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(
                solution.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"})
        );
    }
}
